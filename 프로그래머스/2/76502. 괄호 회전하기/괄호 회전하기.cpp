#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

int solution(string s) {
    int answer = 0;
    int size = s.size();
    
    for (int i = 0 ; i < size ; i++) { // 시작 위치
        stack<char> st;
        bool isOK = true;
        int a = 0, b = 0, c = 0;
        st.push(s[i]);
        for (int j = 1 ; j < size; j++) { // 전체 순환
            int cur = (i+j) % size;
            if (st.empty()) {
                st.push(s[cur]);
                continue;
            }
            if (s[cur] == ')' || s[cur] == '}' || s[cur] == ']') {
                char ch = st.top();
                if ((s[cur] == ')' && ch == '(') || (s[cur] == '}' && ch == '{') || (s[cur] == ']' && ch == '[')) {
                    st.pop();
                } else {
                    break;
                }
            } else {
                st.push(s[cur]);
            }
            
        }
        if (st.empty()) {
            cout << i <<"\n";
            answer++;
        }
    }
    return answer;
}