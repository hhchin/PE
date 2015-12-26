import math

n = 1000000

# find the primes first
primeArray = [True for x in range(n)]
primes = []

for (i,val) in enumerate(primeArray):
  if i == 0 or i == 1:
    continue
  if val:
    primes.append(i)
    for j in range(i*2, n, i):
      primeArray[j] = False
print(len(primes))

def triangulate(i):
  vertical_props = math.floor(n/i - 1) # vertical propagation - 2/4, 2/6, 2/8 are all relative primes, and hence there are n/i -1
  props = (vertical_props + 1) * (vertical_props / 2.0) # horizontal propagation - 2/6 propagates to 4/6 & 2/8 to 4/8, 6/8. 
                                                       # This is a sum of a linear (+1) series. Every subsequent fraction 
                                                       # 1 more propagation, because it is one order of i higher.
  return props


# focus on one slice only at first
green = 0
# find all relative primes in a slice
for (i,prime) in enumerate(primes):
  init = green
  green += triangulate(prime)
  #print("propagation", prime, green - init)
  for j in primes[(i+1):]:
    if prime*j*2 <= n:
      green -= triangulate(prime*j)
      #print("reversing %s and %s by %s" % (prime, j, triangulate(prime*j)))

green += (n - 1)

green *= 6

print(green)
