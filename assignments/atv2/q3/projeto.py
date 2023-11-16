import sqlite3


def criarTabelaDisciplinas():
    conn = sqlite3.connect('aluno.db')
    cursor = conn.cursor()
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS disciplinas (
            id INTEGER PRIMARY KEY,
            nome TEXT,
            nota1 REAL,
            nota2 REAL
        )
    ''')
    conn.commit()
    conn.close()


def CadastrarDisciplina():
    nome = input("Digite o nome da disciplina: ")
    nota1 = float(input("Digite a nota da 1a unidade: "))
    nota2 = float(input("Digite a nota da 2a unidade: "))

    conn = sqlite3.connect('aluno.db')
    cursor = conn.cursor()
    cursor.execute(
        'INSERT INTO disciplinas (nome, nota1, nota2) VALUES (?, ?, ?)', (nome, nota1, nota2))
    conn.commit()
    conn.close()


def listarDisciplinas():
    conn = sqlite3.connect('aluno.db')
    cursor = conn.cursor()
    cursor.execute('SELECT id, nome, nota1, nota2 FROM disciplinas')
    disciplinas = cursor.fetchall()
    conn.close()

    if not disciplinas:
        print("Nenhuma disciplina cadastrada.")
    else:
        for disciplina in disciplinas:
            id, nome, nota1, nota2 = disciplina
            media = (nota1 + nota2) / 2
            status = "Aprovado" if media >= 7.0 else "Reprovado"
            calc = 6*media
            pf = round((50 - calc)/4, 2)
            if media < 7.0:
                status = f"Precisando de {pf} na final"
            print(
                f"ID: {id}, Nome: {nome}, Nota 1: {nota1}, Nota 2: {nota2}, Média: {media}, Status: {status}")


def atualizarDisciplina():
    listarDisciplinas()
    id_disciplina = int(
        input("Digite o ID da disciplina que deseja atualizar: "))

    conn = sqlite3.connect('aluno.db')
    cursor = conn.cursor()
    cursor.execute(
        'SELECT nome, nota1, nota2 FROM disciplinas WHERE id = ?', (id_disciplina,))
    disciplina = cursor.fetchone()
    conn.close()

    if not disciplina:
        print("Disciplina não encontrada.")
        return

    nome, nota1, nota2 = disciplina
    print(
        f"Disciplina encontrada: Nome: {nome}, Nota 1: {nota1}, Nota 2: {nota2}")

    novo_nome = input(
        "Digite o novo nome da disciplina (ou pressione Enter para manter o mesmo): ")
    novo_nota1 = input(
        "Digite a nova nota da 1a unidade (ou pressione Enter para manter a mesma): ")
    novo_nota2 = input(
        "Digite a nova nota da 2a unidade (ou pressione Enter para manter a mesma): ")

    if not novo_nome:
        novo_nome = nome
    if not novo_nota1:
        novo_nota1 = nota1
    if not novo_nota2:
        novo_nota2 = nota2

    conn = sqlite3.connect('aluno.db')
    cursor = conn.cursor()
    cursor.execute('''
        UPDATE disciplinas
        SET nome = ?, nota1 = ?, nota2 = ?
        WHERE id = ?
    ''', (novo_nome, novo_nota1, novo_nota2, id_disciplina))
    conn.commit()
    conn.close()


def removerDisciplina():
    listarDisciplinas()
    id_disciplina = int(
        input("Digite o ID da disciplina que deseja remover: "))

    conn = sqlite3.connect('aluno.db')
    cursor = conn.cursor()
    cursor.execute('DELETE FROM disciplinas WHERE id = ?', (id_disciplina,))
    conn.commit()
    conn.close()


def removerTodasDisciplinas():
    confirmacao = input(
        "Tem certeza que deseja remover todas as disciplinas? (S/N) ")
    if confirmacao.lower() == 's':
        conn = sqlite3.connect('aluno.db')
        cursor = conn.cursor()
        cursor.execute('DELETE FROM disciplinas')
        conn.commit()
        conn.close()
        print("Todas as disciplinas foram removidas.")
    else:
        print("Operação cancelada.")


def menu():
    criarTabelaDisciplinas()
    while True:
        print("\n---Cadastro de notas de Alunos---")
        print("1. Cadastrar nova disciplina")
        print("2. Listar situação nas disciplinas")
        print("3. Atualizar disciplina")
        print("4. Remover disciplina")
        print("5. Remover todas as disciplinas")
        print("6. Sair")
        opcao = input("Escolha uma opção: ")

        if opcao == '1':
            CadastrarDisciplina()
        elif opcao == '2':
            listarDisciplinas()
        elif opcao == '3':
            atualizarDisciplina()
        elif opcao == '4':
            removerDisciplina()
        elif opcao == '5':
            removerTodasDisciplinas()
        elif opcao == '6':
            print("Saindo da aplicação.")
            break
        else:
            print("Opção inválida. Tente novamente.")


if __name__ == "__main__":
    menu()
