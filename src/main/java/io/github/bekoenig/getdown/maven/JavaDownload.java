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

public class JavaDownload implements OsSpecific {

    /**
     * One of 'linux', 'windows' or 'mac os x'
     */
    @Parameter(property = "download.os")
    String os;

    /**
     * One of 'amd64', 'x86' or 'i386' etc.
     */
    @Parameter(property = "download.arch")
    String arch;

    /**
     * Resource path. May be a full URL, relative to the root of the appbase, or relative to
     * the appbase
     */
    @Parameter(property = "download.path")
    String path;

    public String getOs() {
        return os;
    }

    public String getArch() {
        return arch;
    }

    public String getPath() {
        return path;
    }
}
