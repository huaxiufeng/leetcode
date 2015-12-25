#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

template <typename T>
void display(vector<T> array) {
    for (int i = 0; i < array.size(); i++) {
        cout<<array[i]<<" ";
    }
    cout<<endl;
}

template <typename T>
void display(vector<vector<T>>& array) {
    for (int i = 0; i < array.size(); i++) {
        display(array[i]);
    }
}

class Solution {
public:

    string removeDuplicateLetters(string s) {
        if(s=="")
            return s;
        cout<<">> checking "<<s<<endl;
        string res="";
        vector<int> letter(26,0);
        int len = s.size();
        for(int i=0;i<len;++i){
            ++letter[s[i]-'a'];
        }
        int min_pos=0;
        for(int i=0;i<len;++i){
            char cur = s[i];
            cout<<"checking "<<i<<" "<<cur<<endl;
            if(cur < s[min_pos]) {
                min_pos = i;
                cout<<"update min pos to "<<i<<endl;
            }
            if(--letter[cur-'a']==0) {
                cout<<"break now!"<<endl;
                break;
            }
        }
        res += s[min_pos];
        cout<<"res is "<<res<<endl;
        char c=s[min_pos];
        s = s.substr(min_pos+1);
        s.erase(remove(s.begin(),s.end(),c),s.end());
        res += removeDuplicateLetters(s);
        return res;
    }

/*
    void countLetters(const char* str, int len, int count[]) {
        memset(count, 0, 256*sizeof(int));
        for (int i = 0; i < len; i++) {
            ++count[str[i]];
        }
    }

    string removeDuplicateLetters(string s) {
        int count[256] = {0};
        int inres[256] = {0};
        int len = s.size();
        if (len <= 1) {
            return s;
        }
        const char* str = s.c_str();

        countLetters(str, len, count);
        string res;
        int min_pos = 0;
        for (int i = 0; i < len; i++) {
            char c = s[i];
            if (inres[s[i]]) {
                continue;
            }
            if (c < s[min_pos]) {
                min_pos = i;
            }
            --count[c];
            if (count[c] == 0) {
                if (inres[s[min_pos]] == 0) {
                    res += s[min_pos];
                    inres[s[min_pos]] = 1;
                }
                i = min_pos;
                min_pos++;
                countLetters(str+min_pos, len-min_pos, count);
            }
        }

        return res;
    }
*/
};

int main() {
    Solution s;
    cout<<s.removeDuplicateLetters("abacb")<<endl;
    cout<<s.removeDuplicateLetters("cbacdcbc")<<endl;
    return 0;
}

