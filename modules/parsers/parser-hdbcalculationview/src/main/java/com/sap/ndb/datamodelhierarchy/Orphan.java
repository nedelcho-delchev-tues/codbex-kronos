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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.11.26 at 10:54:28 AM EET 
//


package com.sap.ndb.datamodelhierarchy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Orphan.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Orphan"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *     &lt;enumeration value="ORPHAN_IGNORE"/&gt;
 *     &lt;enumeration value="ORPHAN_ERROR"/&gt;
 *     &lt;enumeration value="ORPHAN_ROOT"/&gt;
 *     &lt;enumeration value="ORPHAN_ADOPT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "Orphan")
@XmlEnum
public enum Orphan {


  /**
   * Orphans are silently ignored. This is the default behavior
   */
  ORPHAN_IGNORE,

  /**
   * If the input data contains any orphans, an error is returned
   */
  ORPHAN_ERROR,

  /**
   * Top-level orphans are treated as root nodes
   */
  ORPHAN_ROOT,

  /**
   * Orphans are adopted as children of the last root behind its	regular descendants. orphan and
   * depth property cannot be used at the same time. If a maximum search depth is specified, then orphaned nodes are always ignored
   */
  ORPHAN_ADOPT;

  public static Orphan fromValue(String v) {
    return valueOf(v);
  }

  public String value() {
    return name();
  }

}
