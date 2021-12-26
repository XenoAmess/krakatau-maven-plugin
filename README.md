# krakatau-maven-plugin

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.xenoamess/krakatau-maven-plugin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.xenoamess/krakatau-maven-plugin)

krakatau-maven-plugin, A plugin for krakatau in maven project.

## Goal:
Use [krakatau_java_wrapper](https://github.com/XenoAmess/Krakatau_java_wrapper) to build class from krakatau.

## Usage:

1. include it in your `<build>`

```xml
<build>
     <plugins>
         <plugin>
             <groupId>com.xenoamess</groupId>
             <artifactId>krakatau-maven-plugin</artifactId>
             <version>0.0.1-SNAPSHOT</version>
             <executions>
                 <execution>
                     <goals>
                         <goal>krakatau-compile</goal>
                         <goal>krakatau-test-compile</goal>
                     </goals>
                 </execution>
             </executions>
         </plugin>
     </plugins>
</build>
```

2. write your krakatau codes template.
put krakatau sources template code into `<sourceDirectory>`

3. mvn compile and get the result.

## Params:

All params and their default value are listed here.
```
    @Parameter(defaultValue = "${basedir}/src/main/krakatau", property = "sourceDir", required = true)
    private File sourceDirectory;

    @Parameter(defaultValue = "${project.build.directory}/classes", property = "outputDir",
            required = true)
    private File outputDirectory;

    @Parameter(defaultValue = "${project.build.sourceEncoding}", property = "encoding")
    private String encoding;

    @Parameter(defaultValue = "${project}")
    private MavenProject project;
```

**sourceDirectory** means a directory which contains your krakatau sources.

**outputDirectory** means a directory to put compiled results.

**encoding** means encoding of your source files.

**project** means your project. I don't think it shall be changed but if you insisted, then you are free to do what you want.
