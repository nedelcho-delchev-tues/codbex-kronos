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
package com.codbex.kronos.hdb.ds.processors.hdbschema;

import com.codbex.kronos.hdb.ds.artefacts.HDBSchemaSynchronizationArtefactType;
import com.codbex.kronos.hdb.ds.model.hdbschema.XSKDataStructureHDBSchemaModel;
import com.codbex.kronos.hdb.ds.processors.AbstractXSKProcessor;
import com.codbex.kronos.utils.XSKCommonsConstants;
import com.codbex.kronos.utils.XSKCommonsUtils;
import com.codbex.kronos.utils.XSKHDBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import org.eclipse.dirigible.core.scheduler.api.ISynchronizerArtefactType.ArtefactState;
import org.eclipse.dirigible.database.sql.DatabaseArtifactTypes;
import org.eclipse.dirigible.database.sql.ISqlDialect;
import org.eclipse.dirigible.database.sql.SqlFactory;
import org.eclipse.dirigible.database.sql.dialects.hana.HanaSqlDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HDBSchemaDropProcessor extends AbstractXSKProcessor<XSKDataStructureHDBSchemaModel> {

  private static final Logger logger = LoggerFactory.getLogger(HDBSchemaDropProcessor.class);
  private static final HDBSchemaSynchronizationArtefactType SCHEMA_ARTEFACT = new HDBSchemaSynchronizationArtefactType();

  public boolean execute(Connection connection, XSKDataStructureHDBSchemaModel hdbSchema)
      throws SQLException {
    logger.info("Processing Drop Schema: " + hdbSchema.getSchema());

    ISqlDialect dialect = SqlFactory.deriveDialect(connection);
    if (!(dialect.getClass().equals(HanaSqlDialect.class))) {
      String errorMessage = String.format("%s does not support Schema", dialect.getDatabaseName(connection));
      XSKCommonsUtils.logProcessorErrors(errorMessage, XSKCommonsConstants.PROCESSOR_ERROR, hdbSchema.getLocation(),
          XSKCommonsConstants.HDB_SCHEMA_PARSER);
      applyArtefactState(hdbSchema.getName(), hdbSchema.getLocation(), SCHEMA_ARTEFACT, ArtefactState.FAILED_DELETE, errorMessage);
      throw new IllegalStateException(errorMessage);
    } else {
      if (SqlFactory.getNative(connection).exists(connection, hdbSchema.getSchema(), DatabaseArtifactTypes.SCHEMA)) {
        String schemaName = XSKHDBUtils.escapeArtifactName(hdbSchema.getSchema());
        String sql = SqlFactory.getNative(connection).drop().schema(schemaName).build();
        try {
          executeSql(sql, connection);
          String message = String.format("Drop schema %s successfully", hdbSchema.getName());
          applyArtefactState(hdbSchema.getName(), hdbSchema.getLocation(), SCHEMA_ARTEFACT, ArtefactState.SUCCESSFUL_DELETE, message);
          return true;
        } catch (SQLException ex) {
          String message = String.format("Drop schema[%s] skipped due to an error: %s", hdbSchema, ex.getMessage());
          XSKCommonsUtils.logProcessorErrors(ex.getMessage(), XSKCommonsConstants.PROCESSOR_ERROR, hdbSchema.getLocation(),
              XSKCommonsConstants.HDB_SCHEMA_PARSER);
          applyArtefactState(hdbSchema.getName(), hdbSchema.getLocation(), SCHEMA_ARTEFACT, ArtefactState.FAILED_DELETE, message);
          return false;
        }
      } else {
        String warningMessage = String.format("Schema [%s] does not exists during the drop process", hdbSchema.getSchema());
        logger.warn(warningMessage);
        applyArtefactState(hdbSchema.getName(), hdbSchema.getLocation(), SCHEMA_ARTEFACT, ArtefactState.FAILED_DELETE, warningMessage);
        return true;
      }
    }
  }
}
