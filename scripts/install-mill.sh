#!/usr/bin/env bash


# require the version to install to be passed in the script parameter.
MINIMUM_MILL_VERSION=0.5.0
MILL_VERSION=$1

# validate input parameter
VERSION=${1//./}
VERSION=${VERSION:-0}
MINIMUM_MILL_VERSION=${MINIMUM_MILL_VERSION//./}
[ $VERSION -ge $MINIMUM_MILL_VERSION ] || { echo -e "Usage: install-mill [MILL_VERSION] \n\t where MILL_VERSION >= 0.5.0"; exit 1;}


## assume / create the following folder for binaries exist.
#
# to be usable from fish assumes the following was done previously:
#   set -U fish_user_paths $HOME/.local/bin $fish_user_paths
BIN_LOCATION="$HOME/.local/bin"

mkdir -p "$BIN_LOCATION"


# download release VERSION into the above location
curl -L "https://github.com/lihaoyi/mill/releases/download/$MILL_VERSION/$MILL_VERSION-assembly" > "$BIN_LOCATION/mill"


# at this point one would usually go and inspect the download file/script for anything malicious

# prepend the shebang to the script so it actually works
echo "#!/usr/bin/env sh" | cat - "$BIN_LOCATION/mill" | sponge "$BIN_LOCATION/mill"


# make it executable
chmod +x "$BIN_LOCATION/mill"
