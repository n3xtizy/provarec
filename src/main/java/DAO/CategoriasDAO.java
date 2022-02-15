package DAO;

import Models.Categorias;
import java.sql.*;
import java.util.ArrayList;

public class CategoriasDAO {
    private Connection connection;

    public void criaTabela(){

        String sql = "CREATE TABLE IF NOT EXISTS tbCategorias ("+
                "idCategoria INT PRIMARY KEY AUTO_INCREMENT," +
                "idEmpresa INT NOT NULL" +
                "nmCategoria VARCHAR(50) NOT NULL" + ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Categoria criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void postCategoria(Categorias obj){

        String sql = "INSERT INTO tbCategorias" +
                " ( nmCategorias ) " +
                "VALUES (?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, obj.getNmCategoria());
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                obj.setIdEmpresa(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Categorias getCategoriasById (int id) {

        try {

            ArrayList<Categorias> Categorias = getCategorias();
            Categorias cat = new Categorias();

            for (Categorias it : Categorias){
                if (it.getIdEmpresa() == id){
                    cat = it;
                }
            }

            return cat;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Categorias> getCategorias() {

        String sql = "SELECT bl.* FROM tbCategorias bl";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            ArrayList<Categorias> categorias = new ArrayList<>();
            Categorias categoria;

            while (resultSet.next()) {
                categoria = new Categorias();
                categoria.setNmCategoria(resultSet.getString("nmCategoria"));
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));

                categorias.add(categoria);
            }

            return categorias;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void put(Categorias obj){
        String sql = "UPDATE tbCategorias SET nmCategorias = ? WHERE idCategorias= ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, obj.getNmCategoria());
            stmt.setInt(2, obj.getIdCategoria());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
