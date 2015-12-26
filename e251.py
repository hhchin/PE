#!/usr/bin/env/ python 

from itertools import count
from math import sqrt
import fractions
import time

def linear_diophantine_core(a, b, c):
    if a == 1:
        return (b + c, 1)
    elif a == -1:
        return (-b - c, 1)
    elif a == 0:
        return (1, -c / b)

    d = b / a
    r = b % a
    t = linear_diophantine_core(r, a, -c)
    return (t[1] + d * t[0], t[0])

def linear_diophantine(a, b, c):
    t = linear_diophantine_core(a, b, c)
    if t[0] > 0:
        if t[0] != 1:
            x = t[0] % b
            y = (a * x - c) / b
            t = (x, y)
    else:
        x = t[0] % b
        y = (a * x - c) / b
        t = (x, y)
    return t

def first_solution(p, q):
    linear_diophantine(8 * q, p * p, 3)



N = 110000000
s = 0
for p in xrange(1, int(sqrt(N * 8 / 3)), 2):
    for q in xrange(1, int(sqrt(N - p * p * 3 / 8))):
        if fractions.gcd(p, q) == 1:
            xy = linear_diophantine(8 * q, p * p, 3)
            k = q * xy[0]
            a = k * 3 - 1
            b = p * k / q
            c = q * q * (8 * k - 3) / (p * p)
            abc = a + b + c
            period = p * p * (p + 3 * q) + 8 * q ** 3
            if abc <= N:
                s += (N - abc) / period +1 
print s
