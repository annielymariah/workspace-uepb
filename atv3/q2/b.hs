quicksort :: (Ord a) => [a] -> [a]
quicksort [] = []
quicksort (x:xs) =
    let smallerSorted = quicksort [a | a <- xs, a <= x]
        biggerSorted = quicksort [a | a <- xs, a > x]
    in biggerSorted ++ [x] ++ smallerSorted
quicksortParesDecrescente :: [Int] -> [Int]
quicksortParesDecrescente xs =
    let numerosPares = filter even xs
    in quicksort numerosPares

main :: IO ()
main = do

    let listaOriginal = [9, 1, 8, 2, 5, 7, 3, 6, 4]
        listaOrdenada = quicksortParesDecrescente listaOriginal
        
    putStrLn $ "Lista original: " ++ show listaOriginal
    putStrLn $ "Lista ordenada de pares decrescente: " ++ show listaOrdenada