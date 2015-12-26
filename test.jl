magic = 51*51
arr = zeros(Int64, magic+1)

arr[1] = 1
s = IntSet(0)

for i = 1:51
    ns = IntSet()
    ii = i*i
    for n in s
        cur = n+ii
        if cur < magic+1
            arr[cur+1] += arr[n+1]
            push!(ns, cur)
            push!(ns, n)
            if cur == magic
                println(i, ":", n)
            end
        end
    end
    s = ns
end

println(arr[51*51+1])
