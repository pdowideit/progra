increment(leaf(X),leaf(s(X))).
increment(node(L,N,R),node(IncL,s(N),IncR)):-increment(L,IncL),
increment(R,IncR).

append([],YS,YS).
append([X|XS],YS,[X|Res]):-append(XS,YS,Res).

inorder(node(L,N,R),Res):-inorder(L,ResL),inorder(R,ResR),append(ResL,[N|ResR],Res).
inorder(leaf(N),[N]).

preorder(node(L,N,R),Res):-preorder(L,ResL),preorder(R,ResR),append([N|ResL],ResR,Res).
preorder(leaf(N),[N]).

postorder(node(L,N,R),Res):-postorder(L,ResL),postorder(R,ResR),append(ResL,ResR,Res1),append(Res1,[N],Res).
postorder(leaf(N),[N]).
