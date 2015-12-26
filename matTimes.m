function C = matTimes(A,B, varargin)
    [rA, cA] = size(A);
    [rB, cB] = size(B);
    C = zeros(size(rA,cB), class(A));
    
    if(length(varargin)>0)
        base = varargin{1};
        for r = 1:1:rA
            for c = 1:1:cB
                C(r,c) = mod(sum( mod(A(r,:).*B(:,c)', base)), base);
            end
        end
    else
        for r = 1:1:rA
            for c = 1:1:cB
                C(r,c) = sum(A(r,:).*B(:,c)');
            end
        end
    end

end
