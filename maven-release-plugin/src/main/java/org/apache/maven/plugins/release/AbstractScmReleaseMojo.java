package org.apache.maven.plugins.release;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.shared.release.config.ReleaseDescriptor;

/**
 * Abstract Mojo containing SCM parameters 
 *  
 * @author Robert Scholte
 * @since 2.4
 */
public abstract class AbstractScmReleaseMojo
    extends AbstractReleaseMojo
{
    /**
     * The SCM username to use.
     */
    @Parameter( property = "username" )
    private String username;

    /**
     * The SCM password to use.
     */
    @Parameter( property = "password" )
    private String password;

    /**
     * The SCM tag to use.
     */
    @Parameter( alias = "releaseLabel", property = "tag" )
    private String tag;

    /**
     * Format to use when generating the tag name if none is specified. Property interpolation is performed on the
     * tag, but in order to ensure that the interpolation occurs during release, you must use <code>@{...}</code>
     * to reference the properties rather than <code>${...}</code>. The following properties are available:
     * <ul>
     *     <li><code>groupId</code> or <code>project.groupId</code> - The groupId of the root project.
     *     <li><code>artifactId</code> or <code>project.artifactId</code> - The artifactId of the root project.
     *     <li><code>version</code> or <code>project.version</code> - The release version of the root project.
     * </ul>
     *
     * @since 2.2.0
     */
    @Parameter( defaultValue = "@{project.artifactId}-@{project.version}", property = "tagNameFormat" )
    private String tagNameFormat;

    /**
     * The tag base directory in SVN, you must define it if you don't use the standard svn layout (trunk/tags/branches).
     * For example, <code>http://svn.apache.org/repos/asf/maven/plugins/tags</code>. The URL is an SVN URL and does not
     * include the SCM provider and protocol.
     */
    @Parameter( property = "tagBase" )
    private String tagBase;

    /**
     * The message prefix to use for all SCM changes.
     *
     * @since 2.0-beta-5
     */
    @Parameter( defaultValue = "[maven-release-plugin] ", property = "scmCommentPrefix" )
    private String scmCommentPrefix;

    @Override
    protected ReleaseDescriptor createReleaseDescriptor()
    {
        ReleaseDescriptor descriptor = super.createReleaseDescriptor();

        descriptor.setScmPassword( password );
        descriptor.setScmReleaseLabel( tag );
        descriptor.setScmTagNameFormat( tagNameFormat );
        descriptor.setScmTagBase( tagBase );
        descriptor.setScmUsername( username );
        descriptor.setScmCommentPrefix( scmCommentPrefix );

        return descriptor;
    }
}
