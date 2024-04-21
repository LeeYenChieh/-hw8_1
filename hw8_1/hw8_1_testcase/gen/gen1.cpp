#include <bits/stdc++.h>
#include "testlib.h"
using namespace std;

int main(int argc, char* argv[]) {
	registerGen(argc, argv, 1);
	int n = atoi(argv[1]);
	int ins = atoi(argv[2]);
	int ele = atoi(argv[3]);
	string textviews[64];
	int hastext[64];
	for(int i = 0;i < n;i++){
		string temp = rnd.next("[a-zA-Z0-9]{1, 63}");
		textviews[i] = temp;
		hastext[i] = 0;
	}
	for(int i = 0;i < ins;i++){
		int idx = rnd.next(0, n - 1);
		cout << textviews[idx] << " ";

		if(hastext[idx] == 0){
			cout << rnd.next("[a-zA-Z0-9]{1, 63}") << endl;
			hastext[idx] = 1;
			continue;
		}

		int r = rnd.next(0, 3);
		if(r == 0){
			cout << "add ";
			int tempn = rnd.next(0, ele);
			for(int i = 0;i < tempn;i++){
				r = rnd.next(0, 1);
				if(r == 0)
					cout << "scrollBar";
				else
					cout << "thickBlackBorder";
				if(i != tempn - 1)
					cout << " ";
				else
					cout << "\n";
			}
		} else if(r == 1){
			cout << rnd.next("[a-zA-Z0-9]{1, 63}") << endl;
		} else{
			cout << "display" << endl;
		}
	}
	return 0;
}
