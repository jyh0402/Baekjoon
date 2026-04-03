#include <iostream>
#include <cstring>
#include <queue>
#include <stack>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

long long Comb(int k);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int T;

	cin >> T;

	for (int t = 0; t < T; t++) {
		int n;
		cin >> n;
		long long ans = Comb(n);
		cout << ans << "\n";
	}
}

long long Comb(int k) {
	long long ans = 1;
	for (int i = k + 1; i <= k + 9; i++) ans *= i;
	for (int i = 2; i <= 9; i++) ans /= i;
	return ans;
}