package com.xenoamess.maven.plugin.krakatau_maven_plugin.mojos;


import java.io.File;

import com.xenoamess.maven.plugin.krakatau_maven_plugin.utils.KrakatauCompileUtil;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "krakatau-compile", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class KrakatauCompileMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}/src/main/krakatau", property = "sourceDir", required = true)
    private File sourceDirectory;

    @Parameter(defaultValue = "${project.build.directory}/classes", property = "outputDir",
            required = true)
    private File outputDirectory;

    @Parameter(defaultValue = "${project.build.sourceEncoding}", property = "encoding")
    private String encoding;

    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException {
        project.addCompileSourceRoot(outputDirectory.getAbsolutePath());
        KrakatauCompileUtil.compile(
                sourceDirectory,
                outputDirectory,
                encoding,
                project
        );
    }
}
