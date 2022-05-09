/*
 * Copyright (c) 2022 codbex or an codbex affiliate company and contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2022 codbex or an codbex affiliate company and contributors
 * SPDX-License-Identifier: EPL-2.0
 */
package com.codbex.kronos.hdb.ds.processors.hdbprocedure;

import java.sql.Connection;
import java.sql.SQLException;

import org.eclipse.dirigible.core.scheduler.api.ISynchronizerArtefactType.ArtefactState;
import org.eclipse.dirigible.database.sql.DatabaseArtifactTypes;
import org.eclipse.dirigible.database.sql.ISqlDialect;
import org.eclipse.dirigible.database.sql.SqlFactory;
import org.eclipse.dirigible.database.sql.dialects.hana.HanaSqlDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codbex.kronos.hdb.ds.artefacts.HDBProcedureSynchronizationArtefactType;
import com.codbex.kronos.hdb.ds.model.hdbprocedure.XSKDataStructureHDBProcedureModel;
import com.codbex.kronos.hdb.ds.processors.AbstractXSKProcessor;
import com.codbex.kronos.utils.XSKCommonsConstants;
import com.codbex.kronos.utils.XSKCommonsUtils;
import com.codbex.kronos.utils.XSKConstants;

public class HDBProcedureCreateProcessor extends AbstractXSKProcessor<XSKDataStructureHDBProcedureModel> {

  private static final Logger logger = LoggerFactory.getLogger(HDBProcedureCreateProcessor.class);
  private static final HDBProcedureSynchronizationArtefactType PROCEDURE_ARTEFACT = new HDBProcedureSynchronizationArtefactType();

  public boolean execute(Connection connection, XSKDataStructureHDBProcedureModel hdbProcedure)
      throws SQLException {
    logger.info("Processing Create Procedure: " + hdbProcedure.getName());
    String procedureNameWithoutSchema = XSKCommonsUtils.extractArtifactNameWhenSchemaIsProvided(hdbProcedure.getName())[1];
    hdbProcedure.setSchema(XSKCommonsUtils.extractArtifactNameWhenSchemaIsProvided(hdbProcedure.getName())[0]);

    if (!SqlFactory.getNative(connection).exists(connection, procedureNameWithoutSchema, DatabaseArtifactTypes.PROCEDURE)) {
      ISqlDialect dialect = SqlFactory.deriveDialect(connection);
      if (!(dialect.getClass().equals(HanaSqlDialect.class))) {
        String errorMessage = String.format("Procedures are not supported for %s", dialect.getDatabaseName(connection));
        XSKCommonsUtils.logProcessorErrors(errorMessage, XSKCommonsConstants.PROCESSOR_ERROR, hdbProcedure.getLocation(), XSKCommonsConstants.HDB_PROCEDURE_PARSER);
        applyArtefactState(hdbProcedure.getName(), hdbProcedure.getLocation(), PROCEDURE_ARTEFACT, ArtefactState.FAILED_CREATE, errorMessage);
        throw new IllegalStateException(errorMessage);
      } else {
        String sql = XSKConstants.XSK_HDBPROCEDURE_CREATE + hdbProcedure.getContent();
        try {
          String message = String.format("Create procedure %s successfully", hdbProcedure.getName());
          executeSql(sql, connection);
          applyArtefactState(hdbProcedure.getName(), hdbProcedure.getLocation(), PROCEDURE_ARTEFACT, ArtefactState.SUCCESSFUL_CREATE, message);
          return true;
        } catch (SQLException ex) {
          String message = String.format("Create procedure[%s] skipped due to an error: %s", hdbProcedure, ex.getMessage());
          XSKCommonsUtils.logProcessorErrors(ex.getMessage(), XSKCommonsConstants.PROCESSOR_ERROR, hdbProcedure.getLocation(), XSKCommonsConstants.HDB_PROCEDURE_PARSER);
          applyArtefactState(hdbProcedure.getName(), hdbProcedure.getLocation(), PROCEDURE_ARTEFACT, ArtefactState.FAILED_CREATE, message);
          return false;
        }
      }
    } else {
      String warningMessage = String.format("Procedure [%s] already exists during the create process", hdbProcedure.getName());
      logger.warn(warningMessage);
      applyArtefactState(hdbProcedure.getName(), hdbProcedure.getLocation(), PROCEDURE_ARTEFACT, ArtefactState.FAILED_CREATE, warningMessage);
      return false;
    }
  }
}
