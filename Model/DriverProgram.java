package Model;

import java.util.Scanner;
/*
*@author Sebastian
 */

public class DriverProgram {
    public static boolean tf;
    public static int op;
    public static boolean fight;
    public static boolean fight2;
    static Scanner in= new Scanner(System.in);
    /*
    *Clase main, ejecutador del programa
     */
    public static void main(String[] args) {
        System.out.println("////////////////////////////BIENVENIDO A PARADISE CITY///////////////////////////////////////////// \n                      ELIGE EL MODO DE JUEGO:");
        System.out.println("1. Un jugador\n2.Batalla personalizada (1 vs 1)");
        op=in.nextInt();
        in.nextLine();
        switch (op){
            case 1:
                System.out.println("/////////////////////////////////////////////////////");
                Menu.newplayer();
                System.out.println("/////////////////////////////////////////////////////");
                fight=true;
                while (fight){
                    tf=Menu.randomenemies();
                    if (tf){
                        System.out.println("/////////////////////////////////////////////////////");
                        Menu.showenemies();
                        fight= Menu.fight();
                    }else {
                        System.out.println("/////////////////////////////////////////////////////");
                        Menu.notfigth();
                    }
                }
                break;
            case 2:
                Menu2.createbattle();
                fight2=true;
                while (fight2){
                    Menu2.status();
                    System.out.println("");
                    fight2=Menu2.fight();
                }
                break;
        }
    }
}
