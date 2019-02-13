isList(nil).
isList(cons(_,XS)):-isList(XS).


toPrologList(nil,[]).
toPrologList(cons(X,XS),[X|YS]):-toPrologList(XS,YS).	

flatten([],[]).
flatten([[]|XS],YS):-flatten(XS,YS).
flatten([[X|XS]|XSS],[X|YS]):-flatten([XS|XSS],YS).

appendElement([],X,[X]).
appendElement([X|XS],Y,[X|YS]):-appendElement(XS,Y,YS).

reverseList([],[]).
reverseList([X],[X]).
reverseList([X|XS],REV):-reverseList(XS,YS),appendElement(YS,X,REV).
