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


package com.sap.ndb.bimodeldatafoundation;

import com.sap.ndb.basemodelbase.CacheInvalidationPeriod;
import com.sap.ndb.basemodelbase.PrivilegeType;
import com.sap.ndb.basemodelbase.SchemaMappingBasedObject;
import com.sap.ndb.bimodelcalculation.CalculationScenario;
import com.sap.ndb.bimodelcube.Cube;
import com.sap.ndb.bimodelvariable.LocalVariables;
import com.sap.ndb.bimodelvariable.VariableMappings;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Base type for reporting enabled BI resources i.e. resources you can	run client tools on = BW InfoProvider
 *
 *
 * <p>Java class for InformationModel complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InformationModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}BIResource"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="defaultSchema" type="{http://www.sap.com/ndb/BaseModelBase.ecore}SchemaMappingBasedObject" minOccurs="0"/&gt;
 *         &lt;element name="localVariables" type="{http://www.sap.com/ndb/BiModelVariable.ecore}LocalVariables" minOccurs="0"/&gt;
 *         &lt;element name="historyVariable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="variableMappings" type="{http://www.sap.com/ndb/BiModelVariable.ecore}VariableMappings" minOccurs="0"/&gt;
 *         &lt;element name="informationModelLayout" type="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}InformationModelLayoutProperties" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="defaultLanguage" type="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}Language" /&gt;
 *       &lt;attribute name="defaultClient" type="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}Client" /&gt;
 *       &lt;attribute name="checkAnalyticPrivileges" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="applyPrivilegeType" type="{http://www.sap.com/ndb/BaseModelBase.ecore}PrivilegeType" /&gt;
 *       &lt;attribute name="historyEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="generateConcatAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="cacheEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="cacheInvalidationPeriod" type="{http://www.sap.com/ndb/BaseModelBase.ecore}CacheInvalidationPeriod" /&gt;
 *       &lt;attribute name="translationRelevant" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="hierarchiesSQLEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InformationModel", propOrder = {
    "defaultSchema",
    "localVariables",
    "historyVariable",
    "variableMappings",
    "informationModelLayout"
})
@XmlSeeAlso({
    CalculationScenario.class,
    Cube.class,
    LogicalObject.class
})
public abstract class InformationModel
    extends BIResource {

  protected SchemaMappingBasedObject defaultSchema;
  protected LocalVariables localVariables;
  protected String historyVariable;
  protected VariableMappings variableMappings;
  protected InformationModelLayoutProperties informationModelLayout;
  @XmlAttribute(name = "defaultLanguage")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String defaultLanguage;
  @XmlAttribute(name = "defaultClient")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String defaultClient;
  @XmlAttribute(name = "checkAnalyticPrivileges")
  protected Boolean checkAnalyticPrivileges;
  @XmlAttribute(name = "applyPrivilegeType")
  protected PrivilegeType applyPrivilegeType;
  @XmlAttribute(name = "historyEnabled")
  protected Boolean historyEnabled;
  @XmlAttribute(name = "generateConcatAttributes")
  protected Boolean generateConcatAttributes;
  @XmlAttribute(name = "cacheEnabled")
  protected Boolean cacheEnabled;
  @XmlAttribute(name = "cacheInvalidationPeriod")
  protected CacheInvalidationPeriod cacheInvalidationPeriod;
  @XmlAttribute(name = "translationRelevant")
  protected Boolean translationRelevant;
  @XmlAttribute(name = "hierarchiesSQLEnabled")
  protected Boolean hierarchiesSQLEnabled;

  /**
   * Gets the value of the defaultSchema property.
   *
   * @return possible object is
   * {@link SchemaMappingBasedObject }
   */
  public SchemaMappingBasedObject getDefaultSchema() {
    return defaultSchema;
  }

  /**
   * Sets the value of the defaultSchema property.
   *
   * @param value allowed object is
   *              {@link SchemaMappingBasedObject }
   */
  public void setDefaultSchema(SchemaMappingBasedObject value) {
    this.defaultSchema = value;
  }

  /**
   * Gets the value of the localVariables property.
   *
   * @return possible object is
   * {@link LocalVariables }
   */
  public LocalVariables getLocalVariables() {
    return localVariables;
  }

  /**
   * Sets the value of the localVariables property.
   *
   * @param value allowed object is
   *              {@link LocalVariables }
   */
  public void setLocalVariables(LocalVariables value) {
    this.localVariables = value;
  }

  /**
   * Gets the value of the historyVariable property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getHistoryVariable() {
    return historyVariable;
  }

  /**
   * Sets the value of the historyVariable property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setHistoryVariable(String value) {
    this.historyVariable = value;
  }

  /**
   * Gets the value of the variableMappings property.
   *
   * @return possible object is
   * {@link VariableMappings }
   */
  public VariableMappings getVariableMappings() {
    return variableMappings;
  }

  /**
   * Sets the value of the variableMappings property.
   *
   * @param value allowed object is
   *              {@link VariableMappings }
   */
  public void setVariableMappings(VariableMappings value) {
    this.variableMappings = value;
  }

  /**
   * Gets the value of the informationModelLayout property.
   *
   * @return possible object is
   * {@link InformationModelLayoutProperties }
   */
  public InformationModelLayoutProperties getInformationModelLayout() {
    return informationModelLayout;
  }

  /**
   * Sets the value of the informationModelLayout property.
   *
   * @param value allowed object is
   *              {@link InformationModelLayoutProperties }
   */
  public void setInformationModelLayout(InformationModelLayoutProperties value) {
    this.informationModelLayout = value;
  }

  /**
   * Gets the value of the defaultLanguage property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getDefaultLanguage() {
    return defaultLanguage;
  }

  /**
   * Sets the value of the defaultLanguage property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDefaultLanguage(String value) {
    this.defaultLanguage = value;
  }

  /**
   * Gets the value of the defaultClient property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getDefaultClient() {
    return defaultClient;
  }

  /**
   * Sets the value of the defaultClient property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDefaultClient(String value) {
    this.defaultClient = value;
  }

  /**
   * Gets the value of the checkAnalyticPrivileges property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isCheckAnalyticPrivileges() {
    return checkAnalyticPrivileges;
  }

  /**
   * Sets the value of the checkAnalyticPrivileges property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setCheckAnalyticPrivileges(Boolean value) {
    this.checkAnalyticPrivileges = value;
  }

  /**
   * Gets the value of the applyPrivilegeType property.
   *
   * @return possible object is
   * {@link PrivilegeType }
   */
  public PrivilegeType getApplyPrivilegeType() {
    return applyPrivilegeType;
  }

  /**
   * Sets the value of the applyPrivilegeType property.
   *
   * @param value allowed object is
   *              {@link PrivilegeType }
   */
  public void setApplyPrivilegeType(PrivilegeType value) {
    this.applyPrivilegeType = value;
  }

  /**
   * Gets the value of the historyEnabled property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isHistoryEnabled() {
    return historyEnabled;
  }

  /**
   * Sets the value of the historyEnabled property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setHistoryEnabled(Boolean value) {
    this.historyEnabled = value;
  }

  /**
   * Gets the value of the generateConcatAttributes property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isGenerateConcatAttributes() {
    return generateConcatAttributes;
  }

  /**
   * Sets the value of the generateConcatAttributes property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setGenerateConcatAttributes(Boolean value) {
    this.generateConcatAttributes = value;
  }

  /**
   * Gets the value of the cacheEnabled property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isCacheEnabled() {
    return cacheEnabled;
  }

  /**
   * Sets the value of the cacheEnabled property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setCacheEnabled(Boolean value) {
    this.cacheEnabled = value;
  }

  /**
   * Gets the value of the cacheInvalidationPeriod property.
   *
   * @return possible object is
   * {@link CacheInvalidationPeriod }
   */
  public CacheInvalidationPeriod getCacheInvalidationPeriod() {
    return cacheInvalidationPeriod;
  }

  /**
   * Sets the value of the cacheInvalidationPeriod property.
   *
   * @param value allowed object is
   *              {@link CacheInvalidationPeriod }
   */
  public void setCacheInvalidationPeriod(CacheInvalidationPeriod value) {
    this.cacheInvalidationPeriod = value;
  }

  /**
   * Gets the value of the translationRelevant property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public boolean isTranslationRelevant() {
    if (translationRelevant == null) {
      return true;
    } else {
      return translationRelevant;
    }
  }

  /**
   * Sets the value of the translationRelevant property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setTranslationRelevant(Boolean value) {
    this.translationRelevant = value;
  }

  /**
   * Gets the value of the hierarchiesSQLEnabled property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isHierarchiesSQLEnabled() {
    return hierarchiesSQLEnabled;
  }

  /**
   * Sets the value of the hierarchiesSQLEnabled property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setHierarchiesSQLEnabled(Boolean value) {
    this.hierarchiesSQLEnabled = value;
  }

}
