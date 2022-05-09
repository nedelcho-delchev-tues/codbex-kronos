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
package com.codbex.kronos.hdb.ds.service.manager;

import com.codbex.kronos.hdb.ds.api.IXSKDataStructureModel;
import com.codbex.kronos.hdb.ds.api.IXSKHdbProcessor;
import com.codbex.kronos.hdb.ds.api.XSKDataStructuresException;
import com.codbex.kronos.hdb.ds.model.hdbtable.XSKDataStructureHDBTableModel;
import com.codbex.kronos.hdb.ds.processors.table.XSKTableAlterProcessor;
import com.codbex.kronos.hdb.ds.processors.table.XSKTableCreateProcessor;
import com.codbex.kronos.hdb.ds.processors.table.XSKTableDropProcessor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XSKTableManagerService extends AbstractDataStructureManagerService<XSKDataStructureHDBTableModel> {

  private static final Logger logger = LoggerFactory.getLogger(XSKTableManagerService.class);

  private final Map<String, XSKDataStructureHDBTableModel> dataStructureTableModels;
  private final List<String> tablesSynchronized;

  private IXSKHdbProcessor xskTableCreateProcessor = new XSKTableCreateProcessor();
  private IXSKHdbProcessor xskTableDropProcessor = new XSKTableDropProcessor();
  private IXSKHdbProcessor xskTableAlterProcessor = new XSKTableAlterProcessor();


  public XSKTableManagerService() {
    dataStructureTableModels = new LinkedHashMap<>();
    tablesSynchronized = Collections.synchronizedList(new ArrayList<>());
  }

  public void synchronizeRuntimeMetadata(XSKDataStructureHDBTableModel tableModel)
      throws XSKDataStructuresException {
    if (!getDataStructuresCoreService().existsDataStructure(tableModel.getLocation(), tableModel.getType())) {
      getDataStructuresCoreService()
          .createDataStructure(tableModel.getLocation(), tableModel.getName(), tableModel.getHash(), tableModel.getType());
      dataStructureTableModels.put(tableModel.getName(), tableModel);
      logger.info("Synchronized a new Table file [{}] from location: {}", tableModel.getName(), tableModel.getLocation());
    } else {
      XSKDataStructureHDBTableModel existing = getDataStructuresCoreService()
          .getDataStructure(tableModel.getLocation(), tableModel.getType());
      if (!tableModel.equals(existing)) {
        getDataStructuresCoreService().updateDataStructure(tableModel.getLocation(), tableModel.getName(), tableModel.getHash(),
            tableModel.getType());
        dataStructureTableModels.put(tableModel.getName(), tableModel);
        logger.info("Synchronized a modified Table file [{}] from location: {}", tableModel.getName(),
            tableModel.getLocation());
      }
    }
    if (!tablesSynchronized.contains(tableModel.getLocation())) {
      tablesSynchronized.add(tableModel.getLocation());
    }
  }

  public boolean createDataStructure(Connection connection, XSKDataStructureHDBTableModel tableModel)
      throws SQLException {
	return this.xskTableCreateProcessor.execute(connection, tableModel);
  }

  public boolean dropDataStructure(Connection connection, XSKDataStructureHDBTableModel tableModel)
      throws SQLException {
	return this.xskTableDropProcessor.execute(connection, tableModel);
  }

  public boolean updateDataStructure(Connection connection, XSKDataStructureHDBTableModel tableModel)
      throws SQLException {
    //TODO: Create logic for updating hdb table
    logger.error("Altering of a non-empty table is not implemented yet.");
    // TableAlterProcessor.execute(connection, tableModel);
    return xskTableAlterProcessor.execute(connection, tableModel);
  }

  public Map<String, XSKDataStructureHDBTableModel> getDataStructureModels() {
    return this.dataStructureTableModels;
  }

  public List<String> getDataStructureSynchronized() {
    return this.tablesSynchronized;
  }

  @Override
  public String getDataStructureType() {
    return IXSKDataStructureModel.FILE_EXTENSION_TABLE;
  }

  @Override
  public void clearCache() {
    dataStructureTableModels.clear();
  }
}
