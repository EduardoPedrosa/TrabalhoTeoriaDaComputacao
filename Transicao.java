public class Transicao{
    private String estado;
    private String simbolo;
    private String proxEstado;
    private String proxSimbolo;
    private String direcao;

    public Transicao(String estado, String simbolo, String proxEstado, String proxSimbolo, String direcao){
        this.estado = estado;
        this.simbolo = simbolo;
        this.proxEstado = proxEstado;
        this.proxSimbolo = proxSimbolo;
        this.direcao = direcao;
    }

    public String getEstado() {
        return estado;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getProxEstado() {
        return proxEstado;
    }

    public String getProxSimbolo() {
        return proxSimbolo;
    }

    public String getDirecao() {
        return direcao;
    }
    
    
}