t=1
while true
    n = 12345*t+1
    if n-1 < 2^(t+1)
        break
    else
        t+=1
    end
end

println(t)
