#@author: Nishchal Siddharth Pandey
echo "Created by Nishchal Siddharth Pandey"
echo ""
echo "Scraping best proxy from http://172.31.9.69"
echo "..."
proxy=`python3 GetProxy.py`
echo "..."
if [ $proxy == "0" ]
then
	echo "Some error occurred. Please apply proxy manually or try again later."
else
	echo "Setting up $proxy, if this doesn't work in your area use ./apply_proxy.sh to apply manually"

	# Removing proxies from environment variables
	echo "Removing proxies from environment variables"
	sudo sed -i '/http_proxy/d' /etc/environment
	sudo sed -i '/https_proxy/d' /etc/environment
	sudo sed -i '/ftp_proxy/d' /etc/environment
	sudo sed -i '/socks_proxy/d' /etc/environment
	# these are to remove the trailing newlines
	sudo perl -i -pe 'chomp if eof' /etc/environment
	sudo perl -i -pe 'chomp if eof' /etc/environment
	
	echo "done."
	
	# Removing proxies from apt package manager
	echo "Removing proxies from apt package manager"
	sudo sed -i '/Acquire::http::proxy/d' /etc/apt/apt.conf
	sudo sed -i '/Acquire::https::proxy/d' /etc/apt/apt.conf
	sudo sed -i '/Acquire::ftp::proxy/d' /etc/apt/apt.conf
	sudo sed -i '/Acquire::socks::proxy/d' /etc/apt/apt.conf
	# these are to remove the trailing newlines
	sudo perl -i -pe 'chomp if eof' /etc/apt/apt.conf
	sudo perl -i -pe 'chomp if eof' /etc/apt/apt.conf
	
	echo "done."
	
	# Removing proxies from snap package manager
	echo "Removing proxies from snap package manager"
	sudo snap set system proxy.http=
	sudo snap set system proxy.https=
	echo "done."

	# Adding proxies to environment variables
	echo "Adding proxies to environment variables"
	# these are to remove the trailing newlines
	sudo perl -i -pe 'chomp if eof' /etc/environment
	sudo perl -i -pe 'chomp if eof' /etc/environment
	# adding
	sudo sh -c "echo '\nhttp_proxy=http://edcguest:edcguest@$proxy:3128/\nhttps_proxy=https://edcguest:edcguest@$proxy:3128/\nftp_proxy=ftp://edcguest:edcguest@$proxy:3128/\nsocks_proxy=socks://edcguest:edcguest@$proxy:3128/\n' >> /etc/environment"
	echo "done."
	
	# Adding proxies to apt package manager
	echo "Adding proxies to apt package manager"
	# these are to remove the trailing newlines
	sudo perl -i -pe 'chomp if eof' /etc/apt/apt.conf
	sudo perl -i -pe 'chomp if eof' /etc/apt/apt.conf
	# adding
	sudo sh -c "echo '\nAcquire::http::proxy \"http://edcguest:edcguest@$proxy:3128/\";\nAcquire::https::proxy \"https://edcguest:edcguest@$proxy:3128/\";\nAcquire::ftp::proxy \"ftp://edcguest:edcguest@$proxy:3128/\";\nAcquire::socks::proxy \"socks://edcguest:edcguest@$proxy:3128/\";\n' >> /etc/apt/apt.conf"
	echo "done."
	
	# Applying proxies to snap package manager
	echo "Applying proxies to snap package manager"
	sudo snap set system proxy.http=http://edcguest:edcguest@$proxy:3128/
	sudo snap set system proxy.https=http://edcguest:edcguest@$proxy:3128/
	echo "done."
	
	# Applying proxy settings in dconf
	echo "Applying proxy settings in dconf"
	/usr/bin/gsettings set org.gnome.system.proxy mode 'manual' 
	/usr/bin/gsettings set org.gnome.system.proxy.http host $proxy
	/usr/bin/gsettings set org.gnome.system.proxy.http port 3128
	/usr/bin/gsettings set org.gnome.system.proxy.https host $proxy
	/usr/bin/gsettings set org.gnome.system.proxy.https port 3128
	/usr/bin/gsettings set org.gnome.system.proxy.ftp host $proxy
	/usr/bin/gsettings set org.gnome.system.proxy.ftp port 3128
	/usr/bin/gsettings set org.gnome.system.proxy.socks host $proxy
	/usr/bin/gsettings set org.gnome.system.proxy.socks port 3128
	echo "done."
	
	# All done!
	echo ""
	echo "All done! $proxy successfully applied."
fi
