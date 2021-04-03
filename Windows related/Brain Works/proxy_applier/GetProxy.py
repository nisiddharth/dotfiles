import requests
from bs4 import BeautifulSoup

# author: Nishchal Siddharth Pandey (NSP)


def nsp_scrapes_proxy():
    url = "http://172.31.9.69/dc/proxy"
    try:
        sourceCode = requests.get(url)
        plainText = sourceCode.text

        soup = BeautifulSoup(plainText, "html.parser")

        ipdict = {}
        for i in soup.findAll("tr", {"class": "text-success"}):
            nsp = str(i.findAll("td")[4].findAll("b")[0].text)
            if(nsp.find("MB/s") > -1):
                ipdict[i.td.text] = float(nsp.replace(" MB/s", ""))*1000
            elif(nsp.find("100.14") > -1 or nsp.find("100.26") > -1):
                ipdict[i.id.text] = 0
            else:
                ipdict[i.td.text] = float(nsp.replace(" KB/s", ""))

        return ((sorted(zip(ipdict.values(), ipdict.keys()))).pop()[1])

    except:
        return "0"


print(nsp_scrapes_proxy())
