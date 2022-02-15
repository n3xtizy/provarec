package DAO;

import Models.Jogos;
import java.sql.*;
import java.util.ArrayList;

public class JogosDAO {
    private Connection connection;

    public void criaTabela(){

        String sql = "CREATE TABLE IF NOT EXISTS tbJogos ("+
                "idJogos INT PRIMARY KEY AUTO_INCREMENT," +
                "nmJogos VARCHAR(50) NOT NULL" + ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Jogos criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void postJogos(Jogos obj){

        String sql = "INSERT INTO tbJogos" +
                " ( nmJogos ) " +
                "VALUES (?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, obj.getNmJogo());
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                obj.setIdJogo(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Jogos getJogosById (int id) {

        try {

            ArrayList<Jogos> Jogos = getJogos();
            Jogos jo = new Jogos();

            for (Jogos it : Jogos){
                if (it.getIdJogo() == id){
                    jo = it;
                }
            }

            return jo;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Jogos> getJogos() {

        String sql = "SELECT bl.* FROM tbJogos bl";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            ArrayList<Jogos> jogos = new ArrayList<>();
            Jogos jogo;

            while (resultSet.next()) {
                jogo = new Jogos();
                jogo.setNmJogo(resultSet.getString("nmEmpresas"));
                jogo.setIdJogo(resultSet.getInt("idEmpresas"));

                jogos.add(jogo);
            }

            return jogos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void put(Jogos obj){
        String sql = "UPDATE tbJogos SET nmJogos = ? WHERE idJogos = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, obj.getNmJogo());
            stmt.setInt(2, obj.getIdJogo());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Jogos obj){
        String sql = "DELETE FROM tbJogos WHERE idJogos = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, obj.getIdJogos());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Jogos> getJogosByIdCategoria (int id) {

        try {

            ArrayList<Jogos> Jogos = getJogos();
            ArrayList<Jogos> jo = new ArrayList<Jogos>();

            for (Jogos it : Jogos){
                if (it.getIdCategoria() == id){
                    jo.add(it);
                }
            }

            return jo;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
