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


package com.codbex.kronos.ndb.bimodelprivilege;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * For specifying a hierarchy and a set of its nodes the user is privileged to see.
 * The nodes can be specified in the following ways:
 * 1. Directly specify one or more node IDs. Then the user is privileged to see all subtrees of these nodes
 * 2. A hierarchy expression. Then  the user is privileged to see all nodes in the result of the expression (e.g. all children of a specific node)
 *
 *
 * Java class for HierarchyFilter complex type.
 *
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HierarchyFilter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="subtreeNode" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="hierarchyName" use="required" type="{http://www.sap.com/ndb/RepositoryModelResource.ecore}Identifier" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HierarchyFilter", propOrder = {
    "subtreeNode"
})
public class HierarchyFilter {

  /** The subtree node. */
  protected List<String> subtreeNode;
  
  /** The hierarchy name. */
  @XmlAttribute(name = "hierarchyName", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String hierarchyName;

  /**
   * Gets the value of the subtreeNode property.
   * 
   * 
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the subtreeNode property.
   * 
   * 
   * For example, to add a new item, do as follows:
   * <pre>
   *    getSubtreeNode().add(newItem);
   * </pre>
   * 
   * 
   * 
   * Objects of the following type(s) are allowed in the list
   * {@link String }
   *
   * @return the subtree node
   */
  public List<String> getSubtreeNode() {
    if (subtreeNode == null) {
      subtreeNode = new ArrayList<String>();
    }
    return this.subtreeNode;
  }

  /**
   * Gets the value of the hierarchyName property.
   *
   * @return possible object is
   * {@link String }
   */
  public String getHierarchyName() {
    return hierarchyName;
  }

  /**
   * Sets the value of the hierarchyName property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setHierarchyName(String value) {
    this.hierarchyName = value;
  }

}
