package org.apache.maven.shared.release.transform.jdom2;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.DependencyManagement;
import org.jdom2.Element;

/**
 * JDOM2 implementation of poms DEPENDENCYMANAGEMENT element
 *
 * @author Robert Scholte
 * @since 3.0
 */
public class JDomDependencyManagement extends DependencyManagement
{
    private final Element dependencyManagement;

    /**
     * <p>Constructor for JDomDependencyManagement.</p>
     *
     * @param dependencyManagement a {@link org.jdom2.Element} object
     */
    public JDomDependencyManagement( Element dependencyManagement )
    {
        this.dependencyManagement = dependencyManagement;
    }

    @Override
    public void addDependency( Dependency dependency )
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Dependency> getDependencies()
    {
        Element dependenciesElm = dependencyManagement.getChild( "dependencies", dependencyManagement.getNamespace() );
        if ( dependenciesElm == null )
        {
            return Collections.emptyList();
        }
        else
        {
            List<Element> dependencyElms =
                dependenciesElm.getChildren( "dependency", dependencyManagement.getNamespace() );

            List<Dependency> dependencies = new ArrayList<>( dependencyElms.size() );

            for ( Element dependencyElm : dependencyElms )
            {
                dependencies.add( new JDomDependency( dependencyElm ) );
            }

            return dependencies;
        }
    }

    @Override
    public void removeDependency( Dependency dependency )
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDependencies( List<Dependency> dependencies )
    {
        throw new UnsupportedOperationException();
    }

}
