#include <cstdio>
int main() {
    int t, n, m;
    scanf("%d", &t);
    while (t--) {
        scanf("%d%d", &n, &m);
        puts(n < m ? "NO BRAINS" : "MMM BRAINS");
    }
}