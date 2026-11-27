# Template for Micronaut Applications built with JeKa

This template provides a ready-to-run *hello-world* REST application, complete with tests and *ErrorProne/NullAway* processor configuration.

The project adopts a simpler layout style than the traditional *Maven* one. 
If you prefer the traditional style, remove the following lines from `jeka.properties`:
```properties
@project.layout.style=SIMPLE
@project.layout.mixSourcesAndResources=true
```

Because this setup relies only on basic JeKa features, [Micronaut AOT](https://micronaut-projects.github.io/micronaut-aot/latest/guide/) is not supported.

## Prerequisites

- Nothing to install to build and run: the `./jeka` script downloads JeKa and the JDK (and GraalVM for native builds).
  The commands below use `jeka`: use `./jeka` if JeKa is not installed.
- Docker, for the Docker images.

Once running, the application answers at http://localhost:8080/hello.

## How it works

- [jeka.project.deps](jeka.project.deps): the Micronaut platform BOM, the dependencies, and the annotation processors
  (`[processor]`), including ErrorProne and NullAway.
- [jeka.properties](jeka.properties): JeKa and Java versions, fat jar and main class, layout, compiler options for
  ErrorProne/NullAway, and the native options.

## JeKa commands

Create jar:
```shell
jeka project: pack
```

Clean and create a jar:
```shell
jeka project: pack --clean
```

Test, then create jar:
```shell
jeka project: test pack 
```

Run the JAR (build it first if it doesn’t exist). Pass JVM properties as program arguments using `-Dxxx=xx`.
```shell
jeka -p <PROGRAM ARGS...>
```

Clean the output dir, create a jar and run it.
```shell
jeka -c -p <PROGRAM ARGS...>
```

Full build: tests and jar, then the quality check and end-to-end test steps (none is registered in this template).
```shell
jeka project: build
```

Creates a local native executable:
```shell
jeka native: compile
```

Synchronize IntelliJ:
```shell
jeka intellij: sync
```

### Docker

Create image:
```shell
jeka docker: build
```

Show info about the Docker image:
```shell
jeka docker: info
```

Create a native image:
```shell
jeka docker: buildNative
```

Show info about native image:
```shell
jeka docker: infoNative
```

Create a minimalist Docker image:
```shell
jeka docker: buildNative nativeBaseImage=gcr.io/distroless/static-debian12:nonroot native: staticLink=MUSL
```

## Links

- [Build projects](https://jeka-dev.github.io/jeka/tutorials/build-projects/)
- [native KBean](https://jeka-dev.github.io/jeka/reference/kbeans-native/) and
  [docker KBean](https://jeka-dev.github.io/jeka/reference/kbeans-docker/)
