notas_eda <- read.csv("atv2\\q2\\database.csv", sep = ";")
summary(notas_eda)

notas <- notas_eda$Nota
notas_diurno <- notas_eda$Nota[notas_eda$Turno == "Diurno"]
notas_noturno <- notas_eda$Nota[notas_eda$Turno == "Noturno"]

cat("Média Geral:", mean(notas), "\n")
cat("Média Diurno:", mean(notas_diurno), "\n")
cat("Média Noturno:", mean(notas_noturno), "\n")

cat("Mediana Geral:", median(notas), "\n")
cat("Mediana Diurno:", median(notas_diurno), "\n")
cat("Mediana Noturno:", median(notas_noturno), "\n")

par(mfrow = c(2, 3))

hist_geral <- hist(notas, breaks = 10, col = "blue", xlim = c(0, 10), main = "Histograma Geral")
hist_diurno <- hist(notas_diurno, breaks = 10, col = "red", xlim = c(0, 10), main = "Histograma Diurno")
hist_noturno <- hist(notas_noturno, breaks = 10, col = "green", xlim = c(0, 10), main = "Histograma Noturno")
boxplot_geral <- boxplot(notas, col = "blue", ylim = c(0, 10), main = "Boxplot Geral")
boxplot_diurno <- boxplot(notas_diurno, col = "red", ylim = c(0, 10), main = "Boxplot Diurno")
boxplot_noturno <- boxplot(notas_noturno, col = "green", ylim = c(0, 10), main = "Boxplot Noturno")

par(mfrow = c(1, 1)) 

t.test(notas_diurno, notas_noturno)