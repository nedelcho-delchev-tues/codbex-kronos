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


package com.sap.ndb.bimodelcalculation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A data source either maps a repository object or a data base object as input of the calculation scenario.
 * Attention: Although it inherits from resource:EcoreIDObjectWithDescription texts are not yet used for data sources.
 * For table function we are already using	the full qualified names in the resourceURI
 * e.g. package.subpackage::MyFunction.hdbtablefunction
 *
 *
 * <p>Java class for DataSource complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DataSource"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/BiModelCalculation.ecore}Node"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="resourceUri" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}RepositoryUri"/&gt;
 *             &lt;element name="databaseName" type="{http://www.sap.com/ndb/BaseModelBase.ecore}DbName" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="partitionAttributeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="clientColumn" type="{http://www.sap.com/ndb/BaseModelBase.ecore}DbName" /&gt;
 *       &lt;attribute name="partitionedExecution" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSource", propOrder = {
    "resourceUri",
    "databaseName",
    "partitionAttributeName"
})
public class DataSource
    extends Node {

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String resourceUri;
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String databaseName;
  protected String partitionAttributeName;
  @XmlAttribute(name = "clientColumn")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String clientColumn;
  @XmlAttribute(name = "partitionedExecution")
  protected Boolean partitionedExecution;

  /**
   * Gets the value of the resourceUri property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getResourceUri() {
    return resourceUri;
  }

  /**
   * Sets the value of the resourceUri property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setResourceUri(String value) {
    this.resourceUri = value;
  }

  /**
   * Gets the value of the databaseName property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getDatabaseName() {
    return databaseName;
  }

  /**
   * Sets the value of the databaseName property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDatabaseName(String value) {
    this.databaseName = value;
  }

  /**
   * Gets the value of the partitionAttributeName property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getPartitionAttributeName() {
    return partitionAttributeName;
  }

  /**
   * Sets the value of the partitionAttributeName property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setPartitionAttributeName(String value) {
    this.partitionAttributeName = value;
  }

  /**
   * Gets the value of the clientColumn property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getClientColumn() {
    return clientColumn;
  }

  /**
   * Sets the value of the clientColumn property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setClientColumn(String value) {
    this.clientColumn = value;
  }

  /**
   * Gets the value of the partitionedExecution property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isPartitionedExecution() {
    return partitionedExecution;
  }

  /**
   * Sets the value of the partitionedExecution property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setPartitionedExecution(Boolean value) {
    this.partitionedExecution = value;
  }

}
