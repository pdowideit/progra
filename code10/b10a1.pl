person(jgi).
person(jhe).
person(mha).
person(dko).
person(lbe).
person(saz).
person(fai).
person(ner).
person(mus).

hatRang(jgi,professor).
hatRang(jhe,assistent).
hatRang(mha,assistent).
hatRang(dko,assistent).
hatRang(lbe,tutor).
hatRang(saz,tutor).
hatRang(fai,student).
hatRang(ner,student).
hatRang(mus,student).

bossVon(X,Y):-hatRang(X,professor),hatRang(Y,assistent).
bossVon(X,Y):-hatRang(X,assistent),hatRang(Y,tutor).
bossVon(X,Y):-hatRang(X,tutor),hatRang(Y,student).

vorgesetzt(X,Y):-bossVon(X,Y).
vorgesetzt(X,Y):-bossVon(X,Z),vorgesetzt(Z,Y).