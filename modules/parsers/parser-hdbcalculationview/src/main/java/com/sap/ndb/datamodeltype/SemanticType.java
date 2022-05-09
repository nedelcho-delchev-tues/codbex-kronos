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


package com.sap.ndb.datamodeltype;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SemanticType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SemanticType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *     &lt;enumeration value="empty"/&gt;
 *     &lt;enumeration value="amount"/&gt;
 *     &lt;enumeration value="quantity"/&gt;
 *     &lt;enumeration value="currencyCode"/&gt;
 *     &lt;enumeration value="unitOfMeasure"/&gt;
 *     &lt;enumeration value="time"/&gt;
 *     &lt;enumeration value="date"/&gt;
 *     &lt;enumeration value="date.businessDateFrom"/&gt;
 *     &lt;enumeration value="date.businessDateTo"/&gt;
 *     &lt;enumeration value="geoLocation.longitude"/&gt;
 *     &lt;enumeration value="geoLocation.latitude"/&gt;
 *     &lt;enumeration value="geoLocation.cartoId"/&gt;
 *     &lt;enumeration value="geoLocation.normalizedName"/&gt;
 *     &lt;enumeration value="client"/&gt;
 *     &lt;enumeration value="language"/&gt;
 *     &lt;enumeration value="description"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "SemanticType")
@XmlEnum
public enum SemanticType {

  @XmlEnumValue("empty")
  EMPTY("empty"),
  @XmlEnumValue("amount")
  AMOUNT("amount"),
  @XmlEnumValue("quantity")
  QUANTITY("quantity"),
  @XmlEnumValue("currencyCode")
  CURRENCY_CODE("currencyCode"),
  @XmlEnumValue("unitOfMeasure")
  UNIT_OF_MEASURE("unitOfMeasure"),

  /**
   * Can be used for STRING typed fields (ABAP type TIMS) to indicate the additional semantic
   * Not needed if the primitive type is already TIME
   */
  @XmlEnumValue("time")
  TIME("time"),

  /**
   * Can be used for STRING typed fields (ABAP type DATS) to indicate the additional semantic
   * Not needed if the primitive type is already DATE
   */
  @XmlEnumValue("date")
  DATE("date"),

  /**
   * Date field containing the from data for time dependent data
   */
  @XmlEnumValue("date.businessDateFrom")
  DATE_BUSINESS_DATE_FROM("date.businessDateFrom"),

  /**
   * Date field containing the to data for time dependent data
   */
  @XmlEnumValue("date.businessDateTo")
  DATE_BUSINESS_DATE_TO("date.businessDateTo"),
  @XmlEnumValue("geoLocation.longitude")
  GEO_LOCATION_LONGITUDE("geoLocation.longitude"),
  @XmlEnumValue("geoLocation.latitude")
  GEO_LOCATION_LATITUDE("geoLocation.latitude"),
  @XmlEnumValue("geoLocation.cartoId")
  GEO_LOCATION_CARTO_ID("geoLocation.cartoId"),
  @XmlEnumValue("geoLocation.normalizedName")
  GEO_LOCATION_NORMALIZED_NAME("geoLocation.normalizedName"),

  /**
   * APAP field to identify the client = MANDT
   */
  @XmlEnumValue("client")
  CLIENT("client"),
  @XmlEnumValue("language")
  LANGUAGE("language"),

  /**
   * A textual (one line) description of an object. Typically this will be multi language enabled.
   */
  @XmlEnumValue("description")
  DESCRIPTION("description");
  private final String value;

  SemanticType(String v) {
    value = v;
  }

  public static SemanticType fromValue(String v) {
    for (SemanticType c : SemanticType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

  public String value() {
    return value;
  }

}
