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


package com.sap.ndb.datamodelfilter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RangeValueFilter complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RangeValueFilter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/DataModelFilter.ecore}ValueFilter"&gt;
 *       &lt;attribute name="lowValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="highValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RangeValueFilter")
@XmlSeeAlso({
    DefaultRange.class
})
public class RangeValueFilter
    extends ValueFilter {

  @XmlAttribute(name = "lowValue")
  protected String lowValue;
  @XmlAttribute(name = "highValue")
  protected String highValue;

  /**
   * Gets the value of the lowValue property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getLowValue() {
    return lowValue;
  }

  /**
   * Sets the value of the lowValue property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setLowValue(String value) {
    this.lowValue = value;
  }

  /**
   * Gets the value of the highValue property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getHighValue() {
    return highValue;
  }

  /**
   * Sets the value of the highValue property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setHighValue(String value) {
    this.highValue = value;
  }

}
