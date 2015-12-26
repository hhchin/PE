#!/usr/bin/env python

class memoize:
    def __init__(self, f):
        self.f = f
        self.memo = {}
    def __call__(self, *args):
        if not args in self.memo:
            self.memo[args] = self.f(*args)
        return self.memo[args]

def combinations(n, k):
    """
    Return C(n, k), the number of combinations of `k` out of `n`.
    """
    c = 1
    k = min(k, n - k)
    for i in xrange(1, k + 1):
        c *= (n - k + i)
        c //= i
    return c

@memoize
def T(n, d, k, t):
    """
    Return the number of ways `n` distinguishable `d`-sided dice can
    be rolled so that the top `k` dice sum to `t`.
    """
    print('case %d %d %d %d' % (n,d,k,t))
    # Base cases
    if n<0 or d<0 or k<0 or t<0: return 0
    if d==0: 
        if k==0 and t==0: return 1
        else: return 0
    if n==0:
        if k>0: return 0
        if k==0 and t>0: return 0
        if k==0 and t==0: return d**n
    # Divide and conquer. Let N be the maximum number of dice that
    # can roll exactly d.
    N = min(t//d,n)
    #print("min %d" % (N))
    return sum(combinations(n, i)
               * T(n - i, d - 1, k-i, t-i*d)
               for i in xrange(N + 1))

print(T(3, 3, 2,2))
#print(T(5, 6, 3,15))
#print(T(20, 12, 10,70))
