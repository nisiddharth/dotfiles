Powerlevel10k is a theme for Zsh. It emphasizes [speed](#uncompromising-performance),
[flexibility](#extremely-customizable) and [out-of-the-box experience](#configuration-wizard).

## Getting started

1. [Install the recommended font](#meslo-nerd-font-patched-for-powerlevel10k). *Optional but highly
   recommended.*
1. [Install Powerlevel10k](#installation) itself.
1. Restart Zsh with `exec zsh`.
1. Type `p10k configure` if the configuration wizard doesn't start automatically.

## Installation

- [Manual](#manual) 👈 **choose this if confused or uncertain**
- [Oh My Zsh](#oh-my-zsh)
- [Prezto](#prezto)
- [Zim](#zim)
- [Antibody](#antibody)
- [Antidote](#antidote)
- [Antigen](#antigen)
- [Zplug](#zplug)
- [Zgen](#zgen)
- [Zplugin](#zplugin)
- [Zinit](#zinit)
- [Zi](#zi)
- [Homebrew](#homebrew)

### Manual

```zsh
git clone --depth=1 https://github.com/romkatv/powerlevel10k.git ~/powerlevel10k
echo 'source ~/powerlevel10k/powerlevel10k.zsh-theme' >>~/.zshrc
```


This is the simplest kind of installation and it works even if you are using a plugin manager. Just
make sure to disable the current theme in your plugin manager. See.

### Oh My Zsh

1. Clone the repository:
    ```zsh
    git clone --depth=1 https://github.com/romkatv/powerlevel10k.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/themes/powerlevel10k
    ```
    Users in China can use the official mirror on gitee.com for faster download.<br>
    中国大陆用户可以使用 gitee.com 上的官方镜像加速下载.

    ```zsh
    git clone --depth=1 https://gitee.com/romkatv/powerlevel10k.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/themes/powerlevel10k
    ```
2. Set `ZSH_THEME="powerlevel10k/powerlevel10k"` in `~/.zshrc`.

### Prezto

Add `zstyle :prezto:module:prompt theme powerlevel10k` to `~/.zpreztorc`.

### Zim

Add `zmodule romkatv/powerlevel10k --use degit` to `~/.zimrc` and run `zimfw install`.

### Antibody

Add `antibody bundle romkatv/powerlevel10k` to `~/.zshrc`.

### Antidote

Add `romkatv/powerlevel10k` to `~/.zsh_plugins.txt`.

### Antigen

Add `antigen theme romkatv/powerlevel10k` to `~/.zshrc`. Make sure you have `antigen apply`
somewhere after it.

### Zplug

Add `zplug romkatv/powerlevel10k, as:theme, depth:1` to `~/.zshrc`.

### Zgen

Add `zgen load romkatv/powerlevel10k powerlevel10k` to `~/.zshrc`.

### Zplugin

Add `zplugin ice depth=1; zplugin light romkatv/powerlevel10k` to `~/.zshrc`.

The use of `depth=1` ice is optional. Other types of ice are neither recommended nor officially
supported by Powerlevel10k.

### Zinit

Add `zinit ice depth=1; zinit light romkatv/powerlevel10k` to `~/.zshrc`.

The use of `depth=1` ice is optional. Other types of ice are neither recommended nor officially
supported by Powerlevel10k.

### Zi

Add `zi ice depth=1; zi light romkatv/powerlevel10k` to `~/.zshrc`.

The use of `depth=1` ice is optional. Other types of ice are neither recommended nor officially
supported by Powerlevel10k.

### Homebrew

```zsh
brew install romkatv/powerlevel10k/powerlevel10k
echo "source $(brew --prefix)/opt/powerlevel10k/powerlevel10k.zsh-theme" >>~/.zshrc
```
