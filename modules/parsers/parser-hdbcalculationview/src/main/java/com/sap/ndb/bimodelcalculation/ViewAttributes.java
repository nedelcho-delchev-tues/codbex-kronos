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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * View Attributes Collection element for the Attributes of a Node
 *
 *
 * <p>Java class for ViewAttributes complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ViewAttributes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="viewAttribute" type="{http://www.sap.com/ndb/BiModelCalculation.ecore}ViewAttribute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="allViewAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewAttributes", propOrder = {
    "viewAttribute"
})
public class ViewAttributes {

  protected List<ViewAttribute> viewAttribute;
  @XmlAttribute(name = "allViewAttributes")
  protected Boolean allViewAttributes;

  /**
   * Gets the value of the viewAttribute property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the viewAttribute property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getViewAttribute().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link ViewAttribute }
   */
  public List<ViewAttribute> getViewAttribute() {
    if (viewAttribute == null) {
      viewAttribute = new ArrayList<ViewAttribute>();
    }
    return this.viewAttribute;
  }

  /**
   * Gets the value of the allViewAttributes property.
   *
   * @return possible object is
   * {@link Boolean }
   */
  public Boolean isAllViewAttributes() {
    return allViewAttributes;
  }

  /**
   * Sets the value of the allViewAttributes property.
   *
   * @param value allowed object is
   *              {@link Boolean }
   */
  public void setAllViewAttributes(Boolean value) {
    this.allViewAttributes = value;
  }

}
