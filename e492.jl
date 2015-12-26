function primesmask(s::AbstractVector{Bool})
    n = length(s)
    n < 2 && return s; s[2] = true
    n < 3 && return s; s[3] = true
    r = floor(sqrt(n))
    for x = 1:r
        xx = x*x
        for y = 1:r
            yy = y*y
            i, j, k = 4xx+yy, 3xx+yy, 3xx-yy
            i <= n && (s[i] $= (i%12==1)|(i%12==5))
            j <= n && (s[j] $= (j%12==7))
            1 <= k <= n && (s[k] $= (x>y)&(k%12==11))
        end
    end
    for i = 5:r
        s[i] && (s[i*i:i*i:n] = false)
    end
    return s
end
primesmask(n::Integer) = primesmask(falses(n))
primes(n::Union(Integer,AbstractVector{Bool})) = find(primesmask(n))


function isPrime(plist, n)
    for p in plist
        if p*p>n
            return true
        end
        if n%p==0
            return false
        end
    end
    return true
end

function gennum(n, p)
    twopow = 1
    counter = 0
    pSq = convert(BigInt,p*p)
    resX = convert(BigInt, 0)
    resY = convert(BigInt, 0)
    while twopow <= n
        twopow*=2
        counter +=1 
    end
    twopow = div(twopow,2)
    counter-=1
   
#   println(n, ":", counter)
    X = Array(BigInt, counter+1)
    Y = Array(BigInt, counter+1)
    X[1] = 11
    Y[1] = 3
    for i = 2:counter+1
        X[i] = (X[i-1]^2 + Y[i-1]^2*13) % pSq
        Y[i] = (2*X[i-1]*Y[i-1]) % pSq
    end
    while n>0
        if n>=twopow
            curX = X[counter+1]
            curY = Y[counter+1]
            if resX==0
                resX = curX
                resY = curY
            else
                tmpX = resX
                tmpY = resY
                resX = ((tmpX*curX)%pSq  + (tmpY*curY*13)%pSq)%pSq
                resY = ((tmpX*curY)%pSq+ (tmpY*curX)%pSq)%pSq
            end
            n-=twopow
        end
        twopow = div(twopow,2)
        counter-=1
    end
#   println(n, ":", counter) 
    resX = (2*resX)%p
    return resX
end

function solve(x,y,n)
    plist = primes(100000)
    tot = 0
    for p = x:x+y
        if isPrime(plist, p) 
            twoNRed = powermod(2, n-1, p^2-1)
            twoinv = invmod(powermod(2,twoNRed,p),p)
            num = gennum(twoNRed,p)
            bn = ((num)*twoinv)%p
            an = (bn-5)*invmod(6,p)
            an = an % p
            tot += an 
        end
    end

    println(tot)
end        

solve(10^9, 10^7, 10^15)
