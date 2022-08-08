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
package com.codbex.kronos.hdb.ds.model.hdbdd;

import java.util.ArrayList;
import java.util.List;

import com.codbex.kronos.hdb.ds.model.DataStructureModel;
import com.codbex.kronos.hdb.ds.model.hdbtable.DataStructureHDBTableColumnModel;
import com.codbex.kronos.hdb.ds.model.hdbtable.DataStructureHDBTableConstraintsModel;
import com.codbex.kronos.hdb.ds.model.hdbtable.DataStructureHDBTableIndexModel;

/**
 * The table model representation.
 */
public class DataStructureEntityModel extends DataStructureModel {

  /** The columns. */
  private List<DataStructureHDBTableColumnModel> columns = new ArrayList<DataStructureHDBTableColumnModel>();

  /** The constraints. */
  private DataStructureHDBTableConstraintsModel constraints = new DataStructureHDBTableConstraintsModel();

  /** The indexes. */
  private List<DataStructureHDBTableIndexModel> indexes = new ArrayList<>();

  /** The namespace. */
  private String namespace;

  /** The context. */
  private String context;

  /**
   * Getter for the columns.
   *
   * @return the columns
   */
  public List<DataStructureHDBTableColumnModel> getColumns() {
    return columns;
  }

  /**
   * Gets the constraints.
   *
   * @return the constraints
   */
  public DataStructureHDBTableConstraintsModel getConstraints() {
    return constraints;
  }

  /**
   * Gets the context.
   *
   * @return the context
   */
  public String getContext() {
    return context;
  }

  /**
   * Sets the context.
   *
   * @param context the context to set
   */
  public void setContext(String context) {
    this.context = context;
  }

  /**
   * Gets the namespace.
   *
   * @return the namespace
   */
  public String getNamespace() {
    return namespace;
  }

  /**
   * Sets the namespace.
   *
   * @param namespace the namespace to set
   */
  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  /**
   * Gets the indexes.
   *
   * @return the indexes
   */
  public List<DataStructureHDBTableIndexModel> getIndexes() {
    return indexes;
  }
}
