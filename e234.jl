using prime


N = 999966663333
parr= primes(convert(Int128,floor(sqrt (N))))

total = 0
prime_limit = convert(Int128,floor(sqrt (N )))


for n = 1:(length(parr))-1
    p1 = parr[n];
    p2 = parr[n+1];
    x = div((p1*p1 + p2-1), p2)
    y = div(p2*p2, p1)
    total += p2*(div((p2-1)*p2,2) - div((x-1)*x,2));
    total += p1*( div(y*(y+1),2) - div(p1*(p1+1),2));
    if p1!=last
        total -= 2*p1*p2;
    end
    if p2==last 
        p1 = p2;
        p2 = parr[n+2];
        break;
    end
end
println(total)

