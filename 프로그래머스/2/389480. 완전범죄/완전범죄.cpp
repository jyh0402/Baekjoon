#include <string>
#include <vector>

using namespace std;

bool left[40][121][121];

int solution(vector<vector<int>> info, int n, int m) {
    int answer = 0;
    int size = info.size();
    
    left[0][info[0][0]][0] = true;
    left[0][0][info[0][1]] = true;
    
    for (int i = 1 ; i < size ; i++) {
        for (int j = 0; j < 121 ; j++) {
            for (int k = 0; k < 121 ; k++) {
                if (left[i-1][j][k]) {
                    left[i][j + info[i][0]][k] = true;
                    left[i][j][k + info[i][1]] = true;
                }
            }
        }
    }
    
    for (int i = 0 ; i < n ; i++) {
        for (int j = 0 ; j < m ; j++) {
            if (left[size-1][i][j]){
                return i;
            }
        }
    }
    
    return -1;
}