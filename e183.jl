function check(n,k)

    g = gcd(n,k)
    n = div(n,g)
    k = div(k,g)
    while k%2==0
        k = div(k,2)
    end
    while k%5 == 0
        k = div(k,5)
    end
    return k==1
end

function P(n, k)
    n = convert(Float64, n)
    r = n/k
    return k*log(r)
end

function D(n)
    k1 = floor(n/e)
    k2 = k1+1
    p1 = P(n, k1)
    p2 = P(n, k2)
    k =  p1>p2 ? k1 : k2
    k = convert(Integer,k)
    if check(n,k)
        return -n
    else
        return n
    end
end

tot = 0
for n = 5:10000
    tot += D(n)
end
println(tot)
