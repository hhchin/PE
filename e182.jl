function num(e,p,q)
    return (gcd(e-1,p-1)+1)*(gcd(e-1,q-1)+1)
end

p = 1009
q = 3643

n = p*q
phi = n - p- q +1
res = 0
min_num = typemax(Int)

for e = 1:phi-1
    if gcd(e,phi) == 1
        cur_num = num(e,p,q)
    if cur_num < min_num
        min_num = cur_num
        res = e
    else
        if cur_num == min_num
            res += e
        end
    end
    end
end

println(res)
