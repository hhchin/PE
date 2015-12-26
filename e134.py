#!/usr/bin/env python

def egcd(a,b):
    x,y,u,v = 0,1,1,0
    while a != 0:
        q,r = b//a, b%a
        m,n = x-u*q, y-v*q
        b,a,x,y,u,v = a,r,u,v,m,n
    gcd  = b
    return gcd, x, y

def dcount(n):
    if n==0:
        return 1

    d = 0
    while n != 0:
        d +=1
        n = n//10
    return d

def primes(n):
    sieve = [True] * n
    for i in xrange(3,int(n**0.5)+1,2):
        if sieve[i]:
            sieve[i*i::2*i]=[False]*((n-i*i-1)/(2*i)+1)
    return [2] + [i for i in xrange(3,n,2) if sieve[i]]

def solve(p,q):
    a = 10 ** dcount(p)
    b = q-p
    g,x,y = egcd(a,q)
    return (x*b % q)*a+p

LIM = 1000004
plist = primes(LIM)
soln = 0
for i in xrange(2,plist.__len__()-1):
    soln += solve(plist[i], plist[i+1])

print soln

