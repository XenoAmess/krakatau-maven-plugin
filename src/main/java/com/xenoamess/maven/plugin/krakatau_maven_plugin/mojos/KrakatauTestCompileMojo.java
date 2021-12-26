package com.xenoamess.maven.plugin.krakatau_maven_plugin.mojos;


import java.io.File;

import com.xenoamess.maven.plugin.krakatau_maven_plugin.utils.KrakatauCompileUtil;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "krakatau-test-compile", defaultPhase = LifecyclePhase.GENERATE_TEST_SOURCES)
public class KrakatauTestCompileMojo extends AbstractMojo {

    @Parameter(defaultValue = "${basedir}/src/test/krakatau", property = "sourceDir", required = true)
    private File sourceDirectory;

    @Parameter(defaultValue = "${project.build.directory}/test-classes", property = "outputDir",
            required = true)
    private File outputDirectory;

    @Parameter(defaultValue = "${project.build.sourceEncoding}", property = "encoding")
    private String encoding;

    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException {
        project.addTestCompileSourceRoot(outputDirectory.getAbsolutePath());
        KrakatauCompileUtil.compile(
                sourceDirectory,
                outputDirectory,
                encoding,
                project
        );
    }
}
