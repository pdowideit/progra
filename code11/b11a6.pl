divisors(X, Y) :- X > 0, divisors(X, X, Y).

divisors(X, 1, [1]).
divisors(X, N, [N|Y]) :- N > 0,
                         M is X mod N, M = 0,
                         N1 is N - 1,
                         divisors(X, N1, Y).
divisors(X, N, Y) :- N > 0,
                     M is X mod N, M > 0,
                     N1 is N - 1,
                     divisors(X, N1, Y).
