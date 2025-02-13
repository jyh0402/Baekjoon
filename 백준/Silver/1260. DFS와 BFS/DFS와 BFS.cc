#include <iostream>
#include <string>
#include <unordered_map>
#include <algorithm>
#include <queue>

using namespace std;

int n, m, v;
int map[1001][1001];
bool visit[1001];
queue<int> q;

void reset()
{
	for (int i = 1; i <= n; i++)
	{
		visit[i] = 0;
	}
}

void DFS(int v)
{
	visit[v] = true;
	cout << v << " ";

	for (int i = 1; i <= n; i++)
	{
		if (map[v][i] == 1 && visit[i] == 0)
		{
			DFS(i);
		}
	}
}

void BFS(int v)
{
	q.push(v);
	visit[v] = true;
	cout << v << " ";

	while (!q.empty())
	{
		v = q.front();
		q.pop();

		for (int w = 1; w <= n; w++)
		{
			if (map[v][w] == 1 && visit[w] == 0)
			{
				q.push(w);
				visit[w] = true;
				cout << w << " ";
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> v;
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		map[a][b] = 1;
		map[b][a] = 1;
	}

	reset();
	DFS(v);

	cout << '\n';

	reset();
	BFS(v);

	return 0;

}