#include <stdio.h>

int main() {
    int arr[26] = {0};
    while (1) {
        char c = getchar();
        if (c == EOF) break;
        if ('a' <= c && c <= 'z') arr[c - 'a']++;
    }
    int max = 0;
    for (int i = 0; i < 26; i++) max = arr[i] > max ? arr[i] : max;
    for (int i = 0; i < 26; i++) if (arr[i] == max) putchar(i + 'a');
}