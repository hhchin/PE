


function sigfactor(n, p)
    
    counter = 0
    while n%p ==0 
        n = div(n,p)
        counter+=1
    end
    return (n, counter)
end


function e211(N)
fac = Array(Int64, N)
sigma = ones(Float64, N)

for n = 1:N
    fac[n] = n
end

for n = 2:N
#    if( (n%1000000) == 0)
#        println(n)
#    end
    if fac[n] == n

        p = n
        nk = p        
        while nk<=N
            (fac[nk], mult) = sigfactor(fac[nk],p)
            pf = convert(Float64, p)
            if mult==1
                sigma[nk] *= (pf^2+1)
            else
                sigma[nk] *= div((pf^2)^(mult+1)-1 , pf^2-1)
            end
            nk+=p
        end
    end
end

tot = 0
sigma[1] = 1
for n = 1:N
    if(sigma[n] <0)
        println(n,":",sigma[n])
    end
    testd = floor(sqrt(sigma[n]+0.5))
    if (testd*testd) == sigma[n]
        tot+=n
    end
end
    return tot
end


println(e211(64000000))
#println(e211(10))
#println(sigfactor(10,2))


