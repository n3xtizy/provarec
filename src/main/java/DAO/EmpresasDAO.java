package DAO;

import Models.Empresas;
import java.sql.*;
import java.util.ArrayList;

public class EmpresasDAO {
    private Connection connection;

    public void criaTabela(){

        String sql = "CREATE TABLE IF NOT EXISTS tbBibliotecas ("+
                "idEmpresa INT PRIMARY KEY AUTO_INCREMENT," +
                "nmEmpresa VARCHAR(50) NOT NULL" + ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Empresas criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void postEmpresa(Empresas obj){

        String sql = "INSERT INTO tbEmpresas" +
                " ( nmEmpresa ) " +
                "VALUES (?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, obj.getNmEmpresa());
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                obj.setIdEmpresa(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Empresas getEmpresasById (int id) {

        try {

            ArrayList<Empresas> Empresas = getEmpresas();
            Empresas empr = new Empresas();

            for (Empresas it : Empresas){
                if (it.getIdEmpresa() == id){
                    empr = it;
                }
            }

            return empr;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Empresas> getEmpresas() {

        String sql = "SELECT bl.* FROM tbEmpresas bl";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            ArrayList<Empresas> empresas = new ArrayList<>();
            Empresas empresa;

            while (resultSet.next()) {
                empresa = new Empresas();
                empresa.setNmEmpresa(resultSet.getString("nmEmpresa"));
                empresa.setIdEmpresa(resultSet.getInt("idEmpresa"));

                empresas.add(empresa);
            }

            return empresas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void put(Empresas obj){
        String sql = "UPDATE tbEmpresas SET nmEmpresas = ? WHERE idEmpresas = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, obj.getNmEmpresa());
            stmt.setInt(2, obj.getIdEmpresa());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Empresas obj){
        String sql = "DELETE FROM tbEmpresas WHERE idEmpresa = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, obj.getIdEmpresa());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
