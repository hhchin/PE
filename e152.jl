global no = [2,3,4,5,6, 7,8,9,10,12, 14,15,16,18,20, 21,24,25,27,28, 30,32,35,36,40, 42,45,48,49,50, 54,56,60,63,64, 70,72,75,80]
global no_len = length(no)
global glcm = lcm(no)^2
global hlcm = div(glcm,2)
no_sq = no.^2



println(glcm)
