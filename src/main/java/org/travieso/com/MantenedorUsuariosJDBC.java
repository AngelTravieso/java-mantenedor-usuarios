package org.travieso.com;

import org.travieso.com.models.utils.UserService;

import java.util.Scanner;

public class MantenedorUsuariosJDBC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opt = -1;

        do {
            UserService.printPrimaryMenu();
            System.out.print("Option: ");
            opt = Integer.parseInt(sc.nextLine());
            UserService.performPrimaryMenuAction(opt);
        } while(opt == -1);
    }
}
