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

public class UiConfig {

    /**
     * UI Background image. Will automatically be added as a resource
     */
    @Parameter(property = "ui.backgroundImage")
    String backgroundImage;

    /**
     * UI Error Background image. Will automatically be added as a resource
     */
    @Parameter(property = "ui.errorBackground")
    String errorBackground;

    /**
     * UI progress image. Will be automatically added as a resource
     */
    @Parameter(property = "ui.progressImage")
    String progressImage;

    /**
     * UI Icons.
     */
    @Parameter(property = "ui.icons")
    String[] icons;

    /**
     * UI Mac Dock Icon. Will be automatically added as a resource
     */
    @Parameter(property = "ui.macDockIcon")
    String macDockIcon;

    /**
     * Applications name.
     */
    @Parameter(property = "ui.name", defaultValue = "${project.name}")
    String name;

    /**
     * UI Background color.
     */
    @Parameter(property = "ui.background")
    String background;

    /**
     * UI progress box bounds
     */
    @Parameter(property = "ui.progress")
    String progress;

    /**
     * UI progress bar color
     */
    @Parameter(property = "ui.progressBar")
    String progressBar;

    /**
     * UI progress text color
     */
    @Parameter(property = "ui.progressText")
    String progressText;

    /**
     * UI status box bounds
     */
    @Parameter(property = "ui.status")
    String status;

    /**
     * UI status text color
     */
    @Parameter(property = "ui.statusText")
    String statusText;

    /**
     * UI text shadow color
     */
    @Parameter(property = "ui.textShadow")
    String textShadow;

    /**
     * UI install error URL
     */
    @Parameter(property = "ui.installError")
    String installError;

    /**
     * UI hide decorations
     */
    @Parameter(property = "ui.hideDecorations")
    boolean hideDecorations;

    /**
     * UI min show seconds
     */
    @Parameter(property = "ui.minShowSeconds")
    Integer minShowSeconds;
}
