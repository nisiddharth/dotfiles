# ~/.profile: executed by the command interpreter for login shells.
# This file is not read by bash(1), if ~/.bash_profile or ~/.bash_login
# exists.
# see /usr/share/doc/bash/examples/startup-files for examples.
# the files are located in the bash-doc package.

# the default umask is set in /etc/profile; for setting the umask
# for ssh logins, install and configure the libpam-umask package.
#umask 022

# if running bash
if [ -n "$BASH_VERSION" ]; then
    # include .bashrc if it exists
    if [ -f "$HOME/.bashrc" ]; then
	. "$HOME/.bashrc"
    fi
fi

# set PATH so it includes user's private bin if it exists
if [ -d "$HOME/bin" ] ; then
    PATH="$HOME/bin:$PATH"
fi

# set PATH so it includes user's private bin if it exists
if [ -d "$HOME/.local/bin" ] ; then
    PATH="$HOME/.local/bin:$PATH"
fi

# set PATH so it includes flutter's bin if it exists
# if [ -d "$HOME/flutter/bin" ] ; then
#     PATH="$PATH:$HOME/flutter/bin"
# fi

# export C_INCLUDE_PATH=/usr/include/tirpc/

export ANDROID_HOME="$HOME/Android/Sdk"
export JAVA_HOME="/opt/android-studio/jbr"
PATH="$PATH:$JAVA_HOME/bin:$ANDROID_HOME/emulator:$ANDROID_HOME/platform-tools"
export HISTCONTROL=ignoreboth
