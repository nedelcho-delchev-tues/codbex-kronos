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


package com.codbex.kronos.ndb.bimodeldatafoundation;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * Java class for DeploymentType.
 *
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;simpleType name="DeploymentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *     &lt;enumeration value="systemDerived"/&gt;
 *     &lt;enumeration value="joinView"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "DeploymentType")
@XmlEnum
public enum DeploymentType {

  /** The system derived. */
  @XmlEnumValue("systemDerived")
  SYSTEM_DERIVED("systemDerived"),
  
  /** The join view. */
  @XmlEnumValue("joinView")
  JOIN_VIEW("joinView");
  
  /** The value. */
  private final String value;

  /**
   * Instantiates a new deployment type.
   *
   * @param v the v
   */
  DeploymentType(String v) {
    value = v;
  }

  /**
   * From value.
   *
   * @param v the v
   * @return the deployment type
   */
  public static DeploymentType fromValue(String v) {
    for (DeploymentType c : DeploymentType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

  /**
   * Value.
   *
   * @return the string
   */
  public String value() {
    return value;
  }

}
