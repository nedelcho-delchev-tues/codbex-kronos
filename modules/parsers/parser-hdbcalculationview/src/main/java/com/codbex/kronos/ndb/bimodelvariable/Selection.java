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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes which format/complexity is allowed when entering value for a variable
 *
 *
 * Java class for Selection complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Selection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="type" use="required" type="{http://www.sap.com/ndb/BiModelVariable.ecore}SelectionType" /&gt;
 *       &lt;attribute name="multiLine" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Selection")
public class Selection {

  /** The type. */
  @XmlAttribute(name = "type", required = true)
  protected SelectionType type;
  
  /** The multi line. */
  @XmlAttribute(name = "multiLine", required = true)
  protected boolean multiLine;

  /**
   * Gets the value of the type property.
   *
   * @return possible object is
   * {@link SelectionType }
   */
  public SelectionType getType() {
    return type;
  }

  /**
   * Sets the value of the type property.
   *
   * @param value allowed object is
   *              {@link SelectionType }
   */
  public void setType(SelectionType value) {
    this.type = value;
  }

  /**
   * Gets the value of the multiLine property.
   *
   * @return true, if is multi line
   */
  public boolean isMultiLine() {
    return multiLine;
  }

  /**
   * Sets the value of the multiLine property.
   *
   * @param value the new multi line
   */
  public void setMultiLine(boolean value) {
    this.multiLine = value;
  }

}
