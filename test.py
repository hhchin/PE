
m mathplus import timer, is_quad

N = 64000000


@timer
def pe(n):
        pool = [k * k + 1 for k in range(n)]
            pool[1] = 1

                for k in range(2, (n + 1) // 2):
                            k2 = k * k
                                    for m in range(k * 2, n, k):
                                                    pool[m] += k2

                                                        s = 0
                                                            for i, m in enumerate(pool):
                                                                        if is_quad(m):
                                                                                        s += i
                                                                                            return s

                                                                                        print(pe(N))
