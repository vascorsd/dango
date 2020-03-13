#!/usr/bin/env bash

MILL=mill
MILL_WANT_VERSION=$1

echo "Checking if '$MILL' is installed..."

MILL_INSTALLED=`which $MILL 2>/dev/null`

if [ -z "$MILL_INSTALLED" ] ; then
    echo "Not found, downloading..."

    ./bins/install-mill.sh $MILL_WANT_VERSION

    echo "Checking if in PATH..."

    MILL_INSTALLED_VERSION=`$MILL version 2>/dev/null`

    if [ -z "MILL_INSTALLED_VERSION" ] ; then
        echo "Downloaded '$MILL' binary is not in PATH. Add to the PATH '$HOME/.local/bin'."
    else
        echo "Installed '$MILL' version $MILL_INSTALLED_VERSION."
    fi
else
    MILL_INSTALLED_VERSION=`$MILL version 2>/dev/null`

    if [ -z "MILL_INSTALLED_VERSION" ] ; then
        echo "Downloaded '$MILL' binary is not in PATH. Add to the PATH '$HOME/.local/bin'"
    else
        echo "Installed '$MILL' version $MILL_INSTALLED_VERSION."
        echo "Declared '$MILL' version as needed is $MILL_WANT_VERSION. If different, you are on your own :)"
    fi
fi
