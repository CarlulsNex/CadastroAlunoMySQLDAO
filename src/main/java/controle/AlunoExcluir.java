package controle;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Aluno;
public class AlunoExcluir extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
                try ( PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html><html><head><title>Cadastro de Aluno - Excluir</title></head><body>");
                out.println("<h1>Cadastro de Aluno - Excluir</h1>");
                Aluno objetoaluno = new Aluno();
                int id = Integer.parseInt(request.getParameter("id"));
                if (objetoaluno.deleteAlunoBD(id)) {
                out.print("<span class='mensagemExcluir'>Exclus&atilde;o realizada com sucesso.</span><br>");
                } else {
                out.print("<span class='mensagemExcluir'>Exclus&atilde;o n&atilde;o realizada.</span><br>");
                }
                out.print("<br><a href=\"" + request.getContextPath() + "/FrmGerenciarAluno.jsp\"> Excluir </a>");
                out.print("<a href=\"" + request.getContextPath() + "/index.jsp\"> Menu </a><br>");
                out.println("</body></html>");
            }
        } catch (IOException e) {
        System.out.println("Problema E/S :" + e.toString());
        }
    }
}
