package Controller;

import DAO.CategoriasDAO;
import Models.Categorias;

import java.util.List;

public class CategoriasController {

    CategoriasDAO _cat = new CategoriasDAO();

    public void criaTabela(){_cat.criaTabela();}
    public void postCategorias(Categorias obj){_cat.postCategoria(obj);}


    public void putCategorias(Categorias obj){
        _cat.put(obj);
    }

    public Categorias getById(int id){
        return _cat.getCategoriasById(id);
    }

    public List<Categorias> get(){
        return _cat.getCategorias();
    }
}
