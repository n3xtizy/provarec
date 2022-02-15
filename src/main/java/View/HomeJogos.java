package View;

import Controller.JogosController;
import Models.Jogos;
import java.util.Scanner;


public class HomeJogos {
    Scanner obj = new Scanner(System.in).useDelimiter("\n");

    JogosController juegos = new JogosController();

    public void homejogo(){

        System.out.println("1. Listar os jogos de uma determinada Categoria");
        System.out.println("2. Buscar lista de jogos");
        System.out.println("3. Sair");

        System.out.println("\n");

        switch (obj.nextInt()) {
            case 1:
                getJogosCategoria();
                break;

            case 2:
                BuscarPeloIdJogo();
                break;

            case 3:
                break;

            default:
                break;
            }
        }

    public void getJogosCategoria() {
        System.out.println("Digite o id da Categoria:");
        String id = obj.next();
        System.out.println("\n");
        var obj = juegos.getByIdBiblioteca(Integer.valueOf(id));
        if (obj != null) {
            for (Jogos it : obj){
                System.out.println(it.getIdJogos() + " " + "-" + " " + it.getNmJogo());
            }
        }
        homejogo();
    }

    public void BuscarPeloIdJogo() {
        System.out.println("Digite o ID do Jogo:");
        String id = obj.next();
        System.out.println("\n");
        var jueg = juegos.getById(Integer.valueOf(id));
        System.out.println(jueg.getIdJogos() + " " + "-" + " " + jueg.getNmJogo());

        homejogo();
    }

}



