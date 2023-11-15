def quicksort_pares_decrescente(lista):
    if len(lista) <= 1:
        return lista
    else:
        pivo = lista[0]
        menores = [x for x in lista[1:] if x % 2 == 0 and x >= pivo]
        maiores = [x for x in lista[1:] if x % 2 == 0 and x < pivo]
        return quicksort_pares_decrescente(menores) + [pivo] + quicksort_pares_decrescente(maiores)
lista = [9, 1, 8, 2, 5, 7, 3, 6, 4]
lista_pares = [x for x in lista if x % 2 == 0]
lista_ordenada = quicksort_pares_decrescente(lista_pares)
print("Lista original:", lista)
print("Lista ordenada (pares decrescente):", lista_ordenada)