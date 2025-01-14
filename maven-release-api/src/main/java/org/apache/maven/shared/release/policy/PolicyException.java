package org.apache.maven.shared.release.policy;

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

/**
 * <p>PolicyException class.</p>
 *
 * @since 2.5.1 (MRELEASE-431)
 */
public class PolicyException
    extends Exception
{

    /**
     * <p>Constructor for PolicyException.</p>
     *
     * @param message a {@link java.lang.String} object
     */
    public PolicyException( String message )
    {
        super( message );
    }
    
    /**
     * <p>Constructor for PolicyException.</p>
     *
     * @param message a {@link java.lang.String} object
     * @param exception a {@link java.lang.Exception} object
     */
    public PolicyException( String message, Exception exception )
    {
        super( message, exception );
    }
}
