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

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.descriptor.PluginDescriptor;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;

/**
 * Make deployable Java apps.
 */
@Mojo(name = "applet")
public class MakeApplet extends AbstractGetdownMojo {

    /**
     * The URL from which the client is downloaded.
     */
    @Parameter(required = true)
    private String appbase;

    /**
     * The directory in which files will be stored prior to processing.
     */
    @Parameter(defaultValue = "${project.build.directory}/getdown-applet", required = true)
    private File workDirectory;

    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    @Parameter(defaultValue = "${plugin}", readonly = true)
    private PluginDescriptor plugin;

    public void execute() throws MojoExecutionException {
        getLog().debug("using work directory " + workDirectory);
        Util.makeDirectoryIfNecessary(workDirectory);
        try {
            initSign();
            copyUIResources();
            copyGetdownClient();
            sign();
        } catch (MojoExecutionException e) {
            throw e;
        } catch (Exception e) {
            throw new MojoExecutionException("Failure to run the plugin: ", e);
        }
    }

    protected File getWorkDirectory() {
        return workDirectory;
    }

    protected void copyGetdownClient() throws MojoExecutionException {
        getLog().info("Copying client jar");
        Artifact getdown = plugin.getArtifactMap().get("io.github.bekoenig.getdown:getdown-launcher");
        Util.copyFile(getdown.getFile(), getClientJarFile());
    }

    private File getClientJarFile() {
        return new File(workDirectory, "getdown.jar");
    }

    protected void sign() throws MojoExecutionException {
        if (sign != null) {

            File unsignedJar = getClientJarFile();
            File signedJar = new File(workDirectory, unsignedJar.getName() + ".signed");
            Util.deleteFile(signedJar);
            verboseLog("Sign " + unsignedJar.getName());
            signTool.sign(sign, unsignedJar, signedJar);
            getLog().debug("lastModified signedJar:" + signedJar.lastModified() + " unprocessed signed Jar:"
                    + unsignedJar.lastModified());

            if (sign.isVerify()) {
                verboseLog("Verify signature of " + signedJar.getName());
                signTool.verify(sign, signedJar, verbose);
            }
            Util.copyFile(signedJar, unsignedJar);
            Util.deleteFile(signedJar);
        }
    }
}
