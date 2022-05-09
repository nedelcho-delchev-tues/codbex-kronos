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


package com.sap.ndb.bimodelconversion;

import com.sap.ndb.basemodelbase.ConversionMethod;
import com.sap.ndb.basemodelbase.CurrencyConversionLookup;
import com.sap.ndb.bimodeldatafoundation.QualifiedAttributeReference;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A currency conversion comprises all model information that is required as input for the engine currency
 * conversion function. It defines how model artifacts like variables,	attributes, constants are mapped to
 * the input parameters of the currency conversion The source currency is mandatory and then the conversion
 * is either defined as only doing	the ERP decimal shift or a real currency conversion to a different target UNIT.
 * In the latter case one can choose to do the conversion with decimal shift (default) or	without decimal shift
 * (erpDecimalShift="false")
 *
 *
 * <p>Java class for CurrencyConversion complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CurrencyConversion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/BiModelConversion.ecore}Conversion"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sourceCurrency" type="{http://www.sap.com/ndb/BiModelConversion.ecore}Parameterization"/&gt;
 *         &lt;element name="erpDecimalShift" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="round" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="erpDecimalShiftBack" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="targetCurrency" type="{http://www.sap.com/ndb/BiModelConversion.ecore}Parameterization" minOccurs="0"/&gt;
 *         &lt;element name="referenceDate" type="{http://www.sap.com/ndb/BiModelConversion.ecore}Parameterization" minOccurs="0"/&gt;
 *         &lt;element name="marketDataArea" type="{http://www.sap.com/ndb/BiModelConversion.ecore}Parameterization" minOccurs="0"/&gt;
 *         &lt;element name="bidAskType" type="{http://www.sap.com/ndb/BiModelConversion.ecore}Parameterization" minOccurs="0"/&gt;
 *         &lt;element name="steps" type="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}QualifiedAttributeReference" minOccurs="0"/&gt;
 *         &lt;element name="systemTime" type="{http://www.sap.com/ndb/BiModelConversion.ecore}Parameterization" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="exchangeRateType" type="{http://www.sap.com/ndb/BaseModelBase.ecore}ExchangeRateType"/&gt;
 *           &lt;element name="exchangeRateTypeAttribute" type="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}QualifiedAttributeReference"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="exchangeRateAttribute" type="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}QualifiedAttributeReference" minOccurs="0"/&gt;
 *           &lt;element name="exchangeRateCalcAttribute" type="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}QualifiedAttributeReference" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="convert" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="lookup" type="{http://www.sap.com/ndb/BaseModelBase.ecore}CurrencyConversionLookup" /&gt;
 *       &lt;attribute name="accuracy" type="{http://www.sap.com/ndb/BiModelConversion.ecore}CurrencyConversionAccuracy" /&gt;
 *       &lt;attribute name="method" type="{http://www.sap.com/ndb/BaseModelBase.ecore}ConversionMethod" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyConversion", propOrder = {
    "sourceCurrency",
    "erpDecimalShift",
    "round",
    "erpDecimalShiftBack",
    "targetCurrency",
    "referenceDate",
    "marketDataArea",
    "bidAskType",
    "steps",
    "systemTime",
    "exchangeRateType",
    "exchangeRateTypeAttribute",
    "exchangeRateAttribute",
    "exchangeRateCalcAttribute"
})
public class CurrencyConversion
    extends Conversion {

  @XmlElement(required = true)
  protected Parameterization sourceCurrency;
  protected Boolean erpDecimalShift;
  protected Boolean round;
  @XmlElement(defaultValue = "true")
  protected boolean erpDecimalShiftBack;
  protected Parameterization targetCurrency;
  protected Parameterization referenceDate;
  protected Parameterization marketDataArea;
  protected Parameterization bidAskType;
  protected QualifiedAttributeReference steps;
  protected Parameterization systemTime;
  @XmlElement(defaultValue = "M")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "NMTOKEN")
  protected String exchangeRateType;
  protected QualifiedAttributeReference exchangeRateTypeAttribute;
  protected QualifiedAttributeReference exchangeRateAttribute;
  protected QualifiedAttributeReference exchangeRateCalcAttribute;
  @XmlAttribute(name = "convert")
  protected Boolean convert;
  @XmlAttribute(name = "lookup")
  protected CurrencyConversionLookup lookup;
  @XmlAttribute(name = "accuracy")
  protected CurrencyConversionAccuracy accuracy;
  @XmlAttribute(name = "method")
  protected ConversionMethod method;

  /**
   * Gets the value of the sourceCurrency property.
   *
   * @return possible object is
   * {@link Parameterization }
   */
  public Parameterization getSourceCurrency() {
    return sourceCurrency;
  }

  /**
   * Sets the value of the sourceCurrency property.
   *
   * @param value allowed object is
   *              {@link Parameterization }
   */
  public void setSourceCurrency(Parameterization value) {
    this.sourceCurrency = value;
  }

  /**
   * Gets the value of the erpDecimalShift property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isErpDecimalShift() {
    return erpDecimalShift;
  }

  /**
   * Sets the value of the erpDecimalShift property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setErpDecimalShift(Boolean value) {
    this.erpDecimalShift = value;
  }

  /**
   * Gets the value of the round property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isRound() {
    return round;
  }

  /**
   * Sets the value of the round property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setRound(Boolean value) {
    this.round = value;
  }

  /**
   * Gets the value of the erpDecimalShiftBack property.
   */
  public boolean isErpDecimalShiftBack() {
    return erpDecimalShiftBack;
  }

  /**
   * Sets the value of the erpDecimalShiftBack property.
   */
  public void setErpDecimalShiftBack(boolean value) {
    this.erpDecimalShiftBack = value;
  }

  /**
   * Gets the value of the targetCurrency property.
   *
   * @return possible object is
   * {@link Parameterization }
   */
  public Parameterization getTargetCurrency() {
    return targetCurrency;
  }

  /**
   * Sets the value of the targetCurrency property.
   *
   * @param value allowed object is
   *              {@link Parameterization }
   */
  public void setTargetCurrency(Parameterization value) {
    this.targetCurrency = value;
  }

  /**
   * Gets the value of the referenceDate property.
   *
   * @return possible object is
   * {@link Parameterization }
   */
  public Parameterization getReferenceDate() {
    return referenceDate;
  }

  /**
   * Sets the value of the referenceDate property.
   *
   * @param value allowed object is
   *              {@link Parameterization }
   */
  public void setReferenceDate(Parameterization value) {
    this.referenceDate = value;
  }

  /**
   * Gets the value of the marketDataArea property.
   *
   * @return possible object is
   * {@link Parameterization }
   */
  public Parameterization getMarketDataArea() {
    return marketDataArea;
  }

  /**
   * Sets the value of the marketDataArea property.
   *
   * @param value allowed object is
   *              {@link Parameterization }
   */
  public void setMarketDataArea(Parameterization value) {
    this.marketDataArea = value;
  }

  /**
   * Gets the value of the bidAskType property.
   *
   * @return possible object is
   * {@link Parameterization }
   */
  public Parameterization getBidAskType() {
    return bidAskType;
  }

  /**
   * Sets the value of the bidAskType property.
   *
   * @param value allowed object is
   *              {@link Parameterization }
   */
  public void setBidAskType(Parameterization value) {
    this.bidAskType = value;
  }

  /**
   * Gets the value of the steps property.
   *
   * @return possible object is
   * {@link QualifiedAttributeReference }
   */
  public QualifiedAttributeReference getSteps() {
    return steps;
  }

  /**
   * Sets the value of the steps property.
   *
   * @param value allowed object is
   *              {@link QualifiedAttributeReference }
   */
  public void setSteps(QualifiedAttributeReference value) {
    this.steps = value;
  }

  /**
   * Gets the value of the systemTime property.
   *
   * @return possible object is
   * {@link Parameterization }
   */
  public Parameterization getSystemTime() {
    return systemTime;
  }

  /**
   * Sets the value of the systemTime property.
   *
   * @param value allowed object is
   *              {@link Parameterization }
   */
  public void setSystemTime(Parameterization value) {
    this.systemTime = value;
  }

  /**
   * Gets the value of the exchangeRateType property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getExchangeRateType() {
    return exchangeRateType;
  }

  /**
   * Sets the value of the exchangeRateType property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setExchangeRateType(String value) {
    this.exchangeRateType = value;
  }

  /**
   * Gets the value of the exchangeRateTypeAttribute property.
   *
   * @return possible object is
   * {@link QualifiedAttributeReference }
   */
  public QualifiedAttributeReference getExchangeRateTypeAttribute() {
    return exchangeRateTypeAttribute;
  }

  /**
   * Sets the value of the exchangeRateTypeAttribute property.
   *
   * @param value allowed object is
   *              {@link QualifiedAttributeReference }
   */
  public void setExchangeRateTypeAttribute(QualifiedAttributeReference value) {
    this.exchangeRateTypeAttribute = value;
  }

  /**
   * Gets the value of the exchangeRateAttribute property.
   *
   * @return possible object is
   * {@link QualifiedAttributeReference }
   */
  public QualifiedAttributeReference getExchangeRateAttribute() {
    return exchangeRateAttribute;
  }

  /**
   * Sets the value of the exchangeRateAttribute property.
   *
   * @param value allowed object is
   *              {@link QualifiedAttributeReference }
   */
  public void setExchangeRateAttribute(QualifiedAttributeReference value) {
    this.exchangeRateAttribute = value;
  }

  /**
   * Gets the value of the exchangeRateCalcAttribute property.
   *
   * @return possible object is
   * {@link QualifiedAttributeReference }
   */
  public QualifiedAttributeReference getExchangeRateCalcAttribute() {
    return exchangeRateCalcAttribute;
  }

  /**
   * Sets the value of the exchangeRateCalcAttribute property.
   *
   * @param value allowed object is
   *              {@link QualifiedAttributeReference }
   */
  public void setExchangeRateCalcAttribute(QualifiedAttributeReference value) {
    this.exchangeRateCalcAttribute = value;
  }

  /**
   * Gets the value of the convert property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isConvert() {
    return convert;
  }

  /**
   * Sets the value of the convert property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setConvert(Boolean value) {
    this.convert = value;
  }

  /**
   * Gets the value of the lookup property.
   *
   * @return possible object is
   * {@link CurrencyConversionLookup }
   */
  public CurrencyConversionLookup getLookup() {
    return lookup;
  }

  /**
   * Sets the value of the lookup property.
   *
   * @param value allowed object is
   *              {@link CurrencyConversionLookup }
   */
  public void setLookup(CurrencyConversionLookup value) {
    this.lookup = value;
  }

  /**
   * Gets the value of the accuracy property.
   *
   * @return possible object is
   * {@link CurrencyConversionAccuracy }
   */
  public CurrencyConversionAccuracy getAccuracy() {
    return accuracy;
  }

  /**
   * Sets the value of the accuracy property.
   *
   * @param value allowed object is
   *              {@link CurrencyConversionAccuracy }
   */
  public void setAccuracy(CurrencyConversionAccuracy value) {
    this.accuracy = value;
  }

  /**
   * Gets the value of the method property.
   *
   * @return possible object is
   * {@link ConversionMethod }
   */
  public ConversionMethod getMethod() {
    return method;
  }

  /**
   * Sets the value of the method property.
   *
   * @param value allowed object is
   *              {@link ConversionMethod }
   */
  public void setMethod(ConversionMethod value) {
    this.method = value;
  }

}
