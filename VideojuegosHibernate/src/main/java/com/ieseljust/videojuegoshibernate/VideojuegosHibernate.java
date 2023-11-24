package com.ieseljust.videojuegoshibernate;

import com.ieseljust.DAO.VideojuegoDAO;
import com.ieseljust.Model.Videojuego;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class VideojuegosHibernate {

    public static void main(String[] args) {
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();

        // Puedes agregar la inicialización de algunos datos de prueba aquí si es necesario

        int pageSize = 12;
        int currentPage = 1;
        int totalPages = getTotalPages(videojuegoDAO, pageSize);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-------- Menu --------");
            System.out.println("<S> next (Siguiente)");
            System.out.println("<A> previous (Anterior)");
            System.out.println("<G n> Go to n");
            System.out.println("<Q> exit (quit)");

            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                case "S":
                    if (currentPage < totalPages) {
                        currentPage++;
                        displayPage(videojuegoDAO, currentPage, pageSize);
                    } else {
                        System.out.println("Ya estás en la última página.");
                    }
                    break;
                case "A":
                    if (currentPage > 1) {
                        currentPage--;
                        displayPage(videojuegoDAO, currentPage, pageSize);
                    } else {
                        System.out.println("Ya estás en la primera página.");
                    }
                    break;
                case "Q":
                    System.out.println("Programa finalizado.");
                    System.exit(0);
                default:
                    if (userInput.startsWith("G ")) {
                        try {
                            int pageNumber = Integer.parseInt(userInput.substring(2).trim());
                            if (pageNumber >= 1 && pageNumber <= totalPages) {
                                currentPage = pageNumber;
                                displayPage(videojuegoDAO, currentPage, pageSize);
                            } else {
                                System.out.println("Número de página inválido.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Ingresa un número después de 'G'.");
                        }
                    } else {
                        System.out.println("Entrada no válida. Inténtalo de nuevo.");
                    }
            }
        }
    }

    private static int getTotalPages(VideojuegoDAO videojuegoDAO, int pageSize) {
        List<Videojuego> allVideojuegos = videojuegoDAO.getVideojuegosPaginados(1, Integer.MAX_VALUE);
        return (int) Math.ceil((double) allVideojuegos.size() / pageSize);
    }

    private static void displayPage(VideojuegoDAO videojuegoDAO, int currentPage, int pageSize) {
        List<Videojuego> videojuegosPaginados = videojuegoDAO.getVideojuegosPaginados(currentPage, pageSize);

        System.out.println("-------- Página " + currentPage + " de " + getTotalPages(videojuegoDAO, pageSize) + " --------");
        for (Videojuego videojuego : videojuegosPaginados) {
            System.out.println(videojuego.toString());
        }
    }
}
