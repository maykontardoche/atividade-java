// src/main/java/br/com/fintech/app/MainApp.java
package br.com.fintech.app;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.dao.UsuarioDAOImpl;

import java.util.Optional;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        UsuarioDAO userDao = new UsuarioDAOImpl();

        System.out.println("========================================\n");
        System.out.println("=== Bem vindo ao Sistema de Usuarios ===\n");
        System.out.println("1 - Registrar");
        System.out.println("2 - Login\n");
        System.out.println("========================================\n");
        System.out.print("Escolha uma opcao: ");
        int opt = scanner.nextInt();
        scanner.nextLine();

        if (opt == 1) {
            System.out.print("Nome completo: ");
            String fullName = scanner.nextLine();

            System.out.print("Usuario (login): ");
            String username = scanner.nextLine();

            System.out.print("E‑mail: ");
            String email = scanner.nextLine();

            System.out.print("Senha: ");
            String password = scanner.nextLine();

            userDao.register(username, fullName, email, password);
            System.out.println("\n✔ Registro realizado com sucesso!");

        } else if (opt == 2) {
            System.out.print("Usuario: ");
            String username = scanner.nextLine();

            System.out.print("Senha: ");
            String password = scanner.nextLine();

            Optional<String> userOpt = userDao.login(username, password);
            if (userOpt.isPresent()) {
                System.out.println("\n🎉 Bem‑vindo, " + userOpt.get() + "!");
            } else {
                System.out.println("\n❌ Usuario ou senha invalidos.");
            }
        } else {
            System.out.println("\n❌ Opcao invalida.");
        }

        scanner.close();
    }
}
