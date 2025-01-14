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
package com.codbex.kronos.xsodata.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import com.codbex.kronos.exceptions.ArtifactParserException;
import com.codbex.kronos.parser.xsodata.model.XSODataEntity;
import com.codbex.kronos.parser.xsodata.model.XSODataEventType;
import com.codbex.kronos.parser.xsodata.model.XSODataHandlerMethod;
import com.codbex.kronos.utils.CommonsDBUtils;
import com.codbex.kronos.xsodata.ds.model.DBArtifactModel;
import com.codbex.kronos.xsodata.ds.model.ODataModel;
import com.codbex.kronos.xsodata.ds.service.OData2TransformerException;
import com.codbex.kronos.xsodata.ds.service.ODataParser;
import com.codbex.kronos.xsodata.ds.service.TableMetadataProvider;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.io.IOUtils;
import org.eclipse.dirigible.core.test.AbstractDirigibleTest;
import org.eclipse.dirigible.database.persistence.model.PersistenceTableColumnModel;
import org.eclipse.dirigible.database.persistence.model.PersistenceTableModel;
import org.eclipse.dirigible.database.persistence.model.PersistenceTableRelationModel;
import org.eclipse.dirigible.database.sql.ISqlKeywords;
import org.eclipse.dirigible.engine.odata2.definition.ODataDefinition;
import org.eclipse.dirigible.engine.odata2.definition.ODataEntityDefinition;
import org.eclipse.dirigible.engine.odata2.definition.ODataHandlerMethods;
import org.eclipse.dirigible.engine.odata2.definition.ODataHandlerTypes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ODataUtilsTest extends AbstractDirigibleTest {

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private Connection mockConnection;

  @Mock
  private DataSource mockDataSource;

  @Mock
  private ResultSet mockResultSet;

  @Mock
  private PreparedStatement mockPreparedStatement;

  @Mock
  private TableMetadataProvider metadataProvider;

  @InjectMocks
  private ODataUtils oDataUtil;

  @Spy
  @InjectMocks
  private final ODataParser parser = new ODataParser();

  @Before
  public void openMocks() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testConvertMultiplicityOneToMany() throws Exception {
    String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_multiplicity_one_to_many.xsodata"),
        StandardCharsets.UTF_8);
    ODataModel oDataModel = parser.parseODataArtifact("np/entity_multiplicity_one_to_many.xsodata", content);

    ODataDefinition oDataDefinition = oDataUtil.convertODataModelToODataDefinition(oDataModel);

    assertEquals("1", oDataDefinition.getAssociations().get(0).getFrom().getMultiplicity());
    assertEquals("*", oDataDefinition.getAssociations().get(0).getTo().getMultiplicity());
  }

  @Test
  public void testConvertWithoutSetOfPropAndLimitedExposedNavigations() throws Exception {
    String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_without_set_of_prop.xsodata"), StandardCharsets.UTF_8);
    ODataModel oDataModel = parser.parseODataArtifact("np/entity_without_set_of_prop.xsodata", content);

    PersistenceTableColumnModel column1 = new PersistenceTableColumnModel("COMPANY_ID", "Edm.Int32", false, true, 0, 0);
    PersistenceTableColumnModel column2 = new PersistenceTableColumnModel("EMPLOYEE_NUMBER", "Edm.Int32", false, true, 0, 0);
    PersistenceTableColumnModel column9 = new PersistenceTableColumnModel("ORDER_ID", "Edm.Int32", false, true, 0, 0);
    column9.setNullable(true);
    PersistenceTableModel model = new PersistenceTableModel("kneo.test.helloodata.CompositeKey::employee",
        Arrays.asList(column1, column2, column9), new ArrayList<>(), new ArrayList<>());
    model.setTableType(ISqlKeywords.METADATA_TABLE);
    when(metadataProvider.getPersistenceTableModel("kneo.test.helloodata.CompositeKey::employee")).thenReturn(model);

    PersistenceTableColumnModel column3 = new PersistenceTableColumnModel("NUMBER", "Edm.Int32", false, true, 0, 0);
    PersistenceTableColumnModel column4 = new PersistenceTableColumnModel("FK_COMPANY_ID", "Edm.Int32", true, false, 0, 0);
    PersistenceTableColumnModel column5 = new PersistenceTableColumnModel("FK_EMPLOYEE_NUMBER", "Edm.Int32", true, false, 0, 0);
    PersistenceTableColumnModel column6 = new PersistenceTableColumnModel("FK_ADDRESS_ID", "Edm.Int32", true, false, 0, 0);
    PersistenceTableRelationModel rel = new PersistenceTableRelationModel("kneo.test.helloodata.CompositeKey::phones",
        "kneo.test.helloodata.CompositeKey::employee", "FK_COMPANY_ID", "COMPANY_ID", "CONSTRAINT_8C", "CONSTRAINT_INDEX_4");
    PersistenceTableRelationModel rel2 = new PersistenceTableRelationModel("kneo.test.helloodata.CompositeKey::phones",
        "kneo.test.helloodata.CompositeKey::employee", "FK_EMPLOYEE_NUMBER", "EMPLOYEE_NUMBER", "CONSTRAINT_8C9", "CONSTRAINT_INDEX_43");
    PersistenceTableRelationModel rel3 = new PersistenceTableRelationModel("kneo.test.helloodata.CompositeKey::phones",
        "kneo.test.helloodata.CompositeKey::address", "FK_ADDRESS_ID", "ID", "CONSTRAINT_8C9F", "CONSTRAINT_INDEX_E6");
    model = new PersistenceTableModel("kneo.test.helloodata.CompositeKey::phones", Arrays.asList(column3, column4, column5, column6),
        Arrays.asList(rel, rel2, rel3), new ArrayList<>());
    model.setTableType(ISqlKeywords.METADATA_TABLE);
    when(metadataProvider.getPersistenceTableModel("kneo.test.helloodata.CompositeKey::phones")).thenReturn(model);

    ODataDefinition oDataDefinition = oDataUtil.convertODataModelToODataDefinition(oDataModel);

    assertEquals(2, oDataDefinition.getEntities().size());
    assertEquals(1, oDataDefinition.getAssociations().size());
    assertEquals("np", oDataDefinition.getNamespace());
    assertNull(oDataDefinition.getCreatedAt());
    assertNull(oDataDefinition.getHash());
    assertEquals("np/entity_without_set_of_prop.xsodata", oDataDefinition.getLocation());

    ODataEntityDefinition employeeEntity = oDataDefinition.getEntities().get(0);
    assertEquals("Employees", employeeEntity.getName());
    assertEquals("Employees", employeeEntity.getAlias());
    assertEquals("kneo.test.helloodata.CompositeKey::employee", employeeEntity.getTable());
    assertEquals(2, employeeEntity.getProperties().size());
    assertEquals("COMPANY_ID", employeeEntity.getProperties().get(0).getName());
    assertEquals("COMPANY_ID", employeeEntity.getProperties().get(0).getColumn());
    assertFalse(employeeEntity.getProperties().get(0).isNullable());
    assertEquals("Edm.Int32", employeeEntity.getProperties().get(0).getType());
    assertEquals("EMPLOYEE_NUMBER", employeeEntity.getProperties().get(1).getName());
    assertEquals("EMPLOYEE_NUMBER", employeeEntity.getProperties().get(1).getColumn());
    assertFalse(employeeEntity.getProperties().get(1).isNullable());
    assertEquals("Edm.Int32", employeeEntity.getProperties().get(1).getType());
    assertEquals(0, employeeEntity.getHandlers().size());
    assertEquals(1, employeeEntity.getNavigations().size());
    assertEquals("HisPhones", employeeEntity.getNavigations().get(0).getName());
    assertEquals("Employees_Phones", employeeEntity.getNavigations().get(0).getAssociation());

    ODataEntityDefinition phoneEntity = oDataDefinition.getEntities().get(1);
    assertEquals("Phones", phoneEntity.getName());
    assertEquals("Phones", phoneEntity.getAlias());
    assertEquals("kneo.test.helloodata.CompositeKey::phones", phoneEntity.getTable());
    assertEquals(0, phoneEntity.getProperties().size());
    assertEquals(0, phoneEntity.getHandlers().size());
    assertEquals(0, phoneEntity.getNavigations().size());

    assertEquals("Employees_Phones", oDataDefinition.getAssociations().get(0).getName());
    assertEquals("Employees", oDataDefinition.getAssociations().get(0).getFrom().getEntity());
    assertNull(oDataDefinition.getAssociations().get(0).getFrom().getColumn());
    assertEquals("1", oDataDefinition.getAssociations().get(0).getFrom().getMultiplicity());
    assertEquals(2, oDataDefinition.getAssociations().get(0).getFrom().getProperties().size());
    assertEquals("COMPANY_ID", oDataDefinition.getAssociations().get(0).getFrom().getProperties().get(0));
    assertEquals("EMPLOYEE_NUMBER", oDataDefinition.getAssociations().get(0).getFrom().getProperties().get(1));

    assertEquals("Phones", oDataDefinition.getAssociations().get(0).getTo().getEntity());
    assertNull(oDataDefinition.getAssociations().get(0).getTo().getColumn());
    assertEquals("*", oDataDefinition.getAssociations().get(0).getTo().getMultiplicity());
    assertEquals(2, oDataDefinition.getAssociations().get(0).getTo().getProperties().size());
    assertEquals("FK_COMPANY_ID", oDataDefinition.getAssociations().get(0).getTo().getProperties().get(0));
    assertEquals("FK_EMPLOYEE_NUMBER", oDataDefinition.getAssociations().get(0).getTo().getProperties().get(1));
  }

  @Test
  public void testConvertWithSetOfPropAndLimitedExposedNavigations() throws Exception {
    String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_set_of_prop.xsodata"), StandardCharsets.UTF_8);
    ODataModel oDataModel = parser.parseODataArtifact("np/entity_with_set_of_prop.xsodata", content);

    PersistenceTableColumnModel column1 = new PersistenceTableColumnModel("COMPANY_ID", "Edm.Int32", false, true, 0, 0);
    PersistenceTableColumnModel column2 = new PersistenceTableColumnModel("EMPLOYEE_NUMBER", "Edm.Int32", false, true, 0, 0);
    PersistenceTableColumnModel column9 = new PersistenceTableColumnModel("ORDER_ID", "Edm.Int32", true, false, 0, 0);
    column9.setNullable(true);
    PersistenceTableColumnModel column10 = new PersistenceTableColumnModel("ORDER_ID_2", "Edm.Int32", true, false, 0, 0);
    column10.setNullable(true);
    PersistenceTableModel model = new PersistenceTableModel("kneo.test.helloodata.CompositeKey::employee",
        Arrays.asList(column1, column2, column9, column10), new ArrayList<>(), new ArrayList<>());
    model.setTableType(ISqlKeywords.METADATA_TABLE);
    when(metadataProvider.getPersistenceTableModel("kneo.test.helloodata.CompositeKey::employee")).thenReturn(model);

    PersistenceTableColumnModel column3 = new PersistenceTableColumnModel("NUMBER", "Edm.Int32", false, true, 0, 0);
    PersistenceTableColumnModel column4 = new PersistenceTableColumnModel("FK_COMPANY_ID", "Edm.Int32", true, false, 0, 0);
    PersistenceTableColumnModel column5 = new PersistenceTableColumnModel("FK_EMPLOYEE_NUMBER", "Edm.Int32", true, false, 0, 0);
    PersistenceTableColumnModel column6 = new PersistenceTableColumnModel("FK_ADDRESS_ID", "Edm.Int32", true, false, 0, 0);
    PersistenceTableRelationModel rel = new PersistenceTableRelationModel("kneo.test.helloodata.CompositeKey::phones",
        "kneo.test.helloodata.CompositeKey::employee", "FK_COMPANY_ID", "COMPANY_ID", "CONSTRAINT_8C", "CONSTRAINT_INDEX_4");
    PersistenceTableRelationModel rel2 = new PersistenceTableRelationModel("kneo.test.helloodata.CompositeKey::phones",
        "kneo.test.helloodata.CompositeKey::employee", "FK_EMPLOYEE_NUMBER", "EMPLOYEE_NUMBER", "CONSTRAINT_8C9", "CONSTRAINT_INDEX_43");
    PersistenceTableRelationModel rel3 = new PersistenceTableRelationModel("kneo.test.helloodata.CompositeKey::phones",
        "kneo.test.helloodata.CompositeKey::address", "FK_ADDRESS_ID", "ID", "CONSTRAINT_8C9F", "CONSTRAINT_INDEX_E6");
    model = new PersistenceTableModel("kneo.test.helloodata.CompositeKey::phones", Arrays.asList(column3, column4, column5, column6),
        Arrays.asList(rel, rel2, rel3), new ArrayList<>());
    model.setTableType(ISqlKeywords.METADATA_TABLE);
    when(metadataProvider.getPersistenceTableModel("kneo.test.helloodata.CompositeKey::phones")).thenReturn(model);

    ODataDefinition oDataDefinition = oDataUtil.convertODataModelToODataDefinition(oDataModel);
    assertEquals(2, oDataDefinition.getEntities().size());
    assertEquals(1, oDataDefinition.getAssociations().size());
    assertEquals("np", oDataDefinition.getNamespace());
    assertNull(oDataDefinition.getCreatedAt());
    assertNull(oDataDefinition.getHash());
    assertEquals("np/entity_with_set_of_prop.xsodata", oDataDefinition.getLocation());

    ODataEntityDefinition employeeEntity = oDataDefinition.getEntities().get(0);
    assertEquals("Employees", employeeEntity.getName());
    assertEquals("Employees", employeeEntity.getAlias());
    assertEquals("kneo.test.helloodata.CompositeKey::employee", employeeEntity.getTable());

    assertEquals(3, employeeEntity.getProperties().size());
    assertEquals("COMPANY_ID", employeeEntity.getProperties().get(0).getName());
    assertEquals("COMPANY_ID", employeeEntity.getProperties().get(0).getColumn());
    assertFalse(employeeEntity.getProperties().get(0).isNullable());
    assertEquals("Edm.Int32", employeeEntity.getProperties().get(0).getType());
    assertEquals("EMPLOYEE_NUMBER", employeeEntity.getProperties().get(1).getName());
    assertEquals("EMPLOYEE_NUMBER", employeeEntity.getProperties().get(1).getColumn());
    assertFalse(employeeEntity.getProperties().get(1).isNullable());
    assertEquals("Edm.Int32", employeeEntity.getProperties().get(1).getType());
    assertEquals("ORDER_ID", employeeEntity.getProperties().get(2).getName());
    assertEquals("ORDER_ID", employeeEntity.getProperties().get(2).getColumn());
    assertTrue(employeeEntity.getProperties().get(2).isNullable());
    assertEquals("Edm.Int32", employeeEntity.getProperties().get(2).getType());

    assertEquals(0, employeeEntity.getHandlers().size());
    assertEquals(1, employeeEntity.getNavigations().size());
    assertEquals("HisPhones", employeeEntity.getNavigations().get(0).getName());
    assertEquals("Employees_Phones", employeeEntity.getNavigations().get(0).getAssociation());

    ODataEntityDefinition phoneEntity = oDataDefinition.getEntities().get(1);
    assertEquals("Phones", phoneEntity.getName());
    assertEquals("Phones", phoneEntity.getAlias());
    assertEquals("kneo.test.helloodata.CompositeKey::phones", phoneEntity.getTable());
    assertEquals(0, phoneEntity.getProperties().size());
    assertEquals(0, phoneEntity.getHandlers().size());
    assertEquals(0, phoneEntity.getNavigations().size());

    assertEquals("Employees_Phones", oDataDefinition.getAssociations().get(0).getName());
    assertEquals("Employees", oDataDefinition.getAssociations().get(0).getFrom().getEntity());
    assertNull(oDataDefinition.getAssociations().get(0).getFrom().getColumn());
    assertEquals("1", oDataDefinition.getAssociations().get(0).getFrom().getMultiplicity());
    assertEquals(2, oDataDefinition.getAssociations().get(0).getFrom().getProperties().size());
    assertEquals("COMPANY_ID", oDataDefinition.getAssociations().get(0).getFrom().getProperties().get(0));
    assertEquals("EMPLOYEE_NUMBER", oDataDefinition.getAssociations().get(0).getFrom().getProperties().get(1));

    assertEquals("Phones", oDataDefinition.getAssociations().get(0).getTo().getEntity());
    assertNull(oDataDefinition.getAssociations().get(0).getTo().getColumn());
    assertEquals("*", oDataDefinition.getAssociations().get(0).getTo().getMultiplicity());
    assertEquals(2, oDataDefinition.getAssociations().get(0).getTo().getProperties().size());
    assertEquals("FK_COMPANY_ID", oDataDefinition.getAssociations().get(0).getTo().getProperties().get(0));
    assertEquals("FK_EMPLOYEE_NUMBER", oDataDefinition.getAssociations().get(0).getTo().getProperties().get(1));
  }

  @Test
  public void testConvertOfEvents() throws Exception {
    String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_events.xsodata"), StandardCharsets.UTF_8);
    ODataModel oDataModel = parser.parseODataArtifact("np/entity_with_events.xsodata", content);

    mockTableMetadataInvocations("sample.odata::table1");
    mockTableMetadataInvocations("sample.odata::table2");
    mockTableMetadataInvocations("sample.odata::table3");
    mockTableMetadataInvocations("sample.odata::table4");

    ODataDefinition oDataDefinition = oDataUtil.convertODataModelToODataDefinition(oDataModel);
    assertEquals(4, oDataDefinition.getEntities().size());

    ODataEntityDefinition entity1 = oDataDefinition.getEntities().get(0);
    assertEquals(3, entity1.getHandlers().size());
    assertEquals(ODataHandlerMethods.update.name(), entity1.getHandlers().get(0).getMethod());
    assertEquals(ODataHandlerTypes.before.name(), entity1.getHandlers().get(0).getType());
    assertEquals("sample.odata::beforeMethod", entity1.getHandlers().get(0).getHandler());
    assertEquals(ODataHandlerMethods.delete.name(), entity1.getHandlers().get(1).getMethod());
    assertEquals(ODataHandlerTypes.after.name(), entity1.getHandlers().get(1).getType());
    assertEquals("sample.odata::afterMethod", entity1.getHandlers().get(1).getHandler());
    assertEquals(ODataHandlerMethods.create.name(), entity1.getHandlers().get(2).getMethod());
    assertEquals(ODataHandlerTypes.forbid.name(), entity1.getHandlers().get(2).getType());
    assertNull(entity1.getHandlers().get(2).getHandler());
    assertEquals("false", entity1.getAnnotationsEntitySet().get(XSODataHandlerMethod.CREATE.getOdataSAPAnnotation()));
    assertNull(entity1.getAnnotationsEntitySet().get(XSODataHandlerMethod.UPDATE.getOdataSAPAnnotation()));
    assertNull(entity1.getAnnotationsEntitySet().get(XSODataHandlerMethod.DELETE.getOdataSAPAnnotation()));

    ODataEntityDefinition entity2 = oDataDefinition.getEntities().get(1);
    assertEquals(4, entity2.getHandlers().size());
    assertEquals(ODataHandlerMethods.create.name(), entity2.getHandlers().get(0).getMethod());
    assertEquals(ODataHandlerTypes.after.name(), entity2.getHandlers().get(0).getType());
    assertEquals("sample.odata::afterMethod", entity2.getHandlers().get(0).getHandler());
    assertEquals(ODataHandlerMethods.create.name(), entity2.getHandlers().get(1).getMethod());
    assertEquals(ODataHandlerTypes.on.name(), entity2.getHandlers().get(1).getType());
    assertEquals("sample.odata::createMethod", entity2.getHandlers().get(1).getHandler());
    assertEquals(ODataHandlerMethods.update.name(), entity2.getHandlers().get(2).getMethod());
    assertEquals(ODataHandlerTypes.on.name(), entity2.getHandlers().get(2).getType());
    assertEquals("sample.odata::updateMethod", entity2.getHandlers().get(2).getHandler());
    assertEquals(ODataHandlerMethods.delete.name(), entity2.getHandlers().get(3).getMethod());
    assertEquals(ODataHandlerTypes.on.name(), entity2.getHandlers().get(3).getType());
    assertEquals("sample.odata::deleteMethod", entity2.getHandlers().get(3).getHandler());
    assertNull(entity2.getAnnotationsEntitySet().get(XSODataHandlerMethod.CREATE.getOdataSAPAnnotation()));
    assertNull(entity2.getAnnotationsEntitySet().get(XSODataHandlerMethod.UPDATE.getOdataSAPAnnotation()));
    assertNull(entity2.getAnnotationsEntitySet().get(XSODataHandlerMethod.DELETE.getOdataSAPAnnotation()));

    ODataEntityDefinition entity3 = oDataDefinition.getEntities().get(2);
    assertEquals(2, entity3.getHandlers().size());
    assertEquals(ODataHandlerMethods.create.name(), entity3.getHandlers().get(0).getMethod());
    assertEquals(ODataHandlerTypes.on.name(), entity3.getHandlers().get(0).getType());
    assertEquals("sample.odata::createMethod", entity3.getHandlers().get(0).getHandler());
    assertEquals(ODataHandlerMethods.delete.name(), entity3.getHandlers().get(1).getMethod());
    assertEquals(ODataHandlerTypes.forbid.name(), entity3.getHandlers().get(1).getType());
    assertNull(entity3.getHandlers().get(1).getHandler());
    assertNull(entity3.getAnnotationsEntitySet().get(XSODataHandlerMethod.CREATE.getOdataSAPAnnotation()));
    assertNull(entity3.getAnnotationsEntitySet().get(XSODataHandlerMethod.UPDATE.getOdataSAPAnnotation()));
    assertEquals("false", entity3.getAnnotationsEntitySet().get(XSODataHandlerMethod.DELETE.getOdataSAPAnnotation()));

    ODataEntityDefinition entity4 = oDataDefinition.getEntities().get(3);
    assertEquals(3, entity4.getHandlers().size());
    assertEquals(ODataHandlerMethods.create.name(), entity4.getHandlers().get(0).getMethod());
    assertEquals(ODataHandlerTypes.forbid.name(), entity4.getHandlers().get(0).getType());
    assertNull(entity4.getHandlers().get(0).getHandler());
    assertEquals(ODataHandlerMethods.update.name(), entity4.getHandlers().get(1).getMethod());
    assertEquals(ODataHandlerTypes.forbid.name(), entity4.getHandlers().get(1).getType());
    assertNull(entity4.getHandlers().get(1).getHandler());
    assertEquals(ODataHandlerMethods.delete.name(), entity4.getHandlers().get(2).getMethod());
    assertEquals(ODataHandlerTypes.forbid.name(), entity4.getHandlers().get(2).getType());
    assertNull(entity4.getHandlers().get(2).getHandler());
    assertEquals("false", entity4.getAnnotationsEntitySet().get(XSODataHandlerMethod.CREATE.getOdataSAPAnnotation()));
    assertEquals("false", entity4.getAnnotationsEntitySet().get(XSODataHandlerMethod.UPDATE.getOdataSAPAnnotation()));
    assertEquals("false", entity4.getAnnotationsEntitySet().get(XSODataHandlerMethod.DELETE.getOdataSAPAnnotation()));
  }

  private void mockTableMetadataInvocations(String tableName) throws SQLException {
    PersistenceTableModel model = new PersistenceTableModel(tableName, null, null, null);
    when(metadataProvider.getPersistenceTableModel(tableName)).thenReturn(model);
  }

  @Test(expected = OData2TransformerException.class)
  public void testValidateEdmMultiplicityFailed() {
    oDataUtil.validateEdmMultiplicity("1..*", "ass_name");
  }

  @Test
  public void testValidateEdmMultiplicitySuccessfully() {
    oDataUtil.validateEdmMultiplicity("0..1", "ass_name");
    oDataUtil.validateEdmMultiplicity("*", "ass_name");
    oDataUtil.validateEdmMultiplicity("1", "ass_name");
  }

  @Test
  public void testValidateHandlerTypeFailed() {
    assertFalse(oDataUtil.validateHandlerType(XSODataEventType.POSTCOMMIT));
    assertFalse(oDataUtil.validateHandlerType(XSODataEventType.PRECOMMIT));
  }

  @Test
  public void testValidateHandlerTypeSuccessfully() {
    assertTrue(oDataUtil.validateHandlerType(XSODataEventType.AFTER));
    assertTrue(oDataUtil.validateHandlerType(XSODataEventType.BEFORE));
  }

  @Test
  public void testCalcView() throws Exception {
    String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_calc_view.xsodata"), StandardCharsets.UTF_8);
    ODataModel oDataModel = parser.parseODataArtifact("np/entity_calc_view.xsodata", content);

    PersistenceTableColumnModel column1 = new PersistenceTableColumnModel("COLUMN1", "Edm.Int32", true, false, 0, 0);
    PersistenceTableColumnModel column2 = new PersistenceTableColumnModel("COLUMN2", "Edm.Int32", true, false, 0, 0);
    PersistenceTableColumnModel column3 = new PersistenceTableColumnModel("COLUMN3", "Edm.Int32", true, false, 0, 0);
    PersistenceTableModel model = new PersistenceTableModel("kneo.test.calcviews::calc", Arrays.asList(column1, column2, column3),
        new ArrayList<>(), new ArrayList<>());
    model.setTableType("CALC VIEW");

    when(metadataProvider.getPersistenceTableModel("kneo.test.calcviews::calc")).thenReturn(model);
    when(mockDataSource.getConnection()).thenReturn(mockConnection);
    when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

    ODataDefinition oDataDefinition = oDataUtil.convertODataModelToODataDefinition(oDataModel);

    assertEquals(3, oDataDefinition.getEntities().get(0).getProperties().size());
    assertEquals(1, oDataDefinition.getEntities().get(1).getProperties().size());
    assertEquals(2, oDataDefinition.getEntities().get(2).getProperties().size());
  }

  @Test
  public void testCalcViewWithInputParameters() throws Exception {
    String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_calc_view_with_input_parameters.xsodata"),
        StandardCharsets.UTF_8);

    DBArtifactModel dbArtifactModelCalcView = new DBArtifactModel(ISqlKeywords.METADATA_CALC_VIEW, ISqlKeywords.METADATA_CALC_VIEW,
        ISqlKeywords.METADATA_CALC_VIEW);

    when(mockDataSource.getConnection()).thenReturn(mockConnection);
    when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

    doReturn(List.of(dbArtifactModelCalcView)).when(parser).getDBArtifactsByName(anyString());

    ODataModel oDataModel = parser.parseODataArtifact("np/entity_calc_view_with_input_parameters.xsodata", content);

    PersistenceTableColumnModel column1 = new PersistenceTableColumnModel("COLUMN1", "Edm.Int32", true, false, 0, 0);
    PersistenceTableColumnModel column2 = new PersistenceTableColumnModel("COLUMN2", "Edm.Int32", true, false, 0, 0);
    PersistenceTableColumnModel column3 = new PersistenceTableColumnModel("COLUMN3", "Edm.Int32", true, false, 0, 0);
    PersistenceTableModel model = new PersistenceTableModel("kneo.test.calcviews::calc", Arrays.asList(column1, column2, column3),
        new ArrayList<>(), new ArrayList<>());
    model.setTableType("CALC VIEW");

    when(metadataProvider.getPersistenceTableModel("kneo.test.calcviews::calc")).thenReturn(model);
    when(mockDataSource.getConnection()).thenReturn(mockConnection);
    when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
    when(mockResultSet.next()).thenReturn(true).thenReturn(false).thenReturn(true).thenReturn(false);
    when(mockResultSet.getString("VARIABLE_NAME")).thenReturn("CurrentUserId");
    when(mockResultSet.getString("COLUMN_SQL_TYPE")).thenReturn("INTEGER");
    when(mockResultSet.getString("MANDATORY")).thenReturn("0");

    ODataDefinition oDataDefinition = oDataUtil.convertODataModelToODataDefinition(oDataModel);

    assertEquals(3, oDataDefinition.getEntities().get(0).getProperties().size());
    assertEquals(1, oDataDefinition.getEntities().get(0).getParameters().size());

    assertEquals(0, oDataDefinition.getEntities().get(1).getProperties().size());
    assertEquals(1, oDataDefinition.getEntities().get(1).getParameters().size());
    assertEquals(1, oDataDefinition.getEntities().get(1).getNavigations().size());

    assertEquals(3, oDataDefinition.getEntities().get(2).getProperties().size());
    assertEquals(1, oDataDefinition.getEntities().get(2).getParameters().size());

    assertEquals(0, oDataDefinition.getEntities().get(3).getProperties().size());
    assertEquals(1, oDataDefinition.getEntities().get(3).getParameters().size());
    assertEquals(1, oDataDefinition.getEntities().get(3).getNavigations().size());

    assertEquals(2, oDataDefinition.getAssociations().size());
  }

  @Test
  public void testSynonym() throws Exception {
    try (MockedStatic<CommonsDBUtils> commonsDBUtils = Mockito.mockStatic(CommonsDBUtils.class)) {

      String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_synonym.xsodata"), StandardCharsets.UTF_8);
      ODataModel oDataModel = parser.parseODataArtifact("np/entity_synonym.xsodata", content);

      PersistenceTableColumnModel column1 = new PersistenceTableColumnModel("COLUMN1", "Edm.Int32", true, false, 0, 0);
      PersistenceTableColumnModel column2 = new PersistenceTableColumnModel("COLUMN2", "Edm.Int32", true, false, 0, 0);
      PersistenceTableColumnModel column3 = new PersistenceTableColumnModel("COLUMN3", "Edm.Int32", true, false, 0, 0);

      PersistenceTableModel calcViewModel = new PersistenceTableModel("kneo.test.calcviews::calc", Arrays.asList(column1, column2, column3),
          new ArrayList<>(), new ArrayList<>());
      calcViewModel.setTableType(ISqlKeywords.METADATA_CALC_VIEW);

      when(metadataProvider.getPersistenceTableModel("TestCalcView")).thenReturn(calcViewModel);
      when(mockDataSource.getConnection()).thenReturn(mockConnection);
      when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
      when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

      ODataDefinition oDataDefinition = oDataUtil.convertODataModelToODataDefinition(oDataModel);

      assertEquals(3, oDataDefinition.getEntities().get(0).getProperties().size());
      assertEquals(1, oDataDefinition.getEntities().get(1).getProperties().size());
      assertEquals(2, oDataDefinition.getEntities().get(2).getProperties().size());
    }

  }

  @Test
  public void testProperNavigationConstruction() throws IOException, ArtifactParserException, SQLException {
    String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_3_navigations.xsodata"), StandardCharsets.UTF_8);
    ODataModel oDataModel = parser.parseODataArtifact("np/entity_with_3_navigations.xsodata", content);

    ODataDefinition oDataDefinitionModel = new ODataDefinition();
    for (XSODataEntity entity : oDataModel.getService().getEntities()) {
      ODataEntityDefinition oDataEntityDefinition = new ODataEntityDefinition();
      entity.getNavigates().forEach(oDataUtil.processNavigation(oDataModel, oDataDefinitionModel, oDataEntityDefinition));

      assertEquals("Unexpected number of navigations for entity: " + entity.getAlias(), entity.getNavigates().size(),
          oDataEntityDefinition.getNavigations().size());
    }

  }

  @Test
  public void testAggregationsConstruction() throws Exception {
    ODataParser parser = new ODataParser();
    String content = IOUtils.toString(this.getClass().getResourceAsStream("/entity_with_aggregations_for_conversion.xsodata"),
        StandardCharsets.UTF_8);
    ODataModel oDataModel = parser.parseODataArtifact("np/entity_with_aggregations_for_conversion.xsodata", content);

    PersistenceTableColumnModel column1 = new PersistenceTableColumnModel("USER_ID", "Edm.Int32", false, true, 0, 0);
    PersistenceTableColumnModel column2 = new PersistenceTableColumnModel("USER_PAYMENT", "Edm.Int32", true, false, 0, 0);
    PersistenceTableColumnModel column3 = new PersistenceTableColumnModel("ROLE_NUMBER", "Edm.Int32", true, false, 0, 0);
    PersistenceTableModel model = new PersistenceTableModel("TEST_VIEW", Arrays.asList(column1, column2, column3),
        new ArrayList<>(), new ArrayList<>());
    model.setTableType("CALC VIEW");
    when(metadataProvider.getPersistenceTableModel("TEST_VIEW")).thenReturn(model);

    ODataDefinition oDataDefinition = oDataUtil.convertODataModelToODataDefinition(oDataModel);

    assertTrue(oDataDefinition.getEntities().get(0).getAggregationsTypeAndColumn().containsKey("USER_PAYMENT"));
    assertTrue(oDataDefinition.getEntities().get(0).getAggregationsTypeAndColumn().containsValue("SUM"));
    assertTrue(oDataDefinition.getEntities().get(0).getAnnotationsEntityType().containsKey("sap:semantics"));
    assertTrue(oDataDefinition.getEntities().get(0).getAnnotationsEntityType().containsValue("aggregate"));
  }
}
