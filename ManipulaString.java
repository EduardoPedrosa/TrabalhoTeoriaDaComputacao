public class ManipulaString{  //tira simbolos de { } e possiveis espacos desnecessarios e chama as funcoes da maquina recebida por parametro
    public static void insereEstados(String e, Maquina m){ 
        e = e.replace("{", "");  
        e = e.replace("},", "");  
        String estados[] = e.split(",");  
        for(String s : estados){
            m.adicionarEstado(s.trim());
        }
    }
    
    public static void insereAlfabetoEntrada(String a, Maquina m){
        a = a.replace("{", "");
        a = a.replace("},", "");
        String alfabeto[] = a.split(",");
        for(String s : alfabeto){
            m.adicionarAlfabetoEntrada(s.trim());
        }
    }
    
    public static void insereAlfabetoFita(String a, Maquina m){
        a = a.replace("{", "");
        a = a.replace("},", "");
        String alfabeto[] = a.split(",");
        for(String s : alfabeto){
            m.adicionarAlfabetoFita(s.trim());
        }
    }
    public static void insereTransicao(String t, Maquina m){
        t = t.replace("->", ",");
        t = t.replace("(","");
        t = t.replace(")", "");
        String transicao[] = t.split(",");
        Transicao novaTransicao = new Transicao(transicao[0].trim(),transicao[1].trim(),transicao[2].trim(),transicao[3].trim(),transicao[4].trim());
        m.adicionarTransicao(novaTransicao);
    }
    
    public static void insereEstadoInicial(String s, Maquina m){
        s = s.replace("{", "");
        s = s.replace("}", "");
        m.setEstadoInicial(s.trim());
    }
}