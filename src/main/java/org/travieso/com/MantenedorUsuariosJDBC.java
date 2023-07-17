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

        userRepository.getUsers();


    }
}
