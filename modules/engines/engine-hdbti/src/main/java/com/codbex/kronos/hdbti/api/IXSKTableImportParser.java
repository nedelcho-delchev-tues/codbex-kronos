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
package com.codbex.kronos.hdbti.api;

import com.codbex.kronos.exceptions.XSKArtifactParserException;
import com.codbex.kronos.hdbti.model.XSKTableImportArtifact;
import com.codbex.kronos.parser.hdbti.exception.XSKHDBTISyntaxErrorException;

import java.io.IOException;
import java.sql.SQLException;

public interface IXSKTableImportParser {

  XSKTableImportArtifact parseTableImportArtifact(String location, String content)
      throws IOException, XSKHDBTISyntaxErrorException, XSKArtifactParserException, SQLException;
}
