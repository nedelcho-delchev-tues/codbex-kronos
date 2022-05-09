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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XSKHDBXSODATAModificationSpec {

  private List<XSKHDBXSODATAEvent> events = new ArrayList<>();
  private String modificationAction;
  private boolean forbidden = false;

  public List<XSKHDBXSODATAEvent> getEvents() {
    return events;
  }

  public XSKHDBXSODATAModificationSpec setEvents(List<XSKHDBXSODATAEvent> events) {
    this.events = events;
    return this;
  }

  public String getModificationAction() {
    return modificationAction;
  }

  public XSKHDBXSODATAModificationSpec setModificationAction(String modificationAction) {
    this.modificationAction = modificationAction;
    return this;
  }

  public boolean isForbidden() {
    return forbidden;
  }

  public XSKHDBXSODATAModificationSpec setForbidden(boolean forbidden) {
    this.forbidden = forbidden;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    XSKHDBXSODATAModificationSpec that = (XSKHDBXSODATAModificationSpec) o;
    return forbidden == that.forbidden && Objects.equals(events, that.events) && Objects.equals(modificationAction,
        that.modificationAction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(events, modificationAction, forbidden);
  }
}
