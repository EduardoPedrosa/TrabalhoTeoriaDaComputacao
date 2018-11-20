import java.util.ArrayList;

public class Maquina{
    private ArrayList<Transicao> transicoes;
    private String fita;
    private ArrayList<String> estados;
    private ArrayList<String> alfabetoEntrada;
    private ArrayList<String> alfabetoFita;
    private String estadoInicial;
    private int posCabecaLeitura;

    public Maquina(){
        transicoes = new ArrayList<Transicao>();
        estados = new ArrayList<String>();
        alfabetoEntrada = new ArrayList<String>();
        alfabetoFita = new ArrayList<String>();
        posCabecaLeitura = 0;
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

    public void setFita(String entrada) {
        fita = entrada;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public void executar(){ //roda a execução das transições na entrada
        String estado = estadoInicial;
        String simbolo = "B";
        imprimeConfiguracao(estadoInicial);//configuracao inicial
        while(procurarTransicao(estado, simbolo) != null){
            String proxEstado = encontrarProxEstado(estado, simbolo); //execucao de transicao e busca de proximo estado
            if((posCabecaLeitura == fita.length()) || (fita.charAt(fita.length()-1) != 'B')){  //adicionando um B no final caso a cabeça de leitura 
                                                                                               //va alem da fita ou caso o ultimo elemento seja trocado por 1
                fita += "B";
            }
            imprimeConfiguracao(proxEstado);//imprimindo configuração
            
            //atualizando valores de estado e simbolo atuais
            estado = proxEstado; //novo estado
            
            simbolo = Character.toString(fita.charAt(posCabecaLeitura)); //simbolo agora eh o que a cabeca de leitura esta lendo
        }
    }

    public void imprimeConfiguracao(String estado){ //imprime configuracao com estado e fita na maquina de turing
        String ladoEsquerdo = fita.substring(0, posCabecaLeitura);
        String ladoDireito = fita.substring(posCabecaLeitura, fita.length());
        System.out.println(ladoEsquerdo + "{" + estado + "}" + ladoDireito);
    }

    public Transicao procurarTransicao(String estado, String simbolo){
        for(Transicao t : transicoes){
            if((estado.equals(t.getEstado()) && (simbolo.equals(t.getSimbolo())))){
                return t;
            }
        }
        return null;
    }
    
    public String encontrarProxEstado(String estadoAtual, String simbolo){ //executa uma transicao e retorna o proximo estado
        Transicao t = procurarTransicao(estadoAtual, simbolo);
        
        //modificando o simbolo atual na fita
        String palavraLadoEsquerdo; //lado esquerdo da cabeca de leitura
        String palavraLadoDireito; //lado direito da cabeca de leitura
        palavraLadoEsquerdo = fita.substring(0, posCabecaLeitura);
        palavraLadoDireito = fita.substring(posCabecaLeitura+1, fita.length());

        fita = palavraLadoEsquerdo + (t.getProxSimbolo()) + palavraLadoDireito; //nova configuracao da fita
        if(t.getDirecao().equals("R")) { //movendo cabeca de leitura
            ++posCabecaLeitura;
        } else if (t.getDirecao().equals("L")){
            --posCabecaLeitura;
        }
        return t.getProxEstado();
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