package Model;

import Controller.Enemy;
import Controller.Explorer;
import Controller.Player;
import Controller.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Menu {
    private static boolean tf;
    static Random num= new Random();
    static Scanner in= new Scanner(System.in);
    private static String name;
    private static int op;
    static List<Enemy> enemies= new ArrayList<>();
    static List<Player> players= new ArrayList<>();
    public static Warrior newwarrior(){
        Warrior warrior=new Warrior(name);
        players.add(warrior);
        return warrior;
    }
    public static Explorer newexplorer(){
        Explorer explorer=new Explorer(name);
        players.add(explorer);
        return explorer;
    }
    public static void newplayer(){
        System.out.println("Cual nombre tendra?");
        name=in.nextLine();
        System.out.println("Que tipo de jugador desea ser: \n1. Guerrero \n2. Explorador");
        op=in.nextInt();
        in.nextLine();
        if (op==1){
            newwarrior();
        } else if (op==2) {
            newexplorer();
        }
        System.out.println("Jugador ingresado correctamente");
    }

    public static void newenemy(){
        Enemy enemy=new Enemy();
        enemies.add(enemy);
    }
    public static boolean randomenemies() {
        op = num.nextInt(4);
        if (op == 0) {
            System.out.println("No hay enemigos cerca, avance");
            tf = false;
        } else if (op > 0 && op < 4) {
            System.out.println("Hay " + op + " enemigo/s, HORA DE COMBATIR!");
            for (int i = 0; i < op; i++) {
                newenemy();
            }
            tf=true;
        }
        return tf;
    }

    public static void fight(){
        if (tf){

        } else {
            System.out.println("Desea gastar 10 de vida para investigar la zona? \n1. Si \n2. No");
            op=in.nextInt();
            in.nextLine();
            if (op==1){

            }else {

            }
        }
    }
}
