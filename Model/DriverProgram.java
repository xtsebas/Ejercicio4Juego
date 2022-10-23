package Model;

import java.util.Random;
import java.util.Scanner;
/**
*@author Sebastian
 */

public class DriverProgram {
    static Scanner in= new Scanner(System.in);
    static Random num= new Random(3);
    /**
    *Clase main, ejecutador del programa1
     */
    public static void main(String[] args) {
        System.out.println("////////////////////////////BIENVENIDO A PARADISE CITY///////////////////////////////////////////// \n                      ELIGE EL MODO DE JUEGO:");
        System.out.println("1. Un jugador\n2.Batalla personalizada (1 vs 1)");
        int op=in.nextInt();
        in.nextLine();
        switch (op){
            case 1:
                System.out.println("/////////////////////////////////////////////////////");
                Menu.newplayer();
                System.out.println("/////////////////////////////////////////////////////");
                boolean fight=true;
                while (fight){
                    int number= num.nextInt(4);
                    if (number<2){
                        boolean tf=Menu.randomenemies();
                        if (tf){
                            System.out.println("/////////////////////////////////////////////////////");
                            Menu.showenemies();
                            fight= Menu.fight();
                        }else {
                            System.out.println("/////////////////////////////////////////////////////");
                            Menu.notfigth();
                        }
                    }else {
                        System.out.println("//////////////////////////////////////////////////////////");
                        fight= Menu.raidfight();
                    }
                }
                break;
            case 2:
                ///////////////
                break;
        }
    }
}
