package Exercicio5_Folha_8;

public class AlunoAvDis extends Aluno implements avaliacaoDiscreta{

    public AlunoAvDis(String nome, int nMec) {
        super(nome, nMec);
    }

    @Override
    public TipoAvaliacao getAvaliacao() {
        return TipoAvaliacao.AV_DISCRETA;
    }

    @Override
    public void obterNotaFinal() {

    }

    @Override
    public void setTeste1() {

    }

    @Override
    public void setTeste2() {

    }
}
