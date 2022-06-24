package Exercicio5_Folha_8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Turma {
    private ArrayList<Aluno> alunos;

    public Turma() {
        this.alunos = new ArrayList<>();
    }

    // ADICIONAR ALUNO
    public void addAluno (String nome, int nMec, TipoAvaliacao avaliacao ){

        switch (avaliacao){

            case AV_DISCRETA:
                this.alunos.add(new AlunoAvDis(nome,nMec));
                break;

            case AV_FINAL:
                this.alunos.add(new AlunoAvFinal(nome,nMec));
                break;

            default:
                System.out.println("Impossível adicionar aluno");
        }
    }

    // LSITAR TODOS OS ALUNOS DA TURMA
    public void listAll (){

        for(int i=0;i<this.alunos.size();i++){

            System.out.println(this.alunos.get(i).infoAluno());
        }
    }

    // SELECIONAR ALUNOS CUJO NOME SEJA IGUAL AO CRITERIO
    public ArrayList<Aluno> selecionarPorNome (String criterio){

        ArrayList<Aluno> selecionados = new ArrayList<>();

        for(int i=0;i<this.alunos.size();i++){

            if(alunos.get(i).getNome().equals(criterio)){
                selecionados.add(alunos.get(i));
            }
        }
        return selecionados;
    }

    // SELECIONAR ALUNOS CUJO NUMERO MEC IGUAL AO CRITERIO
    public ArrayList<Aluno> selecionarPorNumero (int criterio){
        ArrayList<Aluno> selecionados = new ArrayList<>();

        for(int i=0;i<this.alunos.size();i++){

            if(alunos.get(i).getnMec()==criterio){
                selecionados.add(alunos.get(i));
            }
        }
        return selecionados;
    }

    // SELECIONAR ALUNOS CUJO TIPO DE AVALIACAO IGUAL AO CRITERIO
    public ArrayList<Aluno> selecionarPorAvaliacao (TipoAvaliacao criterio){

        ArrayList<Aluno> selecionados = new ArrayList<>();

        for(int i=0;i<this.alunos.size();i++){

            if(alunos.get(i).getAvaliacao().equals(criterio)){
                selecionados.add(alunos.get(i));
            }
        }
        return selecionados;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    // REMOVER POR NOME
    public void removerPorNome (String nome){
        Iterator<Aluno> it= alunos.iterator();

        while (it.hasNext()){
            Aluno aluno = it.next();
            if(aluno.getNome().contains(nome)){
                it.remove();
            }
        }
    }
    // REMOVER POR NUMERO MEC
    public void removerPorN (int n){

        for(int i=0;i<this.alunos.size();i++){
            if(alunos.get(i).getnMec()==n){
                alunos.remove(i);
            }
        }
    }


}
