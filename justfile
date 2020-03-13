set shell := ["bash", "-c"]

# tools bins:
MILL      := 'mill'
#SBT       := 'sbt'
#SEED      := 'seed-jvm'
#BLOOP     := 'bloop'
COURSIER  := 'coursier'
SCALAFMT  := 'scalafmt-jvm'
SCALAFIX  := 'scalafix-jvm'

# tools version required:
MILL_WANT_VERSION := '0.6.1'

clean-compile: prepare clean reload build

prepare:
    ./bins/check-installed-mill.sh {{MILL_WANT_VERSION}}

reload:
    # BSP aka intellij project target
    {{MILL}} -i mill.contrib.BSP/install

# supply a specific TARGET to not build everything
build TARGET='all':
    @if [ {{TARGET}} == all ]; then \
        echo 'Building all targets...'; \
        {{MILL}} all _.compile; \
    else \
        echo 'Building only specified target...'; \
        {{MILL}} {{TARGET}}.compile; \
    fi

# supply MODE=all really clean the workspace as if fresh git clone
clean MODE='':
    @echo 'Removing build related artifacts...'
    @rm --recursive --force --verbose build .bloop .idea out

    @if [ {{MODE}} == all ]; then \
        echo 'Removing extra stuff from workspace...'; \
        rm --recursive --force --verbose .scalafix-rules/*; \
    fi

run APP: build
    {{MILL}} {{APP}}.run

check-format:
    {{SCALAFMT}} --git true --list --check --stdout app core

check-lint:
    #!/usr/bin/env bash
    TOOL_CLASSPATH="$(
        {{COURSIER}} fetch --cache .scalafix-rules \
            com.github.vovapolu:scaluzzi_2.12:0.1.4.1 \
            -p
    )"

    {{SCALAFIX}} --tool-classpath="$TOOL_CLASSPATH" --auto-classpath --check --stdout app core


