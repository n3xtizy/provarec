package Controller;

import DAO.JogosDAO;
import Models.Categorias;
import Models.Jogos;

import java.util.ArrayList;
import java.util.List;

public class JogosController {

    JogosDAO _jog = new JogosDAO();

    public void criaTabela(){_jog.criaTabela();}
    public void postJogos(Jogos obj){_jog.postJogos(obj);}

    public Jogos getById(int id){
        return _jog.getJogosById(id);
    }

    public void putJogos(Jogos obj){
        _jog.put(obj);
    }

    public List<Jogos> get(){
        return _jog.getJogos();
    }

    public void deleteJogos(Jogos obj){
        _jog.delete(obj);
    }

    public ArrayList<Jogos> getByIdBiblioteca (int id){
        return _jog.getJogosByIdCategoria(id);
    }

}
