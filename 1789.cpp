#include <cstdio>
int main() {
    long long n;
    scanf("%lld", &n);
    long long i = 1;
    int cnt = 0;
    while (n >= i) {
        n -= i++;
        cnt++;
    }
    printf("%d", cnt);
}