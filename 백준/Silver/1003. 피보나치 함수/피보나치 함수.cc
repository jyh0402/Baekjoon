#include <iostream>
#include <cstring>
#include <cmath>
using namespace std;
int num0[41] = { 1, 0, 1, 1, };
int num1[41]= { 0 , 1, 1, };

int zero(int n) {
	int result = 0;
	if (n == 0) { result = 1; }
	else if (n == 1) { result = 0; }
	else if (num0[n]) { result = num0[n]; }
	else {
		num0[n] = zero(n - 1) + zero(n - 2);
		result = num0[n];
	}
	return result;
}

int one(int n) {
	int result = 0;
	if (n == 0) { result = 0; }
	else if (num1[n]) { result = num1[n]; }
	else {
		num1[n] = one(n - 1) + one(n - 2);
		result = num1[n];
	}
	return result;
}


int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);


	int k = 0, a,b, m = 0, v = 1, sum = 0;
	int n; //입력 숫자 

	cin >> n;
	while (k < n)
	{
		cin >> a;

		cout << zero(a) << " " << one(a) << "\n";
		k++;
	}


	
	return 0;
}