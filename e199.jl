


function solve(depth, k1, k2, k3)
    if(depth<=0)
        return 0.0
    end

    k4 = k1+k2+k3+2*sqrt(k1*k2+k2*k3+k3*k1)
    r4 = 1/k4
    a4 = pi*r4^2
    s = ":"
#println(depth,s,k1,s,k2,s,k3,s,k4,"->",a4)

    if k1==k2==k3
        return a4+3*solve(depth-1, k1,k2,k4)
    end

    if k1==k2!=k3
        return a4+solve(depth-1, k4, k1,k2)+2*solve(depth-1, k4,k2,k3)
    end

    if k1!=k2==k3
        return a4+solve(depth-1, k4, k2, k3)+2*solve(depth-1, k4, k1,k2)
    end

    if k1!=k2!=k3
        return a4+solve(depth-1, k4,k1,k2)+solve(depth-1, k4,k2,k3)+solve(depth-1,k4,k1,k3)
    end

    println("ERROR") 
    
end


r1 = 2*sqrt(3)-3
k1 = 1/r1
d = 10
a1 = 3*pi*r1*r1

soln = a1+3*solve(d,k1,k1,-1)+solve(d,k1,k1,k1)

println(1-soln/pi)

