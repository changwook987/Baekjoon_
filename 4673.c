#include <stdio.h>

char a[10000] = {0};

void check(int n) {
    int tmp = n;
    while (tmp) {
        n += tmp % 10;
        tmp /= 10;
    }
    if (tmp > 10000) return;
    a[n]++;
}

int main() {
    for (int i = 0; i < 10000; i++) {
        check(i);
    }
    
    for (int i = 0; i < 10000; i++) {
        if (!a[i]) {
            printf("%d\n", i);
        }
    }
}