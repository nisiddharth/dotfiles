#Author: Nishchal Siddharth Pandey
#Last Modified: 29/01/2019 5:31 PM

echo "Created by Nishchal Siddharth Pandey [GitHub: nisiddharth]"
echo ""

# Removing proxies from environment variables
echo "Removing proxies from environment variables"
sudo sed -i '/http_proxy/d' /etc/environment
sudo sed -i '/https_proxy/d' /etc/environment
sudo sed -i '/ftp_proxy/d' /etc/environment
sudo sed -i '/socks_proxy/d' /etc/environment
sudo sed -i '/all_proxy/d' /etc/environment
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

# Removing proxy settings from git
echo "Removing proxy settings from git"
git config --global --unset http.proxy
git config --global --unset https.proxy
echo "done."

# All done!
echo ""
echo "All done! $proxy successfully applied, if connectivity problem still persists please consider logging in/out or rebooting your system."

