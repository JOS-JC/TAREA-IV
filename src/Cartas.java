public class Cartas {
    private String valor; //El valor que tiene la carta
    private String simbolo; //El simbolo de la carta

    //metodo contructor siempre va a tener el mismo nombre que su clase
    public Cartas(String valor, String simbolo){
        this.valor = valor;
        this.simbolo = simbolo;
    }

    public String getValor(){
        return valor;
    }

    public String getSimbolo(){
        return simbolo;
    }

    public int getValorNumerico(){
            switch (valor) {
                case "As":
                    return 11;
                case "J":
                case "Q":
                case "K":
                    return 10;
                default:
                    return Integer.parseInt(valor);
        }
    }
    @Override
    public String toString(){
        return simbolo + " de " + valor;
    }
}
