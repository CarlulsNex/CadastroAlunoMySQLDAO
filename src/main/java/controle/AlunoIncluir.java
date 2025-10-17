package controle;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import modelo.Aluno;

// Atenção: Use jakarta.servlet em projetos mais recentes (Tomcat 10+)
// Se você está usando javax.servlet (Tomcat 9 ou anterior), mude a importação de volta.
public class AlunoIncluir extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html><html><head><title>Cadastro de Aluno - Incluir</title></head><body>");
                out.println("<h1>Cadastro de Aluno - Incluir</h1>");

                String nome = request.getParameter("nome");
                int idade = Integer.parseInt(request.getParameter("idade"));
                String curso = request.getParameter("curso");
                int fase = Integer.parseInt(request.getParameter("fase"));

                Aluno objetoaluno = new Aluno();

                if (objetoaluno.insertAlunoBD(nome, idade, curso, fase)) {
                    out.print("<span class='mensagemIncluir'>Inclus&atilde;o realizada com sucesso.</span><br>");
                } else {
                    out.print("<span class='mensagemIncluir'>Inclus&atilde;o n&atilde;o realizada.</span><br>");
                }

                // Linha corrigida para concatenar corretamente o caminho
                out.print("<br><a href=\"" + request.getContextPath() + "/FrmCadastroAluno.jsp\"> Incluir </a> ");
                out.print("<a href=\"" + request.getContextPath() + "/index.jsp\"> Menu </a> <br>");
                out.println("</body></html>");
            }
        } catch (IOException e) {
            System.out.println("Problema E/S: " + e.toString());
        } catch (NumberFormatException e) {
            // Adicionado tratamento de erro para os parseInt
             System.out.println("Problema de Formato de Número: " + e.toString());
        }
    }
}