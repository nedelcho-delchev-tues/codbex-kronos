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
package com.codbex.kronos.hdb.ds.test.repository;

import org.eclipse.dirigible.repository.api.ICollection;
import org.eclipse.dirigible.repository.api.IEntityInformation;
import org.eclipse.dirigible.repository.api.IRepository;
import org.eclipse.dirigible.repository.api.IResource;
import org.eclipse.dirigible.repository.api.RepositoryReadException;
import org.eclipse.dirigible.repository.api.RepositoryWriteException;

public class TestResource implements IResource {
    private byte[] content;
    @Override
    public byte[] getContent() throws RepositoryReadException {
        return content;
    }

    @Override
    public void setContent(byte[] bytes) throws RepositoryWriteException {
        this.content = bytes;
    }

    @Override
    public void setContent(byte[] bytes, boolean b, String s) throws RepositoryWriteException {

    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public IRepository getRepository() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPath() {
        return null;
    }

    @Override
    public ICollection getParent() {
        return null;
    }

    @Override
    public IEntityInformation getInformation() throws RepositoryReadException {
        return null;
    }

    @Override
    public void create() throws RepositoryWriteException {

    }

    @Override
    public void delete() throws RepositoryWriteException {

    }

    @Override
    public void renameTo(String s) throws RepositoryWriteException {

    }

    @Override
    public void moveTo(String s) throws RepositoryWriteException {

    }

    @Override
    public void copyTo(String s) throws RepositoryWriteException {

    }

    @Override
    public boolean exists() throws RepositoryReadException {
        return false;
    }

    @Override
    public boolean isEmpty() throws RepositoryReadException {
        return false;
    }
}
