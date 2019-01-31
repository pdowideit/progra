f(s(M),s(N)):-f(M,s(s(N))).
f(s(M),s(0)):-f(M,0).
f(0,s(N)).
