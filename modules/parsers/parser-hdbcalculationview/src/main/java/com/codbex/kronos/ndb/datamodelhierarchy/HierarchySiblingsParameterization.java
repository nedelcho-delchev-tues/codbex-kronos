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


package com.codbex.kronos.ndb.datamodelhierarchy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Returns all siblings of a set of start nodes, including the start nodes, in a hierarchy.
 * Docs: https://help.sap.com/viewer/4fe29514fd584807ac9f2a04f6754767/2.0.02/en-US/ffc0d810a9274f789e6667cf0f73c388.html
 *
 *
 * Java class for HierarchySiblingsParameterization complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HierarchySiblingsParameterization"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="start" type="{http://www.sap.com/ndb/DataModelHierarchy.ecore}Start" minOccurs="0"/&gt;
 *         &lt;element name="startWhere" type="{http://www.sap.com/ndb/DataModelType.ecore}ExpressionString" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HierarchySiblingsParameterization", propOrder = {
    "start",
    "startWhere"
})
public class HierarchySiblingsParameterization {

  /** The start. */
  protected Start start;
  
  /** The start where. */
  protected String startWhere;

  /**
   * Gets the value of the start property.
   *
   * @return possible object is
   * {@link Start }
   */
  public Start getStart() {
    return start;
  }

  /**
   * Sets the value of the start property.
   *
   * @param value allowed object is
   *              {@link Start }
   */
  public void setStart(Start value) {
    this.start = value;
  }

  /**
   * Gets the value of the startWhere property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getStartWhere() {
    return startWhere;
  }

  /**
   * Sets the value of the startWhere property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setStartWhere(String value) {
    this.startWhere = value;
  }

}
