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
package com.codbex.kronos.parser.xsodata.model;

import java.util.Objects;

public class XSKHDBXSODATAAggregation {

  private String aggregateFunction;
  private String aggregateColumnName;

  public String getAggregateFunction() {
    return aggregateFunction;
  }

  public XSKHDBXSODATAAggregation setAggregateFunction(String aggregateFunction) {
    this.aggregateFunction = aggregateFunction;
    return this;
  }

  public String getAggregateColumnName() {
    return aggregateColumnName;
  }

  public XSKHDBXSODATAAggregation setAggregateColumnName(String aggregateColumnName) {
    this.aggregateColumnName = aggregateColumnName;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    XSKHDBXSODATAAggregation that = (XSKHDBXSODATAAggregation) o;
    return Objects.equals(aggregateFunction, that.aggregateFunction) && Objects.equals(aggregateColumnName, that.aggregateColumnName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aggregateFunction, aggregateColumnName);
  }
}
