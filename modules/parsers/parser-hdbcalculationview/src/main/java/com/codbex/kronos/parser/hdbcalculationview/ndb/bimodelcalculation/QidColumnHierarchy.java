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


package com.codbex.kronos.parser.hdbcalculationview.ndb.bimodelcalculation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Java class for QidColumnHierarchy complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="QidColumnHierarchy"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="hierarchy" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}FQName"/&gt;
 *         &lt;element name="hierarchyEmbeded" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="ID" type="{http://www.sap.com/ndb/BaseModelBase.ecore}DbName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QidColumnHierarchy", propOrder = {
    "hierarchy",
    "hierarchyEmbeded"
})
public class QidColumnHierarchy {

  /** The hierarchy. */
  protected String hierarchy;
  
  /** The hierarchy embeded. */
  protected String hierarchyEmbeded;
  
  /** The id. */
  @XmlAttribute(name = "ID")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String id;

  /**
   * Gets the value of the hierarchy property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getHierarchy() {
    return hierarchy;
  }

  /**
   * Sets the value of the hierarchy property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setHierarchy(String value) {
    this.hierarchy = value;
  }

  /**
   * Gets the value of the hierarchyEmbeded property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getHierarchyEmbeded() {
    return hierarchyEmbeded;
  }

  /**
   * Sets the value of the hierarchyEmbeded property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setHierarchyEmbeded(String value) {
    this.hierarchyEmbeded = value;
  }

  /**
   * Gets the value of the id property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getID() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setID(String value) {
    this.id = value;
  }

}