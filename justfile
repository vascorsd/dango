# SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
#
# SPDX-License-Identifier: CC0-1.0

author := "Vasco Dias <m+git@vascorsd.com>"

# tools bins:
sbt-cmd := 'sbt --supershell=never --color=always'

_default:
    just --list

## Basic clean & compile & run cycle: ----

clean module='':
    {{ sbt-cmd }} "{{ if module != "" { module + " / " } else { "" } }} clean"

compile module='':
    {{ sbt-cmd }} "{{ if module != "" { module + " / " } else { "" } }} compile"
    
run app *args:
    {{ sbt-cmd }} "{{ app }} / run {{ args }}"

clean-force mode='':
    echo 'Removing build related artifacts...'
    rm --recursive --force --verbose build out target .target

    if [ "{{ mode }}" == "all" ]; then \
        echo 'Removing extra stuff from workspace...'; \
        rm --recursive --force --verbose .bloop .bsp .metals .idea .idea_modules .vscode; \
    fi

## Code health: -----------------------

format module='':
    {{ sbt-cmd }} "{{ if module != "" { module + " / scalafmtAll" } else { "scalafmtSbt; scalafmtAll" } }}"

format-check module='':
    {{ sbt-cmd }} "{{ if module != "" { module + " / scalafmtCheckAll" } else { "scalafmtSbtCheck; scalafmtCheckAll" } }}"

fix module='':
    {{ sbt-cmd }} "{{ if module != "" { module + " / " } else { "" } }} scalafixAll"

fix-check module='':
    {{ sbt-cmd }} "{{ if module != "" { module + " / " } else { "" } }} scalafixAll --check"

updates-check:
    {{ sbt-cmd }} "dependencyUpdates"

## Licensing stuff: ---------------------

licenses-check:
    reuse lint

licenses-add-agpl-to +files:
    reuse annotate --copyright="{{ author }}" --license="AGPL-3.0-or-later" {{ files }}

licenses-add-cc-by-sa-to +files :
    reuse annotate --copyright="{{ author }}" --license="CC-BY-SA-4.0" {{ files }}

licenses-add-cc0-to +files:
    reuse annotate --copyright="{{ author }}" --license="CC0-1.0" {{ files }}

