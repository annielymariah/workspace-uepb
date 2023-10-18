const data = require('./data.json');

 let somatoria = {
     buscaLinear_iterativa: 0,
     buscaLinear_recursiva: 0,
     buscaLinear_iterativa2: 0,
     buscaBinaria_iterativa: 0,
     buscaBinaria_recursiva: 0,
     menorIndex: data[0].index,
     maiorIndex: data[0].index
 };

 data.forEach(data =>  {
     somatoria.buscaLinear_iterativa = somatoria.buscaLinear_iterativa + data.buscaLinear_iterativa
     somatoria.buscaLinear_recursiva = somatoria.buscaLinear_recursiva + data.buscaLinear_recursiva
     somatoria.buscaLinear_iterativa2 = somatoria.buscaLinear_iterativa2 + data.buscaLinear_iterativa2
     somatoria.buscaBinaria_iterativa = somatoria.buscaBinaria_iterativa + data.buscaBinaria_iterativa
     somatoria.buscaBinaria_recursiva = somatoria.buscaBinaria_recursiva + data.buscaBinaria_recursiva
     if (somatoria.menorIndex > data.index){
        somatoria.menorIndex = data.index;
     }
     if (somatoria.maiorIndex < data.index){
        somatoria.maiorIndex = data.index
     }
 });

 let media = {
     buscaLinear_iterativa: somatoria.buscaLinear_iterativa / data.length,
     buscaLinear_recursiva: somatoria.buscaLinear_recursiva / data.length,
     buscaLinear_iterativa2: somatoria.buscaLinear_iterativa2 / data.length,
     buscaBinaria_iterativa: somatoria.buscaBinaria_iterativa / data.length,
     buscaBinaria_recursiva: somatoria.buscaBinaria_recursiva / data.length,
     menor_index: somatoria.menorIndex,
     maior_index: somatoria.maiorIndex
 };

console.log("Quantidade de testes:", data.length)

console.log("\nMÉDIAS DOS MÉTODOS DE BUSCAS\n")

console.log("Busca linear iterativa:", media.buscaLinear_iterativa)
console.log("Busca linear recursiva:", media.buscaLinear_recursiva)
console.log("Busca linear iterativa 2:", media.buscaLinear_iterativa2)
console.log("Busca binária iterativa:", media.buscaBinaria_iterativa)
console.log("Busca binária recursiva:", media.buscaBinaria_recursiva)

console.log("\nMENOR E MAIOR INDICE DE QUEBRA\n")

console.log("Menor valor buscado:", media.menor_index)
console.log("Menor valor buscado:", media.maior_index)