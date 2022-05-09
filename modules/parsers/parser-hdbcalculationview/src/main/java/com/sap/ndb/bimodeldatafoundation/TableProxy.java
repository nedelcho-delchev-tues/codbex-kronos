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

import com.sap.ndb.basemodelbase.QualifiedColumnObjectName;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Link to a catalog data base table
 *
 *
 * <p>Java class for TableProxy complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TableProxy"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="table" type="{http://www.sap.com/ndb/BaseModelBase.ecore}QualifiedColumnObjectName"/&gt;
 *         &lt;element name="columnFilter" type="{http://www.sap.com/ndb/BiModelDataFoundation.ecore}ColumnFilter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="clientColumn" type="{http://www.sap.com/ndb/BaseModelBase.ecore}DbName" /&gt;
 *       &lt;attribute name="centralTable" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableProxy", propOrder = {
    "table",
    "columnFilter"
})
public class TableProxy {

  @XmlElement(required = true)
  protected QualifiedColumnObjectName table;
  protected List<ColumnFilter> columnFilter;
  @XmlAttribute(name = "clientColumn")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String clientColumn;
  @XmlAttribute(name = "centralTable")
  protected Boolean centralTable;

  /**
   * Gets the value of the table property.
   *
   * @return possible object is
   * {@link QualifiedColumnObjectName }
   */
  public QualifiedColumnObjectName getTable() {
    return table;
  }

  /**
   * Sets the value of the table property.
   *
   * @param value allowed object is
   *              {@link QualifiedColumnObjectName }
   */
  public void setTable(QualifiedColumnObjectName value) {
    this.table = value;
  }

  /**
   * Gets the value of the columnFilter property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the columnFilter property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getColumnFilter().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link ColumnFilter }
   */
  public List<ColumnFilter> getColumnFilter() {
    if (columnFilter == null) {
      columnFilter = new ArrayList<ColumnFilter>();
    }
    return this.columnFilter;
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
   * Gets the value of the centralTable property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isCentralTable() {
    return centralTable;
  }

  /**
   * Sets the value of the centralTable property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setCentralTable(Boolean value) {
    this.centralTable = value;
  }

}
