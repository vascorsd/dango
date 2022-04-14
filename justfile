# SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
#
# SPDX-License-Identifier: CC0-1.0

set shell := ["bash", "-c", "-x"]

# tools bins:

SBT := 'sbt --client'

default: clean compile

compile TARGET='':
    @if [ "{{ TARGET }}" == "" ]; then \
        {{ SBT }} compile; \
    else \
        {{ SBT }} "{{ TARGET }} / compile"; \
    fi

run APP:
    {{ SBT }} "{{ APP }} / run"

clean TARGET='':
    @if [ "{{ TARGET }}" == "" ]; then \
        {{ SBT }} clean; \
    else \
        {{ SBT }} "{{ TARGET }} / clean"; \
    fi

clean-force MODE='':
    @echo 'Removing build related artifacts...'
    @rm --recursive --force --verbose build out target .target

    @if [ "{{ MODE }}" == "all" ]; then \
        echo 'Removing extra stuff from workspace...'; \
        rm --recursive --force --verbose .bloop .idea .idea_modules .bsp .metals .vscode; \
    fi

format TARGET='':
    @if [ "{{ TARGET }}" == "" ]; then \
        {{ SBT }} "scalafmtSbt;scalafmtAll"; \
    else \
        {{ SBT }} "{{ TARGET }} / scalafmtAll"; \
    fi

format-check TARGET='':
    @if [ "{{ TARGET }}" == "" ]; then \
        {{ SBT }} "scalafmtSbtCheck;scalafmtCheckAll"; \
    else \
        {{ SBT }} "{{ TARGET }} / scalafmtCheckAll"; \
    fi

fix TARGET='':
    @if [ "{{ TARGET }}" == "" ]; then \
        {{ SBT }} "scalafixAll"; \
    else \
        {{ SBT }} "{{ TARGET }} / scalafixAll"; \
    fi

fix-check TARGET='':
    @if [ "{{ TARGET }}" == "" ]; then \
        {{ SBT }} "scalafixAll --check"; \
    else \
        {{ SBT }} "{{ TARGET }} / scalafixAll --check"; \
    fi

updates-check:
    {{ SBT }} dependencyUpdates

licenses-check:
    reuse lint

licenses-add-agpl-to FILES STYLE='':
    @if [ "{{ STYLE }}" == "" ]; then \
        reuse addheader --copyright="Vasco Dias <m+git@vascorsd.com>" --license="AGPL-3.0-or-later" {{ FILES }}; \
    else \
        reuse addheader --copyright="Vasco Dias <m+git@vascorsd.com>" --license="AGPL-3.0-or-later" --style="{{ STYLE }}" {{ FILES }}; \
    fi

licenses-add-cc-by-sa-to FILES STYLE='':
    @if [ "{{ STYLE }}" == "" ]; then \
        reuse addheader --copyright="Vasco Dias <m+git@vascorsd.com>" --license="CC-BY-SA-4.0" {{ FILES }}; \
    else \
        reuse addheader --copyright="Vasco Dias <m+git@vascorsd.com>" --license="CC-BY-SA-4.0" --style="{{ STYLE }}" {{ FILES }}; \
    fi

licenses-add-cc0-to FILES STYLE='':
    @if [ "{{ STYLE }}" == "" ]; then \
        reuse addheader --copyright="Vasco Dias <m+git@vascorsd.com>" --license="CC0-1.0" {{ FILES }}; \
    else \
        reuse addheader --copyright="Vasco Dias <m+git@vascorsd.com>" --license="CC0-1.0" --style="{{ STYLE }}" {{ FILES }}; \
    fi
