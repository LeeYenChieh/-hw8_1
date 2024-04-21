#include<bits/stdc++.h>
using namespace std;

typedef struct ttt{
	char name[64];
	char text[64];
	int num;
	char element[64][64];
}TextView;

TextView textviews[256];
int num = 0;

int check(char str[]){
	for(int i = 0;i < num;i++){
		if(strcmp(textviews[i].name, str) == 0)
			return i;
	}
	strcpy(textviews[num].name, str);
	num += 1;
	return num - 1;
}

int main() {
	for(int i = 0;i < 256;i++)
		textviews[i].num = 0;

	char temp[64];
	while(scanf("%s", temp) != EOF){
		int idx = check(temp);
		char none;
		bool ele = false;
		while (scanf("%c", &none) != EOF && none != '\n'){
			scanf("%s", temp);
			if(strcmp(temp, "add") == 0){
				ele = true;
			}
			else if(strcmp(temp, "display") == 0){
				printf("%s ", textviews[idx].text);
				for(int i = 0;i < textviews[idx].num;i++)
					printf("%s ", textviews[idx].element[i]);
				printf("\n");
			}
			else{
				if(ele){
					strcpy(textviews[idx].element[textviews[idx].num], temp);
					textviews[idx].num += 1;
				} else{
					strcpy(textviews[idx].text, temp);
				}
			}
		}
	}
}
