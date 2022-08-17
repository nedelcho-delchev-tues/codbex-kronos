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


package com.codbex.kronos.parser.hdbcalculationview.ndb.datamodeltype;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Properties needed for defining an internal/external conversion of
 *
 *
 * Java class for InternalExternalConversion complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InternalExternalConversion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="convertToExternalFunction" use="required" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}FQName" /&gt;
 *       &lt;attribute name="convertToInternalFunction" use="required" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}FQName" /&gt;
 *       &lt;attribute name="orderPreserving" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InternalExternalConversion")
public class InternalExternalConversion {

  /** The convert to external function. */
  @XmlAttribute(name = "convertToExternalFunction", required = true)
  protected String convertToExternalFunction;
  
  /** The convert to internal function. */
  @XmlAttribute(name = "convertToInternalFunction", required = true)
  protected String convertToInternalFunction;
  
  /** The order preserving. */
  @XmlAttribute(name = "orderPreserving")
  protected Boolean orderPreserving;

  /**
   * Gets the value of the convertToExternalFunction property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getConvertToExternalFunction() {
    return convertToExternalFunction;
  }

  /**
   * Sets the value of the convertToExternalFunction property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setConvertToExternalFunction(String value) {
    this.convertToExternalFunction = value;
  }

  /**
   * Gets the value of the convertToInternalFunction property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getConvertToInternalFunction() {
    return convertToInternalFunction;
  }

  /**
   * Sets the value of the convertToInternalFunction property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setConvertToInternalFunction(String value) {
    this.convertToInternalFunction = value;
  }

  /**
   * Gets the value of the orderPreserving property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isOrderPreserving() {
    return orderPreserving;
  }

  /**
   * Sets the value of the orderPreserving property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setOrderPreserving(Boolean value) {
    this.orderPreserving = value;
  }

}