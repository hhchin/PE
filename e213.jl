
function gen_trans()
    I = Array(Int32, 4*900*900)
    J = Array(Int32, 4*900*900)
    V = Array(Float64, 4*900*900)
    cnt = 1;
    for r=1:30
    for c=1:30
        Nr = Int32[];
        Nc = Int32[];
        if r>1
            push!(Nr,r-1)
            push!(Nc,c)
        end

        if r<30
            push!(Nr,r+1)
            push!(Nc, c)
        end

        if c>1
            push!(Nr,r)
            push!(Nc,c-1)
        end

        if c<30
            push!(Nr,r)
            push!(Nc,c+1)
        end

        v = 1/length(Nr)

        i = (r-1)*30+c
        while length(Nr)>0
            I[cnt] = i
            J[cnt] = (pop!(Nr)-1)*30+pop!(Nc)
            V[cnt] = v
            cnt+=1
        end
    end
    end
    cnt-=1
    I = I[1:cnt]
    J = J[1:cnt]
    V = V[1:cnt]

    return sparse(J,I,V,900,900)

end

function solve(r,c, trans)
    
    x = spzeros(900,1)
    x[ (r-1)*30+c] = 1.0
    for i=1:50
        x = trans*x
    end
    return sparse(ones(Float64,900,1))-x
end


trans = gen_trans()
soln = sparse(ones(Float64,900,1))
for r=1:30
for c=1:30
    cur = solve(r,c,trans)
    soln = soln.*cur
end
end

@printf("%1.7f\n",sum(soln))

