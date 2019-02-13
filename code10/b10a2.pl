istUnterkunft(wh).
istUnterkunft(bh).
istUnterkunft(sh).
istUnterkunft(ph).
istUnterkunft(jh).
istUnterkunft(fb).

hatSterne(wh,4).
hatSterne(bh,5).
hatSterne(sh,2).
hatSterne(ph,1).
hatSterne(jh,3).
hatSterne(fb,5).

hatEinenStern(X):-
istUnterkunft(X),
hatSterne(X,1).

hatZweiSterne(X):-
istUnterkunft(X),
hatSterne(X,2).

hatDreiSterne(X):-
istUnterkunft(X),
hatSterne(X,3).

hatVierSterne(X):-
istUnterkunft(X),
hatSterne(X,4).

hatFuenfSterne(X):-
istUnterkunft(X),
hatSterne(X,5).

hatEinenSternWeniger(X,Y):-
hatSterne(X,N),
hatSterne(Y,M),
N is M-1.	

hatWenigerSterne(X,Y):-
hatSterne(X,N),
hatSterne(Y,M),
N < M.


