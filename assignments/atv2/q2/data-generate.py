import csv
import random

def gerar_notas():
    return random.randint(0, 10)

def gerar_turno():
    turnos = ["Diurno", "Noturno"]
    return random.choice(turnos)

num_registros = 100
nome_arquivo = "atv2\q2\database.csv"

cabecalho = ["Nota", "Turno"]

with open(nome_arquivo, mode='w', newline='') as arquivo_csv:
    writer = csv.writer(arquivo_csv, delimiter=';')
    
    writer.writerow(cabecalho)

    for i in range(num_registros):
        nota = gerar_notas()
        turno = gerar_turno()
        writer.writerow([nota, turno])
