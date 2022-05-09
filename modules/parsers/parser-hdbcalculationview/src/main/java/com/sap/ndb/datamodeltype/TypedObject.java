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

import com.sap.ndb.repositorymodelresource.NamedObjectWithEndUserTexts;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Common father class for typed objects e.g. Element, Parameter,...
 *
 *
 * <p>Java class for TypedObject complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TypedObject"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/RepositoryModelResource.ecore}NamedObjectWithEndUserTexts"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="type" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}FQName"/&gt;
 *           &lt;element name="inlineStructureType" type="{http://www.sap.com/ndb/DataModelType.ecore}StructureType"/&gt;
 *           &lt;element name="inlineType" type="{http://www.sap.com/ndb/DataModelType.ecore}SimpleType"/&gt;
 *           &lt;sequence&gt;
 *             &lt;choice&gt;
 *               &lt;element name="typeOfElement" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}Identifier"/&gt;
 *               &lt;sequence&gt;
 *                 &lt;element name="externalTypeOfEntity" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}FQName"/&gt;
 *                 &lt;element name="externalTypeOfElement" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}Identifier"/&gt;
 *               &lt;/sequence&gt;
 *             &lt;/choice&gt;
 *             &lt;element name="hierarchy" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}Identifier" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="internalExternalConversion" type="{http://www.sap.com/ndb/DataModelType.ecore}InternalExternalConversion" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="deprecated" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypedObject", propOrder = {
    "type",
    "inlineStructureType",
    "inlineType",
    "typeOfElement",
    "externalTypeOfEntity",
    "externalTypeOfElement",
    "hierarchy",
    "internalExternalConversion"
})
@XmlSeeAlso({
    Element.class
})
public abstract class TypedObject
    extends NamedObjectWithEndUserTexts {

  protected String type;
  protected StructureType inlineStructureType;
  protected SimpleType inlineType;
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String typeOfElement;
  protected String externalTypeOfEntity;
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String externalTypeOfElement;
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String hierarchy;
  protected InternalExternalConversion internalExternalConversion;
  @XmlAttribute(name = "deprecated")
  protected Boolean deprecated;

  /**
   * Gets the value of the type property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the value of the type property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setType(String value) {
    this.type = value;
  }

  /**
   * Gets the value of the inlineStructureType property.
   *
   * @return possible object is
   * {@link StructureType }
   */
  public StructureType getInlineStructureType() {
    return inlineStructureType;
  }

  /**
   * Sets the value of the inlineStructureType property.
   *
   * @param value allowed object is
   *              {@link StructureType }
   */
  public void setInlineStructureType(StructureType value) {
    this.inlineStructureType = value;
  }

  /**
   * Gets the value of the inlineType property.
   *
   * @return possible object is
   * {@link SimpleType }
   */
  public SimpleType getInlineType() {
    return inlineType;
  }

  /**
   * Sets the value of the inlineType property.
   *
   * @param value allowed object is
   *              {@link SimpleType }
   */
  public void setInlineType(SimpleType value) {
    this.inlineType = value;
  }

  /**
   * Gets the value of the typeOfElement property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getTypeOfElement() {
    return typeOfElement;
  }

  /**
   * Sets the value of the typeOfElement property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setTypeOfElement(String value) {
    this.typeOfElement = value;
  }

  /**
   * Gets the value of the externalTypeOfEntity property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getExternalTypeOfEntity() {
    return externalTypeOfEntity;
  }

  /**
   * Sets the value of the externalTypeOfEntity property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setExternalTypeOfEntity(String value) {
    this.externalTypeOfEntity = value;
  }

  /**
   * Gets the value of the externalTypeOfElement property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getExternalTypeOfElement() {
    return externalTypeOfElement;
  }

  /**
   * Sets the value of the externalTypeOfElement property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setExternalTypeOfElement(String value) {
    this.externalTypeOfElement = value;
  }

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
   * Gets the value of the internalExternalConversion property.
   *
   * @return possible object is
   * {@link InternalExternalConversion }
   */
  public InternalExternalConversion getInternalExternalConversion() {
    return internalExternalConversion;
  }

  /**
   * Sets the value of the internalExternalConversion property.
   *
   * @param value allowed object is
   *              {@link InternalExternalConversion }
   */
  public void setInternalExternalConversion(InternalExternalConversion value) {
    this.internalExternalConversion = value;
  }

  /**
   * Gets the value of the deprecated property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isDeprecated() {
    return deprecated;
  }

  /**
   * Sets the value of the deprecated property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setDeprecated(Boolean value) {
    this.deprecated = value;
  }

}
