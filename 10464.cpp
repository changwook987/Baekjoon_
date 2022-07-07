#import<ios>
int x(int n){int m=n%4;return !m?n:!(m-1)?1:!(m-2)?n+1:0;}
main() {int n,a,b;scanf("%d",&n);while(n--){scanf("%d%d",&a,&b);printf("%d",x(b)^x(a-1));}}