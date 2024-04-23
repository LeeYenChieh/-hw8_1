#include<bits/stdc++.h>
using namespace std;

int checkNum(char *str){
	int len = strlen(str);
	int value = 0;
	for(int i = len - 1;i >= 0;i--){
		value *= 10;
		value += str[i] - '0';
		if(str[i] < '0' || str[i] > '9')
			return -1;
	}
	return value;
}

int main() {
	char temp[64];
	bool hasBookNum = false, hasUserNum = false;
	int bookNum = -1, userNum = -1;
	while(scanf("%s", temp) != EOF){
		char none;
		while (scanf("%c", &none) != EOF && none != '\n'){
			scanf("%s", temp);
			if(!hasBookNum){
				bookNum = checkNum(temp);
			}
		}
	}
}
