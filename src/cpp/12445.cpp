#include<bits/stdc++.h>

using namespace std;

template<typename T, size_t N>
struct hash<array<T, N> >{

    typedef array<T, N> argument_type;
    typedef size_t result_type;

    result_type operator()(const argument_type& a) const{
        hash<T> hasher;
        result_type h = 0;
        for (result_type i = 0; i < N; ++i){
            h = h * 31 + hasher(a[i]);
        }
        return h;
    }
};

array<int, 12> lRotCW(array<int, 12> arr){
    array<int, 12> rot;
    for(int i=0; i<5; i++) rot[i] = arr[i+1];
    for(int i=6; i<11; i++) rot[i] = arr[i];
    rot[5] = arr[11];
    rot[11] = arr[0];
    return rot;
}

array<int, 12> lRotCCW(array<int, 12> arr){
    array<int, 12> rot;
    for(int i=1; i<6; i++) rot[i] = arr[i-1];
    for(int i=6; i<11; i++) rot[i] = arr[i];
    rot[0] = arr[11];
    rot[11] = arr[5];
    return rot;
}

array<int, 12> rRotCW(array<int, 12> arr){
    array<int, 12> rot;
    for(int i=0; i<5; i++) rot[i] = arr[i];
    for(int i=5; i<11; i++) rot[i] = arr[i+1];
    rot[11] = arr[5];
    return rot;
}

array<int, 12> rRotCCW(array<int, 12> arr){
    array<int, 12> rot;
    for(int i=0; i<5; i++) rot[i] = arr[i];
    for(int i=6; i<12; i++) rot[i] = arr[i-1];
    rot[5] = arr[11];
    return rot;
}

array<int, 12> rotCW(array<int, 12> arr){
    array<int, 12> rot;
    for(int i=0; i<11; i++) rot[i] = arr[i+1];
    rot[11] = arr[0];
    return rot;
}

array<int, 12> rotCCW(array<int, 12> arr){
    array<int, 12> rot;
    for(int i=1; i<12; i++) rot[i] = arr[i-1];
    rot[0] = arr[11];
    return rot;
}

unordered_map<array<int, 12>, int> r;
unordered_map<array<int, 12>, int> memo;
int ans;

void bfsLeft(array<int, 12> start){
    unordered_map<array<int, 12>, int> visited;
    visited[start] = 0;
    queue<array<int, 12>> q;
    q.emplace(start);

    while(!q.empty()){
        array<int, 12> cur = q.front();
        q.pop();
        int d = visited[cur];
        if(r.find(cur)!=r.end()){
            ans = d+r[cur];
            return;
        }

        array<int, 12> next;
        next = lRotCCW(cur);
        if(visited.find(next)==visited.end()){
            if(r.find(next)!=r.end()){
                ans = d+1+r[next];
                return;
            }

            visited[next] = d+1;
            if(d<8) q.emplace(next);
        }
        next = lRotCW(cur);
        if(visited.find(next)==visited.end()){
            if(r.find(next)!=r.end()){
                ans = d+1+r[next];
                return;
            }

            visited[next] = d+1;
            if(d<8) q.emplace(next);
        }

        next = rRotCCW(cur);
        if(visited.find(next)==visited.end()){
            if(r.find(next)!=r.end()){
                ans = d+1+r[next];
                return;
            }

            visited[next] = d+1;
            if(d<8) q.emplace(next);
        }
        next = rRotCW(cur);
        if(visited.find(next)==visited.end()){
            if(r.find(next)!=r.end()){
                ans = d+1+r[next];
                return;
            }
            
            visited[next] = d+1;
            if(d<8) q.emplace(next);
        }

        next = rotCCW(cur);
        if(visited.find(next)==visited.end()){
            if(r.find(next)!=r.end()){
                ans = d+1+r[next];
                return;
            }

            visited[next] = d+1;
            if(d<8) q.emplace(next);
        }
        next = rotCW(cur);
        if(visited.find(next)==visited.end()){
            if(r.find(next)!=r.end()){
                ans = d+1+r[next];
                return;
            }

            visited[next] = d+1;
            if(d<8) q.emplace(next);
        }
    }
}

void bfsRight(){
    array<int, 12> start = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    unordered_map<array<int, 12>, int> visited;
    visited[start] = r[start] = 0;
    queue<array<int, 12>> q;
    q.emplace(start);

    while(!q.empty()){
        array<int, 12> cur = q.front();
        q.pop();
        int d = visited[cur];
        array<int, 12> next;

        next = lRotCCW(cur);
        if(visited.find(next)==visited.end()){
            visited[next] = r[next] = d+1;
            if(d<8) q.emplace(next);
        }
        next = lRotCW(cur);
        if(visited.find(next)==visited.end()){
            visited[next] = r[next] = d+1;
            if(d<8) q.emplace(next);
        }

        next = rRotCCW(cur);
        if(visited.find(next)==visited.end()){
            visited[next] = r[next] = d+1;
            if(d<8) q.emplace(next);
        }
        next = rRotCW(cur);
        if(visited.find(next)==visited.end()){
            visited[next] = r[next] = d+1;
            if(d<8) q.emplace(next);
        }

        next = rotCCW(cur);
        if(visited.find(next)==visited.end()){
            visited[next] = r[next] = d+1;
            if(d<8) q.emplace(next);
        }
        next = rotCW(cur);
        if(visited.find(next)==visited.end()){
            visited[next] = r[next] = d+1;
            if(d<8) q.emplace(next);
        }
    }
}

// note: udebug AC solution seems wrong. My output is identical except for
// 2 cases where udebug was outputting 19 and I wasn't, but my solution is still AC
int main(){
    bfsRight();
    int tc;
    scanf("%d", &tc);
    while(tc--){
        array<int, 12> start;
        for(int i=0; i<12; i++) scanf("%d", &start[i]);
        if(memo.find(start)!=memo.end()){
            printf("%d\n", memo[start]);
        } else {
            ans = 19;
            bfsLeft(start);
            memo[start] = ans;
            printf("%d\n", ans);
        }
    }
}