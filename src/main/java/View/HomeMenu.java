package View;

import java.util.Scanner;
import Controller.EmpresasController;
import Controller.CategoriasController;
import Controller.JogosController;
import Models.Categorias;
import Models.Empresas;
import Models.Jogos;

public class HomeMenu {
    Scanner obj = new Scanner(System.in).useDelimiter("\n");
    HomeJogos HomeJogos = new HomeJogos();
    JogosController jog = new JogosController();
    EmpresasController emp = new EmpresasController();
    CategoriasController categor = new CategoriasController();
    public void homeMenu()  {
        System.out.println("\n");

        System.out.println("1.  Cadastrar Empresa");
        System.out.println("2.  Editar nome da Empresa");
        System.out.println("3.  Deletar Empresa");
        System.out.println("4.  Listar Empresas");
        System.out.println("5.  Cadastrar Categoria");
        System.out.println("6.  Listar Categoria");
        System.out.println("7.  Editar nome de uma Categoria");
        System.out.println("8.  Cadastrar Jogo");
        System.out.println("9.  Deletar Jogo");
        System.out.println("10. Editar Jogo");
        System.out.println("11. Listar Jogos");
        System.out.println("12. Sair");

        System.out.println("\n");

        switch (obj.nextInt()) {
            case 1:
                cadastrarEmpresa();
                break;

            case 2:
                editarEmpresa();
                break;

            case 3:
                deletarEmpresas();
                break;

            case 4:
                listarEmpresas();
                break;

            case 5:
                cadastrarCategoria();
                break;

            case 6:
                listarCategorias();
                break;

            case 7:
                editarCategoria();
                break;

            case 8:
                cadastrarJogos();
                break;

            case 9:
                deletarJogos();
                break;

            case 10:
                editarJogo();
                break;

            case 11:
                HomeJogos.homejogo();
                break;

            case 12:
                break;

            default:
                break;
        }
    }

    //---- Empresas

    public void cadastrarEmpresa() {

        System.out.println("Digite o nome da Empresa:");
        String nmEmpresa = obj.next();
        System.out.println("\n");
        var scan = new Empresas(nmEmpresa);
        homeMenu();
    }

    public void editarEmpresa() {
        System.out.println("Digite o ID da empresa:");
        String id = obj.next();
        System.out.println("\n");
        var empres = emp.getById(Integer.valueOf(id));
        if (empres != null) {
            System.out.println("Digite o novo nome da empresa:");
            String nmEmpres = obj.next();
            var req = new Empresas(empres.getIdEmpresa(), nmEmpres);
            emp.putEmpresas(req);
        }
        else {
            System.out.println("Empresa inexistente");
        }
        homeMenu();
    }

    public void deletarEmpresas() {
        System.out.println("Digite o id da Empresa:");
        String id = obj.next();
        System.out.println("\n");

        var obj = emp.getById(Integer.valueOf(id));
        emp.deleteEmpresa(obj);
        homeMenu();

    }

    public void listarEmpresas() {
        var obj = emp.get();
        if (obj != null) {
            for (Empresas it : obj){
                System.out.println(it.getIdEmpresa() + " " + "-" + " " + it.getNmEmpresa());
            }
        }
        homeMenu();
    }

    //---- Categoria

    public void cadastrarCategoria() {

        System.out.println("Digite o id da Empresa:");
        String idEmpresa = obj.next();
        System.out.println("\n");
        System.out.println("Digite o nome da Categoria:");
        String nmCategoria = obj.next();
        System.out.println("\n");
        var scan = new Categorias(Integer.parseInt(idEmpresa), nmCategoria);
        homeMenu();
    }

    public void editarCategoria() {
        System.out.println("Digite o ID da categoria:");
        String id = obj.next();
        System.out.println("\n");
        var categ = categor.getById(Integer.valueOf(id));
        if (categ != null) {
            System.out.println("Digite o novo nome da categoria:");
            String nmCategor = obj.next();
            var req = new Categorias(categ.getIdEmpresa(), nmCategor);
            categor.putCategorias(req);
        }
        else {
            System.out.println("Categoria inexistente");
        }
        homeMenu();
    }

    public void listarCategorias() {
        var obj = categor.get();
        if (obj != null) {
            for (Categorias it : obj){
                System.out.println(it.getIdCategoria() + " " + "-" + " " + it.getNmCategoria());
            }
        }
        homeMenu();
    }

    //---- Jogos

    public void cadastrarJogos() {

        System.out.println("Digite o id da Empresa:");
        String idEmpresa = obj.next();
        System.out.println("\n");
        System.out.println("Digite o id da Categoria:");
        String idCategoria = obj.next();
        System.out.println("\n");
        System.out.println("Digite o nome do Jogo:");
        String nmJogo = obj.next();
        System.out.println("\n");

        var scan = new Jogos(Integer.parseInt(idCategoria), nmJogo);
        homeMenu();
    }

    public void editarJogo() {
        System.out.println("Digite o ID da Jogo:");
        String id = obj.next();
        System.out.println("\n");
        var jug = jog.getById(Integer.valueOf(id));
        if (jug != null) {
            System.out.println("Digite o novo nome do Jogo:");
            String nmJog = obj.next();
            System.out.println("Digite as novas informaçoes do jogo:");
            String dsInfo = obj.next();
            var req = new Categorias(jug.getIdJogos(), nmJog);
            categor.putCategorias(req);
        }
        else {
            System.out.println("Categoria inexistente");
        }
        homeMenu();
    }

    public void deletarJogos() {
        System.out.println("Digite o id do jogo:");
        String id = obj.next();
        System.out.println("\n");

        var obj = emp.getById(Integer.valueOf(id));
        emp.deleteEmpresa(obj);

        homeMenu();
    }

}
