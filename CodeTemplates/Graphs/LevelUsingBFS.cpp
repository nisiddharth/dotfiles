#include <bits/stdc++.h>
#define lim 2000009
#define min(a,b) ((a<b)?a:b)
using namespace std;
vector<int> g[lim];
int main() {

	int a, b, i, j, k, n, m;
	cin >> n >> m;
	for(i = 0; i < n - 1; i++) {
		cin >> a >> b;
		g[a].push_back(b);
		g[b].push_back(a);
	}
	map<int, int> mp;
	for(i = 0; i < m; i++) {
		cin >> a;
		mp[a]++;
	}
	/*(i=1;i<=n;i++)
	{
	    cout << i << "\n";
	    for(j=0;j<g[i].size();j++)
	        cout << g[i][j] << " ";
	    cout << endl;
	}*/
	int ans = INT_MAX;
	for(i = 1; i <= n; i++) {
		if(ans == 1)
			break;
		if(!mp[i])
			continue;
		//cout << mp[i] << "\n";
		int dis[n + 1];
		bool vis[n + 1];
		memset(vis, false, sizeof(vis));
		memset(dis, INT_MAX, sizeof(dis));
		dis[i] = 0;
		//cout << i << "\n";
		queue<int> q;
		int gd = 0;
		q.push(i);
		while(!q.empty()) {
			a = q.front();
			q.pop();
			if(vis[a])
				continue;
			vis[a] = true;
			gd += mp[a];
			if(dis[a] > ans)
				break;

			if(gd == 2 && mp[a]) {
				ans = min(ans, dis[a]);
				break;
			}
			// for(i=1;i<=n;i++)
			//   cout << i << " " << vis[i] << "\n";
			for(j = 0; j < g[a].size(); j++) {
				if(!vis[g[a][j]]) {
					dis[g[a][j]] = dis[a] + 1;
					out << g[a][j] << " " << dis[g[a][j]] << "\n";
					q.push(g[a][j]);
				}
			}
		}
	}
	cout << ans;
	return 0;
}