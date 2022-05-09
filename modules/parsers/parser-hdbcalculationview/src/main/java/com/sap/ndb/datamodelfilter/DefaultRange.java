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
import javax.xml.bind.annotation.XmlType;


/**
 * Range definition for default values
 *
 *
 * <p>Java class for DefaultRange complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DefaultRange"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/DataModelFilter.ecore}RangeValueFilter"&gt;
 *       &lt;attribute name="lowExpression" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="highExpression" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefaultRange")
public class DefaultRange
    extends RangeValueFilter {

  @XmlAttribute(name = "lowExpression")
  protected Boolean lowExpression;
  @XmlAttribute(name = "highExpression")
  protected Boolean highExpression;

  /**
   * Gets the value of the lowExpression property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isLowExpression() {
    return lowExpression;
  }

  /**
   * Sets the value of the lowExpression property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setLowExpression(Boolean value) {
    this.lowExpression = value;
  }

  /**
   * Gets the value of the highExpression property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isHighExpression() {
    return highExpression;
  }

  /**
   * Sets the value of the highExpression property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setHighExpression(Boolean value) {
    this.highExpression = value;
  }

}
