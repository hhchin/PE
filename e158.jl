function test(num_digits, num_chars)
    val = 0
    for i = 1:num_digits-1
    for j = 1: num_digits-i
        val+=binomial(num_digits-j, i-1)
    end
    end
    return binomial(num_chars, num_digits) * val
end

s = 0
for i=1:26
    s = max(s, test(i,26))
end
println(s)
