calcularStatus :: Double -> Double -> Double -> String

calcularStatus frequencia nota1 nota2 = 
  let media = (nota1 + nota2) / 2
  in
    if frequencia < 75
      then "Reprovado por falta"
      else if media < 5
             then "Reprovado por nota"
             else if media >= 7
                    then "Aprovado por media"
                    else "Na final"

main :: IO ()
main = do
    let frequencia = 50
    let nota1 = 5
    let nota2 = 5

    putStrLn $ "Frequencia: " ++ show frequencia
    putStrLn $ "Primeira nota: " ++ show nota1
    putStrLn $ "Primeira nota: " ++ show nota2

    let status = calcularStatus frequencia nota1 nota2
    putStrLn $ "Status do aluno: " ++ status