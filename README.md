# Template for Micronaut Applications built with JeKa

This template provides a ready-to-run *hello-world* REST application, complete with tests and *ErrorProne/NullAway* processor configuration.

Because this setup relies only on basic Jeka features, [Micronaut AOT](https://micronaut-projects.github.io/micronaut-aot/latest/guide/) is not supported.

## JeKa commands

Create jar:
```shell
jeka project: pack
```

Clean, and create jar:
```shell
jeka project: pack --clean
```

Test, then create jar:
```shell
jeka project: test pack 
```

Run Jar (create it if missing). Pass jvm props using `-Dxxx=xx` as program argument.
```shell
jeka -p <PROGRAM ARGS...>
```

Full build (including static analysis + end-to-end tests)
```shell
jeka project: build
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

Show info about image:
```shell
jeka docker: info
```

Create native image:
```shell
jeka docker: buildNative
```

Show info about native image:
```shell
jeka docker: infoNative
```

Create minimalist Docker image:
```shell
jeka docker: buildNative nativeBaseImage=gcr.io/distroless/static-debian12:nonroot native: staticLink=MUSL
```
