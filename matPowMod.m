function val = matPowMod(M, pow, base)
    if(pow == 0) 
        val = eye(size(M));
        return;
    end

    if(pow == 1)
        val = M;
        return;
    end

    if(mod(pow,2) ==1)
        val = matTimes(M, matPowMod(mod(matTimes(M, M, base),base), (pow-1)/2,base), base);
    else
        val = matPowMod(mod(matTimes(M, M, base),base), (pow)/2,base);
    end
    
    val = mod(val,base);

end


