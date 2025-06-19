#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>

using namespace std;

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	string n;
	string num = "";
	int sum = 0;
	int x = 0;
 //입력 숫자 

	cin >> n;
	for (int i = 0; i <= n.length(); i++)
	{
		if (n[i] == '-' || n[i] == '+' || i == n.length())
		{
			if (x == 1)
			{
				sum -= stoi(num);
				num = "";
			}
			else
			{
				sum += stoi(num);
				num = "";
			}
		}
		else
		{
			num += n[i];
		}

		if (n[i] == '-')
			x = 1;
	}
	
	cout << sum;

	return 0;
}