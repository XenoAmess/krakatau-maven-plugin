package com.xenoamess.maven.plugin.krakatau_maven_plugin.utils;

import java.io.File;

import com.xenoamess.krakatau_java_wrapper.util.KrakatauUtil;
import com.xenoamess.maven.plugin.krakatau_maven_plugin.exceptions.KrakatauCompileFailException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.project.MavenProject;
import org.jetbrains.annotations.NotNull;

public class KrakatauCompileUtil {

    public static void compile(
            @NotNull File sourceDirectory,
            @NotNull File outputDirectory,
            @NotNull String encoding,
            @NotNull MavenProject project
    ) {
        compileForDirectory(
                sourceDirectory,
                outputDirectory,
                encoding,
                project
        );
    }

    public static void compileForDirectory(
            @NotNull File sourceDirectory,
            @NotNull File outputDirectory,
            @NotNull String encoding,
            @NotNull MavenProject project
    ) {
        File[] files = sourceDirectory.listFiles();
        outputDirectory.mkdirs();
        if (files != null) {
            for (File nextSourceFile : files) {
                if (nextSourceFile.isDirectory()) {
                    compileForDirectory(
                            nextSourceFile,
                            new File(outputDirectory, nextSourceFile.getName()),
                            encoding,
                            project
                    );
                    new File(outputDirectory, nextSourceFile.getName());
                } else if (nextSourceFile.isFile()) {
                    String nextSourceFileName = nextSourceFile.getName();
                    if (StringUtils.endsWithAny(
                            nextSourceFileName,
                            ".j",
                            ".krakatau"
                    )
                    ) {
                        try {
                            String nextSourceFileContent = FileUtils.readFileToString(nextSourceFile, encoding);
                            byte[] nextSourceFileCompileResult = KrakatauUtil.assemble(
                                    nextSourceFileContent
                            );
                            int lastIndexOfDot = nextSourceFileName.lastIndexOf('.');
                            String nextSourceFileCompileResultName =
                                    nextSourceFileName.substring(0, lastIndexOfDot) + ".class";
                            FileUtils.writeByteArrayToFile(
                                    new File(
                                            outputDirectory,
                                            nextSourceFileCompileResultName
                                    ),
                                    nextSourceFileCompileResult
                            );
                        } catch (Exception e) {
                            throw new KrakatauCompileFailException(e);
                        }
                    } else {
                        try {
                            FileUtils.copyFile(
                                    nextSourceFile,
                                    new File(
                                            outputDirectory,
                                            nextSourceFile.getName()
                                    )
                            );
                        } catch (Exception e) {
                            throw new KrakatauCompileFailException(e);
                        }
                    }
                }
            }
        }
    }

}
