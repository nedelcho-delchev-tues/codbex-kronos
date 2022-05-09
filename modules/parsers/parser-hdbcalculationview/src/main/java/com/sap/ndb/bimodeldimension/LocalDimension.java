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

import com.sap.ndb.repositorymodelresource.IDObjectWithDescription;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A local dimension refers to attributes and defines hierarchies inside of a logical model.
 * It has no own data foundation see Dimension.
 *
 *
 * <p>Java class for LocalDimension complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LocalDimension"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/RepositoryModelResource.ecore}IDObjectWithDescription"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attributeRef" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}AlphanumericName" maxOccurs="unbounded"/&gt;
 *         &lt;element name="hierarchies" type="{http://www.sap.com/ndb/BiModelDimension.ecore}Hierarchies" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="dimensionType" use="required" type="{http://www.sap.com/ndb/BiModelDimension.ecore}DimensionType" /&gt;
 *       &lt;attribute name="defaultMember" type="{http://www.sap.com/ndb/BaseModelBase.ecore}DefaultMember" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalDimension", propOrder = {
    "attributeRef",
    "hierarchies"
})
public class LocalDimension
    extends IDObjectWithDescription {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected List<String> attributeRef;
  protected Hierarchies hierarchies;
  @XmlAttribute(name = "dimensionType", required = true)
  protected DimensionType dimensionType;
  @XmlAttribute(name = "defaultMember")
  protected String defaultMember;

  /**
   * Gets the value of the attributeRef property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the attributeRef property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getAttributeRef().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link String }
   */
  public List<String> getAttributeRef() {
    if (attributeRef == null) {
      attributeRef = new ArrayList<String>();
    }
    return this.attributeRef;
  }

  /**
   * Gets the value of the hierarchies property.
   *
   * @return possible object is
   * {@link Hierarchies }
   */
  public Hierarchies getHierarchies() {
    return hierarchies;
  }

  /**
   * Sets the value of the hierarchies property.
   *
   * @param value allowed object is
   *              {@link Hierarchies }
   */
  public void setHierarchies(Hierarchies value) {
    this.hierarchies = value;
  }

  /**
   * Gets the value of the dimensionType property.
   *
   * @return possible object is
   * {@link DimensionType }
   */
  public DimensionType getDimensionType() {
    return dimensionType;
  }

  /**
   * Sets the value of the dimensionType property.
   *
   * @param value allowed object is
   *              {@link DimensionType }
   */
  public void setDimensionType(DimensionType value) {
    this.dimensionType = value;
  }

  /**
   * Gets the value of the defaultMember property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getDefaultMember() {
    return defaultMember;
  }

  /**
   * Sets the value of the defaultMember property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDefaultMember(String value) {
    this.defaultMember = value;
  }

}
