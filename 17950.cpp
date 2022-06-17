#include <iostream>
using namespace std;

typedef long long ll;

ll modpow(ll n, ll exp, ll mod) {
    if (exp < 2) return n;

    ll res = modpow(n, exp / 2, mod);
    res = res * res % mod;

    if (exp & 1) res = res * n % mod;

    return res;
}

const int p = 1000000007;

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    ll h, x, sum = 0, i, n;
    cin >> h >> x;

    for (i = 1; i <= h; i++) {
        cin >> n;

        ll snowball = modpow(x, i, p);
        snowball = (long long)snowball * n % p;

        sum = (sum + snowball) % p;
    }

    cout << sum << endl;
}