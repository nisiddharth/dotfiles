--------------------------------------------------

For kitty integration in nautilus: https://askubuntu.com/questions/1138673/is-filemanager-actions-working-with-19-04/1138682#1138682

For jdk 8 installation: https://www.linuxbabe.com/ubuntu/install-oracle-java-8-openjdk-11-ubuntu-18-04-18-10

To change default terminal emulator: sudo update-alternatives --config x-terminal-emulator

To change default sh: chsh -s $(which zsh)

For oh-my-zsh:
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"

For zsh-autosuggestions:
git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions

For zsh-syntax-highlighting:
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting

----------------------------------------------------

To overcome emoji problem in chrome:

sudo apt reinstall fonts-noto-color-emoji

mkdir -p ~/.config/fontconfig/conf.d/
touch ~/.config/fontconfig/conf.d/01-emoji.conf
gedit ~/.config/fontconfig/conf.d/01-emoji.conf

and paste this:

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


Then do: fc-cache -f -v

---------------------------------------------------

TLP is an excellent program for increasing battery life on all of our laptops. TLP is a pure command line tool with automated background tasks and does not contain a GUI. Its default settings are excellent for most situations and require little tuning. TLP will take care of most of the settings that Powertop autotuning would, and with less trial and error.

To install TLP, run this command:

sudo apt install tlp tlp-rdw

and forget about it :)

----------------------------------------------------

If Ethernet is never used, or is only used irregularly, then it can be disabled to save power. Please run this command:

ifconfig
And note the name of the interface. It will probably be enp4s0f2 or similar (NSP: mine was enp2s0). Disable it by running this command:

sudo gedit /etc/network/interfaces
And add this line to the file:

iface enp4s0f2 inet manual

Then, if Ethernet needs used, this command can be run to enable it for the session:

sudo ifconfig enp4s0f2 up

---------------------------------------------------
