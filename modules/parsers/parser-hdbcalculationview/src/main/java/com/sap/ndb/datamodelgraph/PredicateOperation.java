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


package com.sap.ndb.datamodelgraph;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Comparison operation with two arguments. At least one of the arguments must be a variable element
 *
 *
 * <p>Java class for PredicateOperation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PredicateOperation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.sap.com/ndb/DataModelGraph.ecore}Operation"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="argument" type="{http://www.sap.com/ndb/DataModelGraph.ecore}Argument" maxOccurs="2"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="operator" use="required" type="{http://www.sap.com/ndb/DataModelGraph.ecore}PredicateOperator" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PredicateOperation", propOrder = {
    "argument"
})
public class PredicateOperation
    extends Operation {

  @XmlElement(required = true)
  protected List<Argument> argument;
  @XmlAttribute(name = "operator", required = true)
  protected PredicateOperator operator;

  /**
   * Gets the value of the argument property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the argument property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getArgument().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link Argument }
   */
  public List<Argument> getArgument() {
    if (argument == null) {
      argument = new ArrayList<Argument>();
    }
    return this.argument;
  }

  /**
   * Gets the value of the operator property.
   *
   * @return possible object is
   * {@link PredicateOperator }
   */
  public PredicateOperator getOperator() {
    return operator;
  }

  /**
   * Sets the value of the operator property.
   *
   * @param value allowed object is
   *              {@link PredicateOperator }
   */
  public void setOperator(PredicateOperator value) {
    this.operator = value;
  }

}
