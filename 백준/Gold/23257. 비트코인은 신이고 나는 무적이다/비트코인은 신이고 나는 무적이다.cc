#include <iostream>
#include <cstring>
#include <queue>
#include <stack>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

bool dp[100][1024];

struct Node {
	int cnt;
	int result;
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int n, m;

	cin >> n >> m;

	vector<int> num(n);

	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		num[i] = abs(x);
		dp[1][num[i]] = true;
	}
	
	for (int i = 1; i < m; i++) {
		for (int j = 0; j < 1024; j++) {
			if (!dp[i][j]) continue;
			for (int k = 0; k < n; k++) {
				dp[i + 1][j ^ num[k]] = true;
			}
		}
	}

	for (int i = 1023; i >= 0; i--) {
		if (dp[m][i]) {
			cout << i << '\n';
			return 0;
		}
	}
}