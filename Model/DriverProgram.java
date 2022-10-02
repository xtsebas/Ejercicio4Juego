package Model;

import java.util.Scanner;

public class DriverProgram {
    public static boolean tf;
    public static int op;
    static Scanner in= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("BIENVENIDO A PARADISE CITY \nELIGE EL MODO DE JUEGO:");
        System.out.println("1. Un jugador\n2. 2 jugadores\n3. Batalla personalizada");
        op=in.nextInt();
        in.nextLine();
        switch (op){
            case 1:
                System.out.println("/////////////////////////////////////////////////////");
                Menu.newplayer();
                System.out.println("/////////////////////////////////////////////////////");
                tf=Menu.randomenemies();
                if (tf){
                    System.out.println("/////////////////////////////////////////////////////");
                    Menu.showenemies();
                    Menu.fight();
                }else {
                    System.out.println("/////////////////////////////////////////////////////");
                    Menu.notfigth();
                }
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
