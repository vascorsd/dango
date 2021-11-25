set shell := ["bash", "-c", "-x"]

# tools bins:
SBT := 'sbt --client'


clean-compile: clean build

build TARGET='':
    @if [ "{{TARGET}}" == "" ]; then \
        {{SBT}} compile; \
    else \
        {{SBT}} "{{TARGET}} / compile"; \
    fi

run APP:
    {{SBT}} "{{APP}} / run"

clean TARGET='':
    @if [ "{{TARGET}}" == "" ]; then \
        {{SBT}} clean; \
    else \
        {{SBT}} "{{TARGET}} / clean"; \
    fi

force-clean MODE='':
    @echo 'Removing build related artifacts...'
    @rm --recursive --force --verbose build out target .target

    @if [ "{{MODE}}" == "all" ]; then \
        echo 'Removing extra stuff from workspace...'; \
        rm --recursive --force --verbose .bloop .idea .idea_modules .bsp .metals .vscode; \
    fi

format TARGET='':
    @if [ "{{TARGET}}" == "" ]; then \
        {{SBT}} scalafmt; \
    else \
        {{SBT}} "{{TARGET}} / scalafmt"; \
    fi

fix TARGET='':
    @if [ "{{TARGET}}" == "" ]; then \
        {{SBT}} "scalafix"; \
    else \
        {{SBT}} "{{TARGET}} / scalafix"; \
    fi

check-format TARGET='':
    @if [ "{{TARGET}}" == "" ]; then \
        {{SBT}} "scalafmtSbtCheck;scalafmtCheckAll"; \
    else \
        {{SBT}} "{{TARGET}} / scalafmtSbt;scalafmtCheckAll"; \
    fi

check-fix TARGET='':
    @if [ "{{TARGET}}" == "" ]; then \
        {{SBT}} "scalafix --check"; \
    else \
        {{SBT}} "{{TARGET}} / scalafix --check"; \
    fi

check-updates:
    {{SBT}} dependencyUpdates
