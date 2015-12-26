fd = open("out.txt")
arr = Int128[];
for ln in eachline(fd)
    push!(arr,parse(Int,ln))
    
end

close(fd)

C = Array(Int128, 15)
R = Array(Int128, 15)

for i = 1:15
    C[i] = arr[i]
    R[i] = arr[i+15] - arr[i]
end

goal = 10^14
N = div(goal, 15)-1
B = 123454321
rm = mod(goal, 15)
soln = 0

println(N)
println(rm)

for i =1:min(goal,15)
    soln+=C[i]
end

if N>0
for i=1:15
    nb = mod(N, B)
    db = invmod(10^6-1, B)
    soln+= mod((nb)*C[i], B) -  mod(R[i]*nb,B)*db + mod(R[i]*db*db,B)*(powermod(10,6*(N+1),B)-powermod(10,6,B))
    soln = mod(soln,B)
end



for i=1:rm
    soln+= C[i] + mod(R[i]*invmod(10^6-1,B)*(powermod(10,6*(N+1),B)-1),B)
    soln = mod(soln, B)
end

end

println(soln)

sc = 0
for i=1:30
    sc+=arr[i]
end
println(mod(sc,B))






