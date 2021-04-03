#include <bits/stdc++.h>
using namespace std;
 
#define For(a, b, c) for(int a = b; a <= c; ++a)
#define Ford(a, b, c) for(int a = b; a >= c; --a)
#define All(a, b) for(auto &a : b)
#define Rep(a, b, c) for(int a = b; a < c; ++a)
 
#define int long long
#define ii pair<int,int>
#define fi first
#define se second
#define pb push_back
#define all(a) a.begin(),a.end()
#define reset(f, x) memset(f, x, sizeof(f))
 
#define bit(x, i) (x >> (i - 1) & 1ll)
#define onbit(x, i) (x | (1ll << (i - 1)))
#define offbit(x, i) (x & ~(1ll << (i - 1)))
#define bitone(i) __builtin_popcountll(i)
#define bitl(i) __builtin_clz(i)
#define bitr(i) __builtin_ctz(i)
 
typedef long long ll;
typedef unsigned long long ull;
 
const int N = 1e5 + 5;
int n, a[N], dd[N];
vector<int> it[N], ans;
 
main(){
	cin >> n;

	// TODO
	
}