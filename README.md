# dotfiles
Collection of files (and dotfiles) needed by me every time I set up a new GNU/ Linux system (Debian based), also serves as backup.

[APT_Installed.txt](https://github.com/nisiddharth/dotfiles/blob/master/APT_Installed.txt) has list of apt installed packages.

[i8k_configuration.md](https://github.com/nisiddharth/dotfiles/blob/master/i8k_configuration.md) has instructions for how to fix dell laptop fan bios control in linux systems.

# More instructions

For `tilix` integration in `nautilus`:

[https://askubuntu.com/questions/1138673/is-filemanager-actions-working-with-19-04/1138682#1138682](https://askubuntu.com/questions/1138673/is-filemanager-actions-working-with-19-04/1138682#1138682)
and
[https://askubuntu.com/questions/76712/setting-nautilus-open-terminal-to-launch-terminator-rather-than-gnome-terminal](https://askubuntu.com/questions/76712/setting-nautilus-open-terminal-to-launch-terminator-rather-than-gnome-terminal)

For JDK 1.8 installation: [https://www.linuxbabe.com/ubuntu/install-oracle-java-8-openjdk-11-ubuntu-18-04-18-10](https://www.linuxbabe.com/ubuntu/install-oracle-java-8-openjdk-11-ubuntu-18-04-18-10)
<hr>

To change default terminal emulator:

```bash
sudo update-alternatives --config x-terminal-emulator
```


To change default shell:

```bash
chsh -s $(which zsh)
```

For oh-my-zsh:

```bash
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

For zsh-autosuggestions:

```bash
git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions
```

For zsh-syntax-highlighting:

```bash
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting
```

For powerlevel10k to work properly install MesloLGS NF font.

For powerlevel10k using Oh My Zsh:

```bash
git clone --depth=1 https://github.com/romkatv/powerlevel10k.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/themes/powerlevel10k
```
Set powerlevel10k/powerlevel10k as theme in .zshrc.

For powerline-go in bash:
```bash
apt install golang-go
go get -u github.com/justjanne/powerline-go
```
and then add this to .bashrc:
```bash
function _update_ps1() {
    PS1="$($GOPATH/bin/powerline-go -error $?)"
}

if [ "$TERM" != "linux" ] && [ -f "$GOPATH/bin/powerline-go" ]; then
    PROMPT_COMMAND="_update_ps1; $PROMPT_COMMAND"
fi
```

--------------------------------------------------------

To get list of all installed packages run :
```bash
sudo aptitude -F '%p' search '~i!~M'	# gives without description
sudo aptitude search '~i!~M'			# with description
sudo apt list --installed				# with description
```
<hr>
Install Teams, Burpsuite, WPS Office, Android Studio using there official packages.
<hr>

Important PPAs:
```bash
sudo add-apt-repository ppa:system76/pop	# for pop things
sudo add-apt-repository ppa:numix/ppa	# for numix things
```

--------------------------------------------------------

To overcome emoji problem in chrome (if exists):
```bash
sudo apt reinstall fonts-noto-color-emoji

mkdir -p ~/.config/fontconfig/conf.d/
touch ~/.config/fontconfig/conf.d/01-emoji.conf
gedit ~/.config/fontconfig/conf.d/01-emoji.conf
```
and paste this:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE fontconfig SYSTEM "fonts.dtd">
<fontconfig>
	<alias>
		<family>serif</family>
    	<prefer>
			<family>Noto Color Emoji</family>
		</prefer>
	</alias>
	<alias>
		<family>sans-serif</family>
		<prefer>
			<family>Noto Color Emoji</family>
		</prefer>
	</alias>
	<alias>
		<family>monospace</family>
		<prefer>
			<family>Noto Color Emoji</family>
		</prefer>
	</alias>
</fontconfig>
```

Then do:
```bash
sudo fc-cache -f -v
```

--------------------------------------------------------
