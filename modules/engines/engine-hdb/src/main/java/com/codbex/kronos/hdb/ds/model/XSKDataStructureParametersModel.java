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

public class XSKDataStructureParametersModel {

  private String type;
  private String location;
  private String content;
  private String workspacePath;

  public XSKDataStructureParametersModel() {
  }

  public XSKDataStructureParametersModel(String type, String location, String content, String workspacePath) {
    this.type = type;
    this.location = location;
    this.content = content;
    this.workspacePath = workspacePath;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getWorkspacePath() {
    return workspacePath;
  }

  public void setWorkspacePath(String workspacePath) {
    this.workspacePath = workspacePath;
  }
}
