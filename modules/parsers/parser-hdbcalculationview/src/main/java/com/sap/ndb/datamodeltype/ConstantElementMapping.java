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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConstantElementMapping complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ConstantElementMapping"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/DataModelType.ecore}AbstractElementMapping"&gt;
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="null" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConstantElementMapping")
public class ConstantElementMapping
    extends AbstractElementMapping {

  @XmlAttribute(name = "value")
  protected String value;
  @XmlAttribute(name = "null")
  protected Boolean _null;

  /**
   * Gets the value of the value property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value of the value property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Gets the value of the null property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isNull() {
    return _null;
  }

  /**
   * Sets the value of the null property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setNull(Boolean value) {
    this._null = value;
  }

}
