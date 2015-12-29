#include <iostream>
#include <string>
#include <vector>
#include <list>
#include <map>
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

class Node {
public:
    int key;
    int value;

    Node(int k, int v):
    key(k), value(v) {}
};
typedef list<Node>::iterator NodePtr;


class LRUCache {
public:
    LRUCache(int capacity): 
    m_capacity(capacity){
    }

    ~LRUCache() {
    }

    void touch(NodePtr itor) {
        if (itor == --m_cache.end()) {
            return;
        }
        m_cache.push_back(*itor);
        m_table[itor->key] = --m_cache.end();
        m_cache.erase(itor);
    }

    int get(int key) {
        int value = -1;
        if (m_table.find(key) != m_table.end()) {
            NodePtr itor = m_table[key];
            value = itor->value;
            touch(itor);
        }
        return value;
    }

    void set(int key, int value) {
        if (m_table.find(key) != m_table.end()) {
            NodePtr itor = m_table[key];
            itor->value = value;
            touch(itor);
        } else { 
            if (m_cache.size() == m_capacity) {
                NodePtr itor = m_cache.begin();
                m_table.erase(itor->key);
                m_cache.erase(itor);
            } 
            Node n(key, value);
            m_cache.push_back(n);
            NodePtr ptr = --m_cache.end();
            m_table[key] = ptr;
        }
    }

private:
    int m_capacity;
    list<Node> m_cache;
    map<int, NodePtr> m_table;
};

int main() {
    LRUCache lru(2);
    lru.set(2,1);
    lru.set(1,1);
    lru.set(2,3);
    lru.set(4,99);
    cout<<lru.get(2)<<endl;
    cout<<lru.get(4)<<endl;
    cout<<lru.get(2)<<endl;
    return 0;
}

