
function bin(n)
    for i=0:50
        mask = 1<<i
        print( (n&mask == mask) ? 1 : 0 )
    end
end

magic = 0
for i=51:100
    magic+=i*i
end


curhs = IntSet(0)
arr = zeros(Int64, magic+1)
arr[1] = 1
check = (1<<50)
guard = (1<<51)-1

for i=1:100
    ii = i*i
    newhs = IntSet()
    newarr = deepcopy(arr)
    for n in curhs
        cur = n+ii
        val = arr[n+1]
        if (cur > magic || val == 0)
            continue
        end

        if(cur == magic)
            bin(val)
            print("->",n,":",i)
            println()
        end

        newarr[cur+1] = newarr[cur+1] | ((val<<1)&guard)
        push!(newhs, n)
        push!(newhs, cur)
    end
    curhs = newhs
    arr = deepcopy(newarr)
end
counter = 0

#for i=51:100
#    counter+=i*i
#    println(counter,":",arr[counter+1])
#end

sum = 0

for i= 1:magic
    if (arr[i+1]&check) == check        
        sum+=(i)
    end
end

println(length(curhs))
#for n = magic-101:magic
#    bin(arr[n+1])
#    println("->",n)
#end

println("soln")
bin(arr[magic])
println()
bin(arr[magic+1])
println()
println(sum)

println(115039000)

