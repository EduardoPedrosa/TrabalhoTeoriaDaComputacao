import java.util.ArrayList;

public class Maquina{
    private ArrayList<Transicao> transicoes;
    private String fita;
    private ArrayList<String> estados;
    private ArrayList<String> alfabetoEntrada;
    private ArrayList<String> alfabetoFita;
    private String estadoInicial;
    
    public Maquina(){
        transicoes = new ArrayList<Transicao>();
        estados = new ArrayList<String>();
        alfabetoEntrada = new ArrayList<String>();
        alfabetoFita = new ArrayList<String>();
    }

    public void adicionarTransicao(Transicao t){
        transicoes.add(t);
    }
    
    public void adicionarEstado(String s){
        estados.add(s);
    }
    
    public void adicionarAlfabetoEntrada(String s){
        alfabetoEntrada.add(s);
    }
    
    public void adicionarAlfabetoFita(String s){
        alfabetoFita.add(s);
    }

    public void setFita(String fita) {
        this.fita = fita;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }
    
    public Transicao procurarTransicao(String estado, String simbolo){
        for(Transicao t : transicoes){
            if((estado.equals(t.getEstado()) && (simbolo.equals(t.getSimbolo())))){
                return t;
            }
        }
        return null;
    }
    
    public void escreverMaquina(){  //para debugar
        System.out.println("(");
        System.out.print("{");
        for(String s : estados){
            System.out.print(s + ",");
        }
        System.out.println("}");
        System.out.print("{");
        for(String s : alfabetoEntrada){
            System.out.print(s + ",");
        }
        System.out.println("}");
        System.out.print("{");
        for(String s : alfabetoFita){
            System.out.print(s + ",");
        }
        System.out.println("}");
        System.out.println("{");
        for(Transicao t : transicoes){
            System.out.println("("+ t.getEstado() +", " + t.getSimbolo() + ") -> (" +
                    t.getProxEstado() + ", " + t.getProxSimbolo() + ", " + t.getDirecao() + ")");
        }
        System.out.println("}");
        System.out.println("{" + estadoInicial + "}");
        System.out.println(")");
        System.out.println(fita);
    }
}