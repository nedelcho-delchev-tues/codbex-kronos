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
package com.codbex.kronos.hdb.ds.test.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;

import org.eclipse.dirigible.api.v3.problems.ProblemsFacade;
import org.eclipse.dirigible.core.test.AbstractDirigibleTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.codbex.kronos.hdb.ds.model.XSKDataStructureModelFactory;
import com.codbex.kronos.hdb.ds.model.XSKDataStructureParametersModel;
import com.codbex.kronos.hdb.ds.model.hdbsynonym.XSKDataStructureHDBSynonymModel;
import com.codbex.kronos.hdb.ds.model.hdbsynonym.XSKHDBSYNONYMDefinitionModel;
import com.codbex.kronos.hdb.ds.parser.hdbsynonym.XSKSynonymParser;

public class XSKSynonymParserTest extends AbstractDirigibleTest {

  @Before
  public void openMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void parseHdbsynonymFileWithoutErrorsSuccessfully() throws Exception {
    String hdbsynonymSample = org.apache.commons.io.IOUtils
        .toString(XSKSynonymParserTest.class.getResourceAsStream("/MySynonym.hdbsynonym"), StandardCharsets.UTF_8);

    XSKDataStructureHDBSynonymModel model = XSKDataStructureModelFactory.parseSynonym("hdb_view/MySynonym.hdbsynonym", hdbsynonymSample);

    XSKHDBSYNONYMDefinitionModel definitionModel = model.getSynonymDefinitions().get("SY_DUMMY");
    assertEquals("hdb_view::MySynonym", model.getName());
    assertEquals("LL", definitionModel.getSynonymSchema());
    assertEquals("TABLE::CUSTOMERS", definitionModel.getTarget().getObject());
    assertEquals("DBADMIN", definitionModel.getTarget().getSchema());
  }

  @Ignore
  @Test
  public void parseHdbsynonymFileMissingTargetSchemaFailed() throws Exception {
    ProblemsFacade.clearAllProblems();
    String content = "{\n"
        + "    \"SY_DUMMY\": {\n"
        + "        \"target\": {\n"
        + "            \"object\": \"TABLE::CUSTOMERS\"\n"
        + "        },\n"
        + "        \"schema\": \"LL\"\n"
        + "    }\n"
        + "}";
    String errorMessage = "Missing mandatory field for synonym SY_DUMMY!";
    XSKSynonymParser parser = new XSKSynonymParser();
    XSKDataStructureParametersModel parametersModel =
        new XSKDataStructureParametersModel(null, "hdb_view/MySynonym.hdbsynonym", content, null);
    parser.parse(parametersModel);
    assertTrue(ProblemsFacade.fetchAllProblems().contains(errorMessage));
  }
}