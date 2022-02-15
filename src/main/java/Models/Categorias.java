package Models;

public class Categorias {
    private int idCategoria;
    private int idEmpresa;
    private String nmCategoria;

    public Categorias(int idEmpresa, String nmCategoria) {
        this.idEmpresa = idEmpresa;
        this.nmCategoria = nmCategoria;
    }

    public Categorias(){

    }

    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNmCategoria() {
        return nmCategoria;
    }

    public void setNmCategoria(String nmCategoria) {
        this.nmCategoria = nmCategoria;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
