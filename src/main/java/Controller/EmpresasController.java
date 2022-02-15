package Controller;

import DAO.EmpresasDAO;
import Models.Empresas;
import java.util.List;

public class EmpresasController {

    EmpresasDAO _bbus = new EmpresasDAO();

    public void criaTabela(){_bbus.criaTabela();}
    public void postEmpresa(Empresas obj){_bbus.postEmpresa(obj);}

    public Empresas getById(int id){
        return _bbus.getEmpresasById(id);
    }

    public void putEmpresas(Empresas obj){
        _bbus.put(obj);
    }

    public List<Empresas> get(){
        return _bbus.getEmpresas();
    }

    public void deleteEmpresa(Empresas obj){
        _bbus.delete(obj);
    }

}
