/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.cli.profile;

import jline.console.completer.Completer;

/**
 * A Profile defines an active code generation and command execution policy. For example the "web" profile allows
 * the execution of code gen and build commands that relate to web applications
 *
 * @author Graeme Rocher
 * @author Lari Hotari
 */
public interface Profile {
    /**
     * @return The name of the profile
     */
    String getName();

    /**
     * The profile completers
     * @param context The {@link org.grails.cli.profile.ProjectContext} instance
     * @return An {@link java.lang.Iterable} of {@link jline.console.completer.Completer} instances
     */
    Iterable<Completer> getCompleters(ProjectContext context);

    /**
     * The profile {@link org.grails.cli.profile.CommandLineHandler} instances
     * @param context The {@link ProjectContext} instance
     * @return An {@link java.lang.Iterable} of {@link org.grails.cli.profile.CommandLineHandler} instances
     */
    Iterable<CommandLineHandler> getCommandLineHandlers(ProjectContext context);

    /**
     * The other {@link org.grails.cli.profile.Profile} instances that this {@link org.grails.cli.profile.Profile} extends
     * @return zero or many {@link org.grails.cli.profile.Profile} instance that this profile extends from
     */
    Iterable<Profile> getExtends();
}
