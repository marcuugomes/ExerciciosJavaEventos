package Exercicio5_Folha_8;

public enum TipoAvaliacao {
    AV_DISCRETA,
    AV_FINAL;

    public String porExtenso(){

        String aux;

        switch (this){

            case AV_FINAL:
                aux= "Avaliação Fiscreta";
                break;

            case AV_DISCRETA:
                aux= "Avaliação Final";
                break;

            default:
                 aux = "";
        }
            return aux;
    }
}
