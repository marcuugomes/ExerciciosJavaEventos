package Exercicio5_Folha_8;

public class AlunoAvFinal extends Aluno implements avaliacaoFinal{

    public AlunoAvFinal(String nome, int nMec) {
        super(nome, nMec);
    }

    @Override
    public TipoAvaliacao getAvaliacao() {
        return TipoAvaliacao.AV_FINAL;
    }

    @Override
    public void obterNotaFinal() {

    }

    @Override
    public void setNotaExame() {

    }
}
