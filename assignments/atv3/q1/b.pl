import org.jpl7.*;
import javax.swing.*;
import java.util.Map;
public class App {
    public static void main(String[] args) {
        Query q1 = new Query("consult", new Term[]{new Atom("D:\\teste.pl")});
        System.out.println("consult " + (q1.hasSolution() ? "succeeded" : "failed"));
        // Pedir o nome do aluno ao usuário
        String alunoNome = JOptionPane.showInputDialog("Nome do aluno?");
        // Consultar os professores do aluno
        Query q2 = new Query("professor(Professor, " + alunoNome + ")");
        Map<String, Term>[] solution = q2.allSolutions();
        // Exibir os resultados
        if (solution != null) {
            if (solution.length > 0) {
                System.out.println("Professores do aluno " + alunoNome + ":");
                for (Map<String, Term> map : solution) {
                    System.out.println("- " + map.get("Professor"));
                }
            } else {
                System.out.println("Não foram encontrados professores para o aluno " + alunoNome + ".");
            }
        } else {
            System.out.println("Erro na consulta.");
        }
    }
}