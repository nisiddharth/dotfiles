@author: Nishchal Siddharth Pandey
Please read this file thoroughly, at least once.

----------PROXY APPLIER-----------

NOTE: first create a backup of /etc/environment file before using this script (it'll help if something unexpected happens).
__

To use this script open terminal in the directory in which apply_proxy.sh, remove_proxy.sh and other files are present.

To automatically set best proxy enter the command:
	./auto_apply_proxy.sh
(If applied proxy doesn't work in your area use ./apply_proxy.sh to apply manually)

To manually set proxy enter the command:
	./apply_proxy.sh

To unset enter the command:
	./remove_proxy.sh
	
__

PS: NEVER EVER use 'sudo' to run this script.	<-follow strictly
__

If on entering ./apply_proxy.sh (or any other one) you get 'Permission denied' please enter the following command (and similarly for the other file):
	chmod +x apply_proxy.sh
__

WHAT IT DOES:

auto_apply_proxy.sh applies best proxies by sraping data from http://172.31.9.69

auto_apply_proxy.sh and apply_proxy.sh add(or applie) proxy related lines(or settings) in 1. /etc/environment, 2. snap, 3. /apt/apt.conf and 3. dconf (org.gnome.system.proxy).

You are using this shell script on your sole responsibility. I have tried and tested it on Ubuntu 18.04 and 19.04 systems ONLY. If anything wrong happens or you system bricks, don't blame it on me.

I would suggest you to first understand what is in the scripts before executing it.

(All these warnings are due to the fact that 1. /etc/environment file is being edited, which uses root access and 2. gsettings is not present in all linux environments (eg., unity))

__

Thank You!

