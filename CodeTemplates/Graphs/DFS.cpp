#include <bits/stdc++.h>
#define ll long long int
using namespace std;

vector<ll> adj[1010];
bool visited[1010];

void dfs(ll s) {
	visited[s] = true;
	for(ll i = 0; i < adj[s].size(); i++) {
		if(!visited[adj[s][i]])
			dfs(adj[s][i]);
	}
}

void initialize() {
	for(ll i = 0; i < 1010; i++)
		visited[i] = false;
}

int main() {
	ll nodes, edges, x, y, connComp = 0;
	cin >> nodes >> edges;
	for(ll i = 0; i < edges; i++) {
		cin >> x >> y;
		adj[x].push_back(y);
		adj[y].push_back(x);
	}

	initialize();

	for(int i = 1; i <= nodes; i++)
		if(!visited[i]) {
			dfs(i);
			cout << "On: " << i << endl;
			connComp++;
		}
	cout << "Number of connected components: " << connComp << endl;
	return 0;
}
