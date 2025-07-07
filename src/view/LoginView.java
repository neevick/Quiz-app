package view;

import controller.UserController;

import java.util.Scanner;

public class LoginView {
    public static void showLoginView(){
        UserController userController = new UserController();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username");
        String username = scan.nextLine();
        System.out.println("Enter password");
        String password = scan.nextLine();
        if (userController.longIn(username,password)){
            // TODO Show the questions and options
            System.out.println("Logged in successfully.");
            System.out.println("Questions..");
        }else {
            System.out.println("Invalid username or password.");
            GameMenu.showMenu();
        }
    }
}
