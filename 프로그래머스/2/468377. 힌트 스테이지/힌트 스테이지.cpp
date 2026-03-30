#include <string>
#include <vector>
#include <queue>
#include <climits>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> cost, vector<vector<int>> hint) {
    int answer = INT_MAX;
    int N = cost.size();
    int h = hint.size();
    
    for (int mask = 0; mask < (1 << h); mask++) {
        int bundleCost = 0;
        vector<int> hintCount(N, 0);
        
        for (int i = 0; i < h; i++) {
            if (mask & (1 << i)) {
                bundleCost += hint[i][0];
                
                for (int j = 1; j < hint[i].size(); j++) {
                    int s = hint[i][j] - 1;
                    if (0 <= s && s < N) {
                        hintCount[s]++;
                    }
                }
            }
        }
        
        int total = bundleCost;
        

        for (int s = 0; s < N; s++) {
            int cnt = hintCount[s];
            
            if (cnt >= cost[s].size()) {
                cnt = cost[s].size() - 1;
            }
            
            total += cost[s][cnt];
        }
        
        answer = min(answer, total);
    }
    
    return answer;
}

