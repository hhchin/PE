from itertools import *
from fractions import Fraction
import time

def  Make_primes (N):
     Return [n for n in xrange (2, N + 1): 
		if all (! n% P = 0 for P in xrange (2, n))]

def  Make_pows (PS, N):
     Return sorted (list (P ** e for P in PS
                         for e in takewhile ( lambda e: P ** e <= N, count (1))))

def  Div_pow (n, D):
    e = 0
    while n% D == 0:
        e + = 1
        n / = d
    Return e, n

def  factorize (n, K0 = 0):
     for k, P in enumerate (takewhile ( lambda P: P * P <= n, primes [K0:]), K0):
         if n% P == 0:
            e, m = div_pow (n, p)
            Return ((P, e),) + factorize (M, k + 1)
     Return ((n, 1),) if n> 1 else ()

def  Gen_sums (a, k = 0):
     if k == len (a):
         yield 0
     else :
         for s in Gen_sums (a, k + 1):
             for n in a [k]:
                 yield s + n

def  Add_prime_pow (v, Q):
     def  is_valid (n):
         Return all (P ** e <Q for P, e in factorize (n))
    
# Print Q, len (v), time.clock () - T0 
    ns = [n * Q for n in xrange (1, N / Q + 1) if is_valid (n)]
    a = [(0, Fraction (1, n * n)) for n in ns] + [v]
    p, e = factorize (q) [0]
    d = p ** (e * 2 - 1)
    Return [f for f in Gen_sums (a) if F.Denominator% D! = 0]

t0 = time.clock ()
N = 80
primes = make_primes (N)
p_pows = make_pows (primes, N)
fs = reduce (add_prime_pow, reversed (p_pows [1:]), [0])
Print sum (1 for f in FS if f == Fraction (1, 4))
Print time.clock () - T0
