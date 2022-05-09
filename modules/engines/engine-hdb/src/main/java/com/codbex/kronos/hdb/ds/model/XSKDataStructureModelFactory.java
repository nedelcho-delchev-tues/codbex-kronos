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
package com.codbex.kronos.hdb.ds.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.codbex.kronos.exceptions.XSKArtifactParserException;
import com.codbex.kronos.hdb.ds.api.XSKDataStructuresException;
import com.codbex.kronos.hdb.ds.model.hdbschema.XSKDataStructureHDBSchemaModel;
import com.codbex.kronos.hdb.ds.model.hdbsynonym.XSKDataStructureHDBSynonymModel;
import com.codbex.kronos.hdb.ds.model.hdbtable.XSKDataStructureHDBTableModel;
import com.codbex.kronos.hdb.ds.model.hdbtabletype.XSKDataStructureHDBTableTypeModel;
import com.codbex.kronos.hdb.ds.model.hdbview.XSKDataStructureHDBViewModel;
import com.codbex.kronos.hdb.ds.parser.hdbdd.XSKHdbddParser;
import com.codbex.kronos.hdb.ds.parser.hdbschema.XSKSchemaParser;
import com.codbex.kronos.hdb.ds.parser.hdbsynonym.XSKSynonymParser;
import com.codbex.kronos.hdb.ds.parser.hdbtable.XSKTableParser;
import com.codbex.kronos.hdb.ds.parser.hdbtabletype.XSKTableTypeParser;
import com.codbex.kronos.hdb.ds.parser.hdbview.XSKViewParser;
import com.codbex.kronos.utils.XSKCommonsConstants;

/**
 * The factory for creation of the data structure models from source content.
 */
public class XSKDataStructureModelFactory {

  static Map<String, String> TYPES_MAP = new HashMap<>();

  static {
    TYPES_MAP.put("String", "VARCHAR");
    TYPES_MAP.put("UTCTimestamp", "TIMESTAMP");
  }

  /**
   * Creates a table model from the raw content.
   *
   * @param content the table definition
   * @return the table model instance
   */
  public static XSKDataStructureHDBTableModel parseTable(String location, String content)
      throws XSKDataStructuresException, XSKArtifactParserException, IOException {
    XSKTableParser parser = new XSKTableParser();
    XSKDataStructureParametersModel parametersModel =
        new XSKDataStructureParametersModel(null, location, content, null);
    return parser.parse(parametersModel);
  }

  /**
   * Creates a table model from the raw content.
   *
   * @param bytes the table definition
   * @return the table model instance
   */
  public static XSKDataStructureHDBTableModel parseTable(String location, byte[] bytes)
      throws XSKDataStructuresException, XSKArtifactParserException, IOException {
    return parseTable(location, new String(bytes));
  }

  /**
   * Creates a view model from the raw content.
   *
   * @param content the view definition
   * @return the view model instance
   */
  public static XSKDataStructureHDBViewModel parseView(String location, String content)
      throws XSKDataStructuresException, XSKArtifactParserException, IOException {
    XSKViewParser parser = new XSKViewParser();
    XSKDataStructureParametersModel parametersModel =
        new XSKDataStructureParametersModel(null, location, content, null);
    return parser.parse(parametersModel);
  }

  public static XSKDataStructureModel parseHdbdd(String location, String content) throws XSKDataStructuresException, IOException {
    XSKHdbddParser parser = new XSKHdbddParser();
    XSKDataStructureParametersModel parametersModel =
        new XSKDataStructureParametersModel(null, location, content, XSKCommonsConstants.XSK_REGISTRY_PUBLIC);
    return parser.parse(parametersModel);
  }

  /**
   * Creates a view model from the raw content.
   *
   * @param bytes the view definition
   * @return the view model instance
   */
  public static XSKDataStructureHDBViewModel parseView(String location, byte[] bytes)
      throws XSKDataStructuresException, XSKArtifactParserException, IOException {
    return parseView(location, new String(bytes));
  }

  /**
   * Creates a synonym model from the raw content.
   *
   * @param content the synonym definition
   * @return the synonym model instance
   */
  public static XSKDataStructureHDBSynonymModel parseSynonym(String location, String content)
      throws XSKDataStructuresException, IOException {
    XSKSynonymParser parser = new XSKSynonymParser();
    XSKDataStructureParametersModel parametersModel =
        new XSKDataStructureParametersModel(null, location, content, null);
    return parser.parse(parametersModel);
  }

  /**
   * Creates a schema model from the raw content.
   *
   * @param content the schema definition
   * @return the schema model instance
   */
  public static XSKDataStructureHDBSchemaModel parseSchema(String location, String content)
      throws XSKDataStructuresException, XSKArtifactParserException, IOException {
    XSKSchemaParser parser = new XSKSchemaParser();
    XSKDataStructureParametersModel parametersModel =
        new XSKDataStructureParametersModel(null, location, content, null);
    return parser.parse(parametersModel);
  }

  /**
   * Creates a schema model from the raw content.
   *
   * @param bytes the schema definition
   * @return the schema model instance
   */
  public static XSKDataStructureHDBSchemaModel parseSchema(String location, byte[] bytes)
      throws XSKDataStructuresException, XSKArtifactParserException, IOException {
    return parseSchema(location, new String(bytes));
  }

  /**
   * Creates a table type model from the raw content.
   *
   * @param content the table type definition
   * @return the table type model instance
   */
  public static XSKDataStructureHDBTableTypeModel parseTableType(String location, String content)
      throws XSKDataStructuresException, XSKArtifactParserException, IOException {
    XSKTableTypeParser parser = new XSKTableTypeParser();
    XSKDataStructureParametersModel parametersModel =
        new XSKDataStructureParametersModel(null, location, content, null);
    return parser.parse(parametersModel);
  }

  /**
   * Creates a table type model from the raw content.
   *
   * @param bytes the table type definition
   * @return the table type model instance
   */
  public static XSKDataStructureHDBTableTypeModel parseTableType(String location, byte[] bytes)
      throws XSKDataStructuresException, XSKArtifactParserException, IOException {
    return parseTableType(location, new String(bytes));
  }
}