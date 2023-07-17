package org.travieso.com.utils;

import org.travieso.com.models.User;
import org.travieso.com.repositories.*;

import java.util.Scanner;

public class UserService {

    static UserRepository<User> userRepository = new UserRepositoryImpl();
    public static void getUsersList() {
        System.out.println("================== LIST OF USERS =======================");
        userRepository.getUsers().forEach(System.out::println);
    }

    public static void getUserById(Long id) {
        System.out.println("================== USER BY ID =======================");
        User user = userRepository.getUser(id);
        if(user != null) {
            System.out.println(userRepository.getUser(id));
        } else {
            System.out.println("User not found");
        }
    }

    public static void createUser(User user) {
        System.out.println("================== CREATE USER =======================");
        userRepository.createUser(user);
    }

    public static void deleteUserById(Long id) {
        System.out.println("================== DELETE USER =======================");
        userRepository.deleteUser(id);
    }

    public static void printPrimaryMenu() {
        System.out.println("========================================================");
        System.out.println("============== ADMINISTRADOR DE USUARIOS ===============");
        System.out.println("========================================================");
        System.out.println("SELECCIONE UNA OPCION:");
        System.out.println("1. LISTAR USUARIO");
        System.out.println("2. BUSCAR USUARIO");
        System.out.println("3. CREAR NUEVO USUARIO");
        System.out.println("4. ELIMINAR USUARIO");
        System.out.println("0. SALIR");
    }

    public static void printSecondaryMenu() {
        System.out.println("\n");
        System.out.println("0. SALIR");
        System.out.println("1. MENU");
    }

    public static void performPrimaryMenuAction(int opt) {
        Scanner sc = new Scanner(System.in);
        switch (opt) {
            case 0-> {
                closeProgram();
            }
            case 1 -> {
                getUsersList();
                printSecondaryMenu();
                System.out.print("Option: ");
                int secondaryOpt = Integer.parseInt(sc.nextLine());
                performSecondaryMenuAction(secondaryOpt);
            }
            case 2 -> {
                System.out.print("USER ID: ");
                int userId = Integer.parseInt(sc.nextLine());
                getUserById((long) userId);
                printSecondaryMenu();
                System.out.print("Option: ");
                int secondaryOpt = Integer.parseInt(sc.nextLine());
                performSecondaryMenuAction(secondaryOpt);
            }
            case 3 -> {
                User newUser = new User();
                System.out.print("NOMBRE: ");
                String username = sc.nextLine();
                System.out.print("PASSWORD: ");
                String password = sc.nextLine();
                System.out.print("EMAIL: ");
                String email = sc.nextLine();
                newUser.setUsername(username.toLowerCase());
                newUser.setPassword(Crypto.hashPassword(password));
                newUser.setEmail(email.toLowerCase());
                createUser(newUser);
                printSecondaryMenu();
                System.out.print("Option: ");
                int secondaryOpt = Integer.parseInt(sc.nextLine());
                performSecondaryMenuAction(secondaryOpt);
            }
            case 4 -> {
                System.out.print("USER ID: ");
                int userId = Integer.parseInt(sc.nextLine());
                deleteUserById((long) userId);
                printSecondaryMenu();
                System.out.print("Option: ");
                int secondaryOpt = Integer.parseInt(sc.nextLine());
                performSecondaryMenuAction(secondaryOpt);
            }
        }
    }

    public static void performSecondaryMenuAction(int opt) {
        Scanner sc = new Scanner(System.in);
        switch (opt) {
            case 0 -> {
                closeProgram();
            }
            case 1 -> {
                printPrimaryMenu();
                System.out.print("Option: ");
                int selectedOpt = Integer.parseInt(sc.nextLine());
                UserService.performPrimaryMenuAction(selectedOpt);
            }
        }
    }

    public static void closeProgram() {
        System.out.println("\nSystem closed....");
        System.exit(0);
    }
}
