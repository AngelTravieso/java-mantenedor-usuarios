package org.travieso.com;

import org.travieso.com.models.User;
import org.travieso.com.repositories.UserRepository;
import org.travieso.com.repositories.UserRepositoryImpl;

public class MantenedorUsuariosJDBC {
    public static void main(String[] args) {
        /*
        User usuario1 = new User(1L, "angel", "1234", "correo@correo.com");

        System.out.println("usuario1 = " + usuario1);

         */

        UserRepository<User> userRepository = new UserRepositoryImpl();

        System.out.println("================== LIST OF USERS =======================");
        userRepository.getUsers().forEach(System.out::println);
        System.out.println("\n");

        System.out.println("================== USER BY ID =======================");
        System.out.println(userRepository.getUser(5L));
        System.out.println("\n");

        System.out.println("================== CREATE USER =======================");
        User newUser = new User("yei", "alsq","correo5@correo.com");
        userRepository.createUser(newUser);
        System.out.println("\n");

        System.out.println("================== LIST OF USERS =======================");
        userRepository.getUsers().forEach(System.out::println);
        System.out.println("\n");

        System.out.println("================== DELETE USERS =======================");
        userRepository.deleteUser(4L);
        System.out.println("\n");

        System.out.println("================== LIST OF USERS =======================");
        userRepository.getUsers().forEach(System.out::println);
        System.out.println("\n");

    }
}
