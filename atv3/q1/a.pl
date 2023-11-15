    aluno(ana, plp).
    aluno(brenda, plp).
    aluno(camila, plp).
    aluno(douglas, plp).
    aluno(evandro, plp).
    aluno(fernando, plp).
    aluno(graziela, plp).
    aluno(helena, plp).
    aluno(isis, plp).
    aluno(joaquim, plp).
    aluno(kelvin, plp).
    aluno(luana, plp).
    aluno(mayara, plp).
    aluno(nilsa, plp).
    aluno(marcelo, plp).
    aluno(nadja, plp).
    aluno(olavo, plp).
    aluno(paula, plp).
    aluno(quirino, plp).
    aluno(raissa, plp).
    aluno(santiago, plp).
    aluno(thiago, plp).
    aluno(ulisses, plp).
    aluno(viviane, plp).
    aluno(wilson, plp).
    aluno(xena, plp).
    aluno(yuri, plp).
    aluno(zuleide, plp).
    aluno(brenda, eda).
    aluno(camila, eda).
    aluno(douglas, eda).
    aluno(fernando, eda).
    aluno(graziela, eda).
    aluno(helena, eda).
    aluno(joaquim, eda).
    aluno(luana, eda).
    aluno(mayara, eda).
    aluno(nilsa, eda).
    aluno(marcelo, eda).
    aluno(nadja, eda).
    aluno(paula, eda).
    aluno(quirino, eda).
    aluno(raissa, eda).
    aluno(santiago, eda).
    aluno(thiago, eda).
    aluno(viviane, eda).
    aluno(xena, eda).
    aluno(zuleide, eda).
    aluno(ana, teie).
    aluno(evandro, teie).
    aluno(isis, teie).
    aluno(olavo, teie).
    aluno(ulisses, teie).
    aluno(viviane, teie).
    aluno(wilson, teie).
    aluno(xena, teie).
    aluno(yuri, teie).
    aluno(zuleide, teie).
    aluno(ana, tebd).
    aluno(brenda, tebd).
    aluno(camila, tebd).
    aluno(graziela, tebd).
    aluno(helena, tebd).
    aluno(isis, tebd).
    aluno(kelvin, tebd).
    aluno(wilson, tebd).
    aluno(yuri, tebd).
    obrigatoria(plp).
    obrigatoria(eda).
    eletiva(teie).
    eletiva(tebd).
    leciona(janderson, plp).
    leciona(janderson, eda).
    leciona(marta, teie).
    leciona(keila, tebd).
    
    professor(X, Y) :- leciona(X, Z), aluno(Y, Z).
    disciplinas_obrigatorias(Disciplina) :- obrigatoria(Disciplina).
    alunos_de_janderson(Aluno) :- leciona(janderson, Disciplina), aluno(Aluno, Disciplina).
    professores_disciplinas_eletivas(Professor) :- eletiva(Disciplina), leciona(Professor, Disciplina).