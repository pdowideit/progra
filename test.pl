taller(bob,mike).
taller(mike,jim).
taller(jim,george).

istaller(X,Y):-taller(X,Y).

istaller(X,Y):-taller(X,Z),
istaller(Z,Y).

/**istaller(bob,george)->Z=mike->istaller(mike,george)->Z=jim->istaller(jim,george)->true**/

linked(t1,t2).
linked(t2,t3).
linked(t3,t4).
linked(t4,t5).
linked(t5,t6).

can_get(X,Y):-linked(X,Y).
can_get(X,Y):-linked(X,Z),
can_get(Z,Y).

p([H|T], H, T).

on(Item,[Item|Rest]).  

on(Item,[DisregardHead|Tail]):-
          on(Item,Tail).
		
members([london_buckingham_palace,
 paris_eiffel_tower,
 york_minster,
 pisa_leaning_tower,
 athens_parthenon]).
 
 member(Item):-members(L),
 check(Item,L).
 
 check(Item,[Item|Rest]).
 check(Item,[Head|Rest]):-check(Item,Rest).