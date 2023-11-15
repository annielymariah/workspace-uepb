def quicksort(xs):
    if not xs:
        return []
    else:
        x, *rest = xs
        smaller_sorted = quicksort([a for a in rest if a <= x])
        bigger_sorted = quicksort([a for a in rest if a > x])
        return bigger_sorted + [x] + smaller_sorted

def quicksort_pares_decrescente(xs):
    numeros_pares = list(filter(lambda x: x % 2 == 0, xs))
    return quicksort(numeros_pares)
lista_original = [9, 1, 8, 2, 5, 7, 3, 6, 4]
lista_ordenada = quicksort_pares_decrescente(lista_original)
print(f"Lista original: {lista_original}")
print(f"Lista ordenada de pares decrescente: {lista_ordenada}")
