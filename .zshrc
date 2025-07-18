# Path to your oh-my-zsh installation.
export ZSH="$HOME/.oh-my-zsh"

ZSH_THEME="robbyrussell"

# Uncomment the following line to enable command auto-correction.
# ENABLE_CORRECTION="true"

# History control
export HISTCONTROL=ignoreboth

# Which plugins would you like to load?
# Standard plugins can be found in $ZSH/plugins/
# Custom plugins may be added to $ZSH_CUSTOM/plugins/
# Example format: plugins=(rails git textmate ruby lighthouse)
# Add wisely, as too many plugins slow down shell startup.
plugins=(git zsh-autosuggestions zsh-syntax-highlighting extract)

source $ZSH/oh-my-zsh.sh

# User configuration

# export MANPATH="/usr/local/man:$MANPATH"

# You may need to manually set your language environment
export LC_ALL=en_US.UTF-8
export LANG=en_US.UTF-8

# Preferred editor for local and remote sessions
if [[ -n $SSH_CONNECTION ]]; then
  export EDITOR='vim'
else
  export EDITOR='nano'
fi

alias cmatrix="unimatrix -s 96"
alias socks="ssh -i ~/.ssh/proxy-cert.pub -C -D 1080 nishchal.siddharth@prd-deploy100.phonepe.nm5"
alias list_emulators="~/Library/Android/sdk/emulator/emulator -list-avds"
alias emulator="~/Library/Android/sdk/emulator/emulator"
alias ppcli='java -jar /opt/homebrew/opt/phonepe_toolkit/bin/phonepe-toolkit-cli.jar'

export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"  # This loads nvm
[ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion"  # This loads nvm bash_completion
