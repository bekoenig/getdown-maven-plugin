/*
 * Copyright 2018-2019 rockfireredmoon
 * Copyright 2026 bekoenig
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.bekoenig.getdown.maven;

import org.apache.maven.plugins.annotations.Parameter;

public class JavaConfig {

    /**
     * Java exact version. This can either be in the dotted format or a
     * long integer calculated thus <code>PATCH + 100 * (REV + 100 * (MIN + 100 * MAJ))</code>. If
     * this is set, then neither minVersion or maxVersion may be set
     */
    @Parameter(property = "java.version")
    String version;

    /**
     * Java minimum version. This can either be in the dotted format or a
     * long integer calculated thus <code>PATCH + 100 * (REV + 100 * (MIN + 100 * MAJ))</code>.
     * If this is set, exact version may not be set.
     */
    @Parameter(property = "java.minVersion")
    String minVersion;

    /**
     * Java maximum version. This can either be in the dotted format or a
     * long integer calculated thus <code>PATCH + 100 * (REV + 100 * (MIN + 100 * MAJ))</code>.
     * If this is set, exact version may not be set.
     */
    @Parameter(property = "java.maxVersion")
    String maxVersion;

    /**
     * The java system property used to determine the version.
     */
    @Parameter(property = "java.versionProp")
    String versionProp;

    /**
     * The regular expression used to extract the MAJ, MIN, REV and PATCH elements
     */
    @Parameter(property = "java.versionRegex")
    String versionRegex;

    /**
     * The java download resource paths.
     */
    @Parameter(property = "java.downloads")
    JavaDownload[] downloads;

}
