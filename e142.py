#!/usr/bin/env/ python

from math import sqrt,floor

def is_square(n):
    nroot = floor(sqrt(n))
    return nroot*nroot == n

nsolved = True
i=4

while nsolved:
    a=i*i
    j=3

    while nsolved:
        c=j*j
        f = a-c
        if f<=0 or not is_square(f):
            continue
        kstart = 2
        if j%2==1:
            kstart = 1
        for k in xrange(kstart, j-1, 2):
            d = k*k
            e = a-d
            b = c-e
            if b<=0 or e<=0 or  not is_square(b) or not is_square(e):
                continue
            x = long((d+c)/2)
            y = long((e+f)/2)
            z = long((c-d)/2)

            res = x+y+z
            nsolved = False
            break

        j+=1
    i+=1

print res

