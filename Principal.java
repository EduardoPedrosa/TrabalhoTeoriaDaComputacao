import java.util.Scanner;

public class Principal{
    public static void main(String args[]){
        Scanner entrada = new Scanner(System.in);
        String lixo = entrada.nextLine(); //pulando a linha
        String estados = entrada.nextLine(); //pegando estados
        String alfabetoEntrada = entrada.nextLine(); //pegando alfabeto de entrada
        String alfabetoFita = entrada.nextLine(); //pegando alfabeto da fita
        lixo = entrada.nextLine(); //pulando a linha
        Maquina m = new Maquina();
        ManipulaString.insereEstados(estados,m);
        ManipulaString.insereAlfabetoEntrada(alfabetoEntrada, m);
        ManipulaString.insereAlfabetoFita(alfabetoFita,m);
        String transicao = entrada.nextLine();
        while(!transicao.equals("}")){
            ManipulaString.insereTransicao(transicao,m);
            transicao = entrada.nextLine();
            transicao = transicao.trim();
        }
        String estadoInicial = entrada.nextLine();
        ManipulaString.insereEstadoInicial(estadoInicial,m);
        lixo = entrada.nextLine();  //pulando a linha
        String fita = entrada.nextLine();
        m.setFita(fita);
        m.executar();
    }

}