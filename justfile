set shell := ["bash", "-c", "-x"]

# tools bins:
SBT := 'sbt --client'


clean-compile: clean compile

compile TARGET='':
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

clean-force MODE='':
    @echo 'Removing build related artifacts...'
    @rm --recursive --force --verbose build out target .target

    @if [ "{{MODE}}" == "all" ]; then \
        echo 'Removing extra stuff from workspace...'; \
        rm --recursive --force --verbose .bloop .idea .idea_modules .bsp .metals .vscode; \
    fi

format TARGET='':
    @if [ "{{TARGET}}" == "" ]; then \
        {{SBT}} "scalafmtSbt;scalafmtAll"; \
    else \
        {{SBT}} "{{TARGET}} / scalafmtAll"; \
    fi

format-check TARGET='':
    @if [ "{{TARGET}}" == "" ]; then \
        {{SBT}} "scalafmtSbtCheck;scalafmtCheckAll"; \
    else \
        {{SBT}} "{{TARGET}} / scalafmtCheckAll"; \
    fi

fix TARGET='':
    @if [ "{{TARGET}}" == "" ]; then \
        {{SBT}} "scalafixAll"; \
    else \
        {{SBT}} "{{TARGET}} / scalafixAll"; \
    fi

fix-check TARGET='':
    @if [ "{{TARGET}}" == "" ]; then \
        {{SBT}} "scalafixAll --check"; \
    else \
        {{SBT}} "{{TARGET}} / scalafixAll --check"; \
    fi

updates-check:
    {{SBT}} dependencyUpdates
