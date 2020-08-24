@author: Nishchal Siddharth Pandey
Please read this file thoroughly, at least once.

----------PROXY APPLIER-----------

NOTE: first create a backup of /etc/environment file before using this script (it'll help if something unexpected happens).
__

To use this script open terminal in the directory in which apply_proxy.sh, remove_proxy.sh are present.

To set proxy enter the command:
	./apply_proxy.sh
and enter the proxy host name you want to use.

To unset enter the command:
	./remove_proxy.sh
	
__

NOTE: NEVER EVER use 'sudo' to run this script.	<-follow strictly
__

If on entering ./apply_proxy.sh (or any other one) you get 'Permission denied' please enter the following command (and similarly for the other file):
	chmod +x apply_proxy.sh
__

WHAT IT DOES:

apply_proxy.sh adds(or applies) proxy related lines(or settings) in 1. /etc/environment, 2. snap, 3. /apt/apt.conf, 3. dconf (org.gnome.system.proxy) and 4. git.

You are using this shell script on your sole responsibility. I have tried and tested it on Ubuntu 18.04, 18.10, 19.04, 19.10, MX Linux XFCE 18, 19, Pop! OS 19.10 and Manjaro KDE 18.1.5 systems ONLY. If anything wrong happens or you system bricks, don't blame it on me.

I would suggest you to first understand what is in the scripts before executing them.

(All these warnings are due to the fact that /etc/environment file is being edited, which uses root access)

__

Thank You!

