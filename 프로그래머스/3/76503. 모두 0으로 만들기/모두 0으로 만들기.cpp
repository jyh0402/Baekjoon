#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<vector<int>> graph;
vector<long long> weight;
long long answer = 0;

long long dfs(int cur, int parent) {
    for (int next : graph[cur]) {
        if (next == parent) continue;
        weight[cur] += dfs(next, cur);
    }
    answer += llabs(weight[cur]);
    return weight[cur];
}

long long solution(vector<int> a, vector<vector<int>> edges) {
    
    // 가능한지 체크
    long long sum = 0;
    int N = a.size();
    for (int i = 0 ; i < N ; i++) {
        sum += a[i];
    }
    if (sum != 0) return -1;
    
    // 가능하면 찾기
    graph.assign(N, vector<int>());
    weight.assign(N, 0);
    for (int i = 0; i < N; i++) {
        weight[i] = a[i];
    }
    
    for (int i = 0 ; i < edges.size() ; i++) {
        int x = edges[i][0];
        int y = edges[i][1];
        graph[x].push_back(y);
        graph[y].push_back(x);
    }
    
    dfs(0,-1);
    
    return answer;
}