#include <iostream>
#include <cstring>
#include <queue>
#include <stack>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

void BT(int n, int tot);
int N, K;
int cnt;

vector<int> heavy;
vector<bool> visited;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> N >> K;

	for (int i = 0; i < N; i++) {
		int weight;
		cin >> weight;
		heavy.push_back(weight);
		visited.push_back(false);
	}

	BT(0, 500);

	cout << cnt;
}
void BT(int n, int tot) {
	if (n == N) {
		cnt++;
		return;
	}

	for (int i = 0; i < N; i++) {
		if (visited[i]) continue;
		if (tot + heavy[i] - K < 500) continue;
		visited[i] = true;
		BT(n + 1, tot + heavy[i] - K);
		visited[i] = false;
	}
}