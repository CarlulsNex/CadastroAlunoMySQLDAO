/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jordan
 */
import java.util.ArrayList;
import dao.AlunoDAO; // CORREÇÃO: AlunoDAO (Maiúsculo)

// CORREÇÃO: Classe Aluno (Maiúsculo)
public class Aluno extends Pessoa {
    private String curso;
    private int fase;
    private AlunoDAO dao; // CORREÇÃO: AlunoDAO (Maiúsculo)
    
    // Construtor de Objeto Vazio
    public Aluno() {
        this(0,"",0,"",0);
    }
    
    // Construtor com parâmetro
    public Aluno(int id,String nome, int
        idade,String curso, int fase ) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
        dao = new AlunoDAO(); // CORREÇÃO: AlunoDAO (Maiúsculo)
    }
    
    // Métodos GET e SET
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public int getFase() {
        return fase;
    }
    public void setFase(int fase) {
        this.fase = fase;
    }
    
    @Override
    public String toString() {
        return super.toString() + "curso=" + curso
        + ", fase=" + fase;
    }
    
    // Retorna a Lista de Alunos(objetos)
    public ArrayList<Aluno> getMinhaLista() { // CORREÇÃO: ArrayList<Aluno>
        return dao.getMinhaLista();
    }
    
    // Cadastra novo aluno
    public boolean insertAlunoBD(String nome, 
    int idade, String curso, int fase) {
        int id = this.maiorID() + 1;
        Aluno objeto = new Aluno(id, nome, // CORREÇÃO: Aluno (Maiúsculo)
         idade, curso, fase);
        dao.insertAlunoBD(objeto);
        return true;
    }
    
    // Deleta um aluno específico pelo seu campo ID
    public boolean deleteAlunoBD(int id) {
        dao.deleteAlunoBD(id);
        return true;
    }
    
    // Edita um aluno específico pelo seu campo ID
    public boolean updateAlunoBD(int id, String nome,
        int idade, String curso, int fase)
    {
        Aluno objeto = new Aluno(id, nome, idade, curso, fase ); // CORREÇÃO: Aluno (Maiúsculo)
        dao.updateAlunoBD(objeto);
        return true;
    }
    
    // Carrega dados de um aluno especÍfico pelo seu ID
    public Aluno carregaAluno(int id) { // CORREÇÃO: Aluno (Maiúsculo)
        return dao.carregaAluno(id);
    }
    
    // retorna o maior ID da nossa base de dados
    public int maiorID(){
        return dao.maiorID();
    }
}