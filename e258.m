function res = e258()
    
    x = ones(2000,1);
    A = eye(2000,2000);
    for i=1:1999
        A(i,i+1)=1;
    endfor
    A(2000,1) = 1;
    A(2000,2) = 1;
%    k = int64(10^18);
%    A = int64(A);
%    base = int64(20092010);
    Aout = mat_pow_mod(A, 1, 20092010);
    res = Aout*x;
    res = mod(int64(res),20092010);

end

function Aout = mat_pow_mod(A, k, base)
    if(k==0) 
        Aout = eye(size(A));
        return;
    endif

    if(k==1)
        Aout = A;
        return;
    endif

    if(mod(k,2)==0)
        temp = mat_pow_mod(A,k/2, base);
        Aout = mod(temp*temp, base);
    else
        temp = mat_pow_mod(A,(k-1)/2, base);
        Aout = mod(A*temp*temp, base);
    endif
endfunction
