/*
This type of BFS is used to find the shortest distance between two nodes in a graph provided that the edges in the graph have the weights 0 or 1. If you apply the BFS explained earlier in this article, you will get an incorrect result for the optimal distance between 2 nodes.

In this approach, a boolean array is not used to mark the node because the condition of the optimal distance will be checked when you visit each node. A double-ended queue is used to store the node. In 0-1 BFS, if the weight of the edge = 0, then the node is pushed to the front of the dequeue. If the weight of the edge = 1, then the node is pushed to the back of the dequeue.
*/

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

vector<pair<ll, ll>> adj[1010];
ll distanc[1010];

void bfs(int s) {
	distanc[s] = 0;
	deque<ll> q;
	q.push_back(s);
	while(!q.empty()) {
		ll p = q.front();
		q.pop_front();
		for(ll i = 0; i < adj[p].size(); i++) {
			/* if distance of neighbour of v from start node is greater than sum of distance of v from start node and edge weight between v and its neighbour (distance between v and its neighbour of v) ,then change it */
			if(distanc[adj[p][i].first] > distanc[p] + adj[p][i].second) {
				distanc[adj[p][i].first] = distanc[p] + adj[p][i].second;
				/*if edge weight between v and its neighbour is 0 then push it to front of
				        double ended queue else push it to back*/
				if(adj[p][i].second == 0) {
					q.push_front(adj[p][i].first);
				} else {
					q.push_back(adj[p][i].first);
				}
			}
		}
	}
}

void initialize() {
	for(int i = 0; i < 1010; i++) {
		distanc[i] = LLONG_MAX;
	}
}

int main() {
	ll nodes, edges, x, y, w, connComp = 0;;
	cin >> nodes >> edges;
	for(ll i = 0; i < edges; i++) {
		cin >> x >> y >> w;
		adj[x].push_back(make_pair(y, w));
		adj[y].push_back(make_pair(x, w));
	}

	initialize();

	bfs(1);

	cout << "Shortest distance of:\n";
	for(int i = 1; i <= nodes; i++) {
		cout << distanc[i] << endl;
	}
	return 0;
}
/* test:
9
13
1 2 0
1 8 1
2 8 1
2 3 1
3 4 0
3 6 0
3 9 1
4 5 1
4 6 1
5 6 1
6 7 1
7 8 1
8 9 1

Out:
Shortest distance of:
0
0
1
1
2
1
2
1
2

*/