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


package com.codbex.kronos.ndb.bimodelvariable;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * Java class for ValueType.
 *
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;simpleType name="ValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *     &lt;enumeration value="empty"/&gt;
 *     &lt;enumeration value="Currency"/&gt;
 *     &lt;enumeration value="UnitOfMeasure"/&gt;
 *     &lt;enumeration value="Date"/&gt;
 *     &lt;enumeration value="AttributeValue"/&gt;
 *     &lt;enumeration value="StaticList"/&gt;
 *     &lt;enumeration value="FuzzyTextSearch"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ValueType")
@XmlEnum
public enum ValueType {

  /** The empty. */
  @XmlEnumValue("empty")
  EMPTY("empty"),
  
  /** The currency. */
  @XmlEnumValue("Currency")
  CURRENCY("Currency"),
  
  /** The unit of measure. */
  @XmlEnumValue("UnitOfMeasure")
  UNIT_OF_MEASURE("UnitOfMeasure"),
  
  /** The date. */
  @XmlEnumValue("Date")
  DATE("Date"),
  
  /** The attribute value. */
  @XmlEnumValue("AttributeValue")
  ATTRIBUTE_VALUE("AttributeValue"),
  
  /** The static list. */
  @XmlEnumValue("StaticList")
  STATIC_LIST("StaticList"),
  
  /** The fuzzy text search. */
  @XmlEnumValue("FuzzyTextSearch")
  FUZZY_TEXT_SEARCH("FuzzyTextSearch");
  
  /** The value. */
  private final String value;

  /**
   * Instantiates a new value type.
   *
   * @param v the v
   */
  ValueType(String v) {
    value = v;
  }

  /**
   * From value.
   *
   * @param v the v
   * @return the value type
   */
  public static ValueType fromValue(String v) {
    for (ValueType c : ValueType.values()) {
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
