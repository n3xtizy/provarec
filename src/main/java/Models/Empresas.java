package Models;

public class Empresas {
    private int idEmpresa;
    private String nmEmpresa;

    public Empresas(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }

    public int getIdEmpresas() {
        return idEmpresa;
    }

    public Empresas(){

    }

    public Empresas(int idEmpresa, String nmEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nmEmpresa = nmEmpresa;
    }

    public String getNmEmpresa() {
        return nmEmpresa;
    }

    public void setNmEmpresa(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


}
