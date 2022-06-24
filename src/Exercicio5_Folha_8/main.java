package Exercicio5_Folha_8;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String[] args) {


        Turma turma = geraAlunos(10);

        turma.listAll();

        GestorGUI gestorGUI=new GestorGUI();


    }

    private static Turma geraAlunos(int nAlunos) {
        Random r = new Random();

        String[] nomesProprios = {"Maria", "Ana", "Beatriz", "Matilde", "Leonor", "Sandra", "Carla", "Sónia", "Inês",
                "Catarina", "Mariana", "Sara", "Susana", "Paula", "Cláudia", "Patrícia", "Sílvia", "Andreia", "Joana",
                "Cátia", "Sara", "Tânia", "Liliana", "Daniela", "Diana", "Carolina", "Sofia", "Francisca", "João",
                "Tiago", "Diogo", "Martim", "Rodrigo", "Afonso", "Santiago", "Francisco", "José", "Nuno", "Pedro",
                "Paulo", "Rui", "Luís", "Carlos", "António", "Ricardo", "Bruno", "André", "Miguel", "Tomás", "Duarte",
                "Gabriel", "Eduardo", "Filipe", "Jorge", "Dinis", "Hugo"};
        String[] apelidos = {"Silva", "Santos", "Ferreira", "Pereira", "Oliveira", "Costa", "Rodrigues", "Martins",
                "Jesus", "Sousa", "Fernandes", "Gonçalves", "Gomes", "Lopes", "Marques", "Alves", "Almeida", "Ribeiro",
                "Pinto", "Carvalho", "Teixeira", "Moreira", "Correia", "Mendes", "Nunes", "Soares", "Vieira", "Monteiro",
                "Cardoso", "Rocha", "Raposo", "Neves", "Coelho", "Cruz", "Cunha", "Pires", "Ramos", "Reis", "Simões"};

        Turma alunos = new Turma();

        for (int i = 0; i < nAlunos; i++) {
            String nomeProprio = nomesProprios[r.nextInt(nomesProprios.length)];
            String apelido = apelidos[r.nextInt(apelidos.length)];

            int nmec = r.nextInt((99999 - 10000) + 1) + 10000;

            // escolher aleatoriamente o tipo de avaliacao, por exemplo algo como
            TipoAvaliacao ta = TipoAvaliacao.AV_FINAL;
            if (r.nextDouble() > 0.5) {
                ta = TipoAvaliacao.AV_DISCRETA;
            }

            // criar o aluno e adiciona-lo a uma turma ?
            alunos.addAluno(nomeProprio, nmec,ta);
        }
        return alunos;
    }

    // CRIAR METODO STATIC PARA ITERAR UM ARRAY LIST
    private static void printCol(ArrayList<Aluno> c) {

        for( int i=0;i<c.size();i++){
            System.out.println(c.get(i).infoAluno());
        }
    }
}
