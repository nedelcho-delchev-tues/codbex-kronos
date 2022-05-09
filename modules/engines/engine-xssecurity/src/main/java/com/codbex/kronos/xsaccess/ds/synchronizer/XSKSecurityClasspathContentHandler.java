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
package com.codbex.kronos.xsaccess.ds.synchronizer;

import java.io.IOException;
import org.eclipse.dirigible.commons.api.content.AbstractClasspathContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codbex.kronos.xsaccess.ds.api.IXSKAccessCoreService;
import com.codbex.kronos.xsaccess.ds.api.IXSKPrivilegeCoreService;

public class XSKSecurityClasspathContentHandler extends AbstractClasspathContentHandler {

  private static final Logger logger = LoggerFactory.getLogger(XSKSecurityClasspathContentHandler.class);

  private XSKSecuritySynchronizer extensionsSynchronizer = new XSKSecuritySynchronizer();

  /*
   * (non-Javadoc)
   * @see org.eclipse.dirigible.commons.api.content.AbstractClasspathContentHandler#isValid(java.lang.String)
   */
  @Override
  protected boolean isValid(String path) {
    boolean isValid = false;

    try {
      if (path.endsWith(IXSKAccessCoreService.XSK_FILE_EXTENSION_ACCESS)) {
        isValid = true;
        extensionsSynchronizer.registerPredeliveredAccess(path);
      }
      if (path.endsWith(IXSKPrivilegeCoreService.XSK_FILE_EXTENSION_PRIVILEGE)) {
        isValid = true;
        extensionsSynchronizer.registerPredeliveredPrivileges(path);
      }
    } catch (IOException e) {
      logger.error("Predelivered Security Access or Roles artifact is not valid", e);
    }

    return isValid;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.dirigible.commons.api.content.AbstractClasspathContentHandler#getLogger()
   */
  @Override
  protected Logger getLogger() {
    return logger;
  }
}
