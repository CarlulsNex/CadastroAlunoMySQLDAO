<%-- 
    Document  : FrmCadastroAluno
    Created on : 17 de out. de 2025, 18:30:14
    Author     : Jordan
--%>

<%@page import="modelo.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Aluno</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <script src="biblioteca.js"></script>
    </head>
    <body>
    <h1>Dados de Aluno</h1>
        <%
        Aluno objAluno = null;
        Aluno objetoaluno = new Aluno();
        
        if (request.getParameter("id") != null) {
        //Recupero o objeto
       
        objAluno = objetoaluno.carregaAluno(Integer.parseInt(request.getParameter("id")));
        %>
        <form name="FrmCadastroAluno" method="post" action="servlet/AlunoAlterar">
        <%
        } else { %>
        <form name="FrmCadastroAluno" method="post" action="servlet/AlunoIncluir">
        <% }%>
        <input type=hidden name="id" value="<%=request.getParameter("id")%>">
                Nome: <input type=text name="nome" value="<%=objAluno != null 
                                ? objAluno.getNome() : ""%>" size=50 maxlength=100><br><br>
                Idade: <input type=text name="idade" value="<%=objAluno != null 
                                ? objAluno.getIdade() : ""%>" size=10 maxlength=10> <br><br>
                Curso: <input type=text name="curso" value="<%=objAluno != null 
                                ? objAluno.getCurso() : ""%>" size=25 maxlength=50> <br><br>
                Fase: <input type=text name="fase" value="<%=objAluno != null 
                                ? objAluno.getFase() : ""%>" size=10 maxlength=15> <br><br>
                <input type="reset" value="Limpar">
            <input type="submit" name="Cadastrar" value="Cadastrar" 
                            onClick="return validar(this.form); "> <br>
        </form>
        <br>
        <a href='index.jsp'>Voltar ao menu</a>
    </body>
</html>