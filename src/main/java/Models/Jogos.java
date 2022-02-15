package Models;

public class Jogos {
    private int idJogo;
    private int idCategoria;
    private String nmJogo;
    private String dsInfo;

    public Jogos(String dsInfo) {
        this.dsInfo = dsInfo;
    }

    public Jogos(int idCategoria, String nmJogo) {
        this.idCategoria = idCategoria;
        this.nmJogo = nmJogo;
    }

    public int getIdJogos() {
        return idJogo;
    }

    public Jogos(){

    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNmJogo() {
        return nmJogo;
    }

    public void setNmJogo(String nmJogo) {
        this.nmJogo = nmJogo;
    }

    public String getDsInfo() {
        return dsInfo;
    }

    public void setDsInfo(String dsInfo) {
        this.dsInfo = dsInfo;
    }
}
