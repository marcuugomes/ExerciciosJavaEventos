package Exercicio5_Folha_8;

public abstract class Aluno {

    private String nome;
    private int nMec;
    private TipoAvaliacao avaliacao;

    public Aluno (String nome, int nMec) {
        this.nome = nome;
        this.nMec = nMec;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnMec() {
        return nMec;
    }

    public void setnMec(int nMec) {
        this.nMec = nMec;
    }

    public abstract TipoAvaliacao getAvaliacao();

    public String infoAluno (){
        return "Nome : "+this.nome +" Número Mecanográfico: " + this.nMec + " Tipo de avaliação: " + this.getAvaliacao().porExtenso();
    }


}
