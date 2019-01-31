divisors(X,[1]).
divisors(X,[Head|Tail]):-
	>(X,0),
	0 is mod(X,Head),
	divisors(X,Tail).
	
	