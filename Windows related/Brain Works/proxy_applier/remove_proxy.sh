#@author: Nishchal Siddharth Pandey
echo "Created by Nishchal Siddharth Pandey"
echo ""

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

# Removing dconf setting
echo "Removing dconf setting"
/usr/bin/gsettings set org.gnome.system.proxy mode 'none'
echo "All done!"

