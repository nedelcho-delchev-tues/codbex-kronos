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


package com.sap.ndb.bimodeldimension;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Specification of time dependent columns and parameters.
 *
 *
 * <p>Java class for HierarchyTimeProperties complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HierarchyTimeProperties"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="validFromElement" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}AlphanumericName"/&gt;
 *         &lt;element name="validToElement" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}AlphanumericName"/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="fromVariable" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}Identifier"/&gt;
 *             &lt;element name="toVariable" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}Identifier"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;element name="pointInTimeVariable" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}Identifier"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HierarchyTimeProperties", propOrder = {
    "validFromElement",
    "validToElement",
    "fromVariable",
    "toVariable",
    "pointInTimeVariable"
})
public class HierarchyTimeProperties {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String validFromElement;
  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String validToElement;
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String fromVariable;
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String toVariable;
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String pointInTimeVariable;

  /**
   * Gets the value of the validFromElement property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getValidFromElement() {
    return validFromElement;
  }

  /**
   * Sets the value of the validFromElement property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setValidFromElement(String value) {
    this.validFromElement = value;
  }

  /**
   * Gets the value of the validToElement property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getValidToElement() {
    return validToElement;
  }

  /**
   * Sets the value of the validToElement property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setValidToElement(String value) {
    this.validToElement = value;
  }

  /**
   * Gets the value of the fromVariable property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getFromVariable() {
    return fromVariable;
  }

  /**
   * Sets the value of the fromVariable property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setFromVariable(String value) {
    this.fromVariable = value;
  }

  /**
   * Gets the value of the toVariable property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getToVariable() {
    return toVariable;
  }

  /**
   * Sets the value of the toVariable property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setToVariable(String value) {
    this.toVariable = value;
  }

  /**
   * Gets the value of the pointInTimeVariable property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getPointInTimeVariable() {
    return pointInTimeVariable;
  }

  /**
   * Sets the value of the pointInTimeVariable property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setPointInTimeVariable(String value) {
    this.pointInTimeVariable = value;
  }

}
