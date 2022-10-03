package Model;

import Controller.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Menu {
    private static boolean tf;
    private static int nu;
    private static int N;
    static Random num= new Random();
    static Random num2= new Random();
    static Scanner in= new Scanner(System.in);
    private static String name;
    private static int hability;
    private static int life;
    private static int weapon;
    private static int op;
    static List<Enemy> enemies= new ArrayList<>();
    static List<Player> players= new ArrayList<>();
    static List<Items> items= new ArrayList<>();
    static private int n;
    static private int I;
    static private int OP;
    static private int en;
    static public int O;
    static boolean good;
    static boolean evil;
    static private int follow;

    public static Warrior newwarrior(){
        Warrior warrior=new Warrior(name, weapon, hability, life);
        if (warrior.getHability()==2){
            warrior.setLife(warrior.getLife()+20);
        }
        players.add(warrior);
        return warrior;
    }
    public static Explorer newexplorer(){
        Explorer explorer=new Explorer(name, weapon, hability, life);
        if (explorer.getHability()==1){
            explorer.setLife(explorer.getLife()+35);
        }
        players.add(explorer);
        return explorer;
    }
    public static void newplayer(){
        System.out.println("Cual nombre tendra?");
        name=in.nextLine();
        System.out.println("Que tipo de jugador desea ser: \n1. Guerrero \n2. Explorador");
        O=in.nextInt();
        in.nextLine();
        if (O==1){
            newwarrior();
        } else if (O==2) {
            newexplorer();
        }
        System.out.println("Jugador ingresado correctamente");
    }

    public static void newenemy(){
        Enemy enemy=new Enemy();
        enemies.add(enemy);
    }

    public static void newitem(){
        Items item= new Items();
        items.add(item);
    }
    public static boolean randomenemies() {
        op = num.nextInt(3);
        if (op == 0) {
            System.out.println("No hay enemigos cerca, avance");
            tf = false;
        } else if (op > 0 && op < 4) {
            System.out.println("Hay " + op + " enemigo/s, HORA DE COMBATIR!");
            for (int i = 0; i < op; i++) {
                newenemy();
                if (enemies.get(i).getPower()==4){
                    System.out.println("CUIDADO, HAY UN/MAS JEFE ENTRE LOS ENEMIGOS");
                }
            }
            tf=true;
        }
        return tf;
    }
    public static void showenemies() {
        for (int i = 0; i < enemies.size(); i++) {
            System.out.println("Enemigo " + i + " Poder: " + enemies.get(i).getPower() + " Vida: " + enemies.get(i).getLife());
        }
    }
    public static void showitems(){
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item " + i + " Vida que puede recuperar: " + items.get(i).getLifes());
        }
    }
    public static int enemydead(){
        if (enemies.size()==1){
            if (enemies.get(0).getLife()==0) {
                System.out.println("//////////////////////HAS GANADO, FELICIDADES//////////////////////////////////");
                System.out.println("Desea continuar la aventura? \n1. Si \n2. No");
                follow = in.nextInt();
            }
        } else if (enemies.size()==2) {
            if (enemies.get(0).getLife()==0 && enemies.get(1).getLife()==0 ) {
                System.out.println("//////////////////////HAS GANADO, FELICIDADES//////////////////////////////////");
                System.out.println("Desea continuar la aventura? \n1. Si \n2. No");
                follow = in.nextInt();
            }
        } else if (enemies.size()==3){
            if (enemies.get(0).getLife()==0 && enemies.get(1).getLife()==0 && enemies.get(2).getLife()==0 ) {
                System.out.println("//////////////////////HAS GANADO, FELICIDADES//////////////////////////////////");
                System.out.println("Desea continuar la aventura? \n1. Si \n2. No");
                follow = in.nextInt();
            }
        }
        return follow;
    }
    public static void lifenemy(){
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getLife()<0){
                enemies.get(i).setLife(0);
            }
        }
    }

    public static boolean fight() {
        n = 1;
        good=true;
        evil=true;
        while (good && evil){
            if (n % 2 != 0) {
                for (Player player : players) {
                    if (O==1){
                        System.out.println("Es tu turno Guerrero " + player.getName());
                        System.out.println("1. atacar con espada \n2. recuperar vida");
                        op = in.nextInt();
                        in.nextLine();
                        if (op == 1) {
                            if (player.getWeapon() == 1) {
                                if (player.getHability() == 3) {
                                    System.out.println("Desea usar su habilidad especial BOLA DE FUEGO?\n1.Si \n2.No");
                                    OP = in.nextInt();
                                    if (OP == 1) {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 65);
                                        lifenemy();
                                        player.setLife(player.getLife()+10);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    } else {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 40);
                                        lifenemy();
                                        player.setLife(player.getLife()+10);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    }
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2){
                                        tf = false;
                                        evil = false;
                                    }

                                } else if (player.getHability()==1) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 50);
                                    lifenemy();
                                    player.setLife(player.getLife()+10);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2){
                                        tf = false;
                                        evil = false;
                                    }
                                } else if (player.getHability()==2) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 40);
                                    lifenemy();
                                    player.setLife(player.getLife()+10);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2){
                                        tf = false;
                                        evil = false;
                                    }
                                }
                            } else if (player.getWeapon() == 2) {
                                if (player.getHability() == 3) {
                                    System.out.println("Desea usar su habilidad especial BOLA DE FUEGO?\n1.Si \n2.No");
                                    OP = in.nextInt();
                                    if (OP == 1) {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 75);
                                        lifenemy();
                                        player.setLife(player.getLife()+5);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    } else {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 50);
                                        lifenemy();
                                        player.setLife(player.getLife()+5);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    }
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2) {
                                        tf = false;
                                        evil = false;
                                    }
                                } else if (player.getHability()==1) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 60);
                                    lifenemy();
                                    player.setLife(player.getLife()+5);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2) {
                                        tf = false;
                                        evil = false;
                                    }
                                } else if (player.getHability()==2) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 50);
                                    lifenemy();
                                    player.setLife(player.getLife()+5);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2) {
                                        tf = false;
                                        evil = false;
                                    }
                                }
                            } else if (player.getWeapon() == 3) {
                                if (player.getHability() == 3) {
                                    System.out.println("Desea usar su habilidad especial BOLA DE FUEGO?\n1.Si \n2.No");
                                    OP = in.nextInt();
                                    if (OP == 1) {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 55);
                                        lifenemy();
                                        player.setLife(player.getLife()+25);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    } else {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 20);
                                        lifenemy();
                                        player.setLife(player.getLife()+25);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    }
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2) {
                                        tf = false;
                                        evil = false;
                                    }
                                } else if (player.getHability()==1) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 30);
                                    lifenemy();
                                    player.setLife(player.getLife()+25);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2) {
                                        tf = false;
                                        evil = false;
                                    }
                                } else if (player.getHability()==2) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 20);
                                    lifenemy();
                                    player.setLife(player.getLife()+25);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2) {
                                        tf = false;
                                        evil = false;
                                    }
                                }
                            }
                        } else {
                            if (items.size()==0){
                                System.out.println("No tiene ningun objeto de recuperacion de vida, AGUANTA!!");
                            }else {
                                showitems();
                                System.out.println("Cual item desea tomar? ");
                                I=in.nextInt();
                                in.nextLine();
                                System.out.println("Ha tomado el item " + I);
                                player.setLife(player.getLife()+items.get(I).getLifes());
                                items.remove(I);
                                if (items.size()==0){
                                    System.out.println("CUIDADO, YA NO TE QUEDAN MAS ITEMS DE RECUPERACION");
                                }
                                System.out.println("Estado del Jugador: \nNombre: " + player.getName() + "\nVida: " + player.getLife());
                            }
                        }
                    }else {
                        System.out.println("Es tu turno Explorador " + player.getName());
                        System.out.println("1. atacar con espada \n2. recuperar vida");
                        op = in.nextInt();
                        in.nextLine();
                        if (op == 1) {
                            if (player.getWeapon() == 1) {
                                if (player.getHability() == 3) {
                                    System.out.println("Desea usar su habilidad especial Yisus\n1.Si \n2.No");
                                    OP = in.nextInt();
                                    if (OP == 1) {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 35);
                                        lifenemy();
                                        player.setLife(player.getLife()+10);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    } else {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 20);
                                        lifenemy();
                                        player.setLife(player.getLife()+10);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    }
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2) {
                                        tf = false;
                                        evil = false;
                                    }

                                } else if (player.getHability()==1) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 20);
                                    lifenemy();
                                    player.setLife(player.getLife()+45);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2) {
                                        tf = false;
                                        evil = false;
                                    }
                                } else if (player.getHability()==2) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 40);
                                    lifenemy();
                                    player.setLife(player.getLife()+10);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2){
                                        tf = false;
                                        evil = false;
                                    }
                                }
                            } else if (player.getWeapon() == 2) {
                                if (player.getHability() == 3) {
                                    System.out.println("Desea usar su habilidad especial YISUS?\n1.Si \n2.No");
                                    OP = in.nextInt();
                                    if (OP == 1) {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 65);
                                        lifenemy();
                                        player.setLife(player.getLife()+15);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    } else {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 50);
                                        lifenemy();
                                        player.setLife(player.getLife()+5);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    }
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2){
                                        tf = false;
                                        evil = false;
                                    }
                                } else if (player.getHability()==1) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 50);
                                    lifenemy();
                                    player.setLife(player.getLife()+50);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2){
                                        tf = false;
                                        evil = false;
                                    }
                                } else if (player.getHability()==2) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 70);
                                    lifenemy();
                                    player.setLife(player.getLife()+15);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2){
                                        tf = false;
                                        evil = false;
                                    }
                                }
                            } else if (player.getWeapon() == 3) {
                                if (player.getHability() == 3) {
                                    System.out.println("Desea usar su habilidad especial BOLA DE FUEGO?\n1.Si \n2.No");
                                    OP = in.nextInt();
                                    if (OP == 1) {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 55);
                                        lifenemy();
                                        player.setLife(player.getLife()+25);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    } else {
                                        showenemies();
                                        System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                        en = in.nextInt();
                                        in.nextLine();
                                        enemies.get(en).setLife(enemies.get(en).getLife() - 20);
                                        lifenemy();
                                        player.setLife(player.getLife()+25);
                                        System.out.println("///////////////////////////////\n estado del enemigo: ");
                                        showenemies();
                                        System.out.println("//////////////////////////////// \nestado del jugador");
                                        System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                        follow = enemydead();
                                    }
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2){
                                        tf = false;
                                        evil = false;
                                    }
                                } else if (player.getHability()==1) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 10);
                                    lifenemy();
                                    player.setLife(player.getLife()+30);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2){
                                        tf = false;
                                        evil = false;
                                    }
                                } else if (player.getHability()==2) {
                                    showenemies();
                                    System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                    en = in.nextInt();
                                    in.nextLine();
                                    enemies.get(en).setLife(enemies.get(en).getLife() - 30);
                                    lifenemy();
                                    player.setLife(player.getLife()+30);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                    follow = enemydead();
                                    if (follow == 1) {
                                        tf = true;
                                        evil = false;
                                    } else if (follow==2){
                                        tf = false;
                                        evil = false;
                                    }
                                }
                            }
                        } else {
                            if (items.size()==0){
                                System.out.println("No tiene ningun objeto de recuperacion de vida, AGUANTA!!");
                            }else {
                                showitems();
                                System.out.println("Cual item desea tomar? ");
                                I=in.nextInt();
                                in.nextLine();
                                System.out.println("Ha tomado el item " + I);
                                player.setLife(player.getLife()+items.get(I).getLifes());
                                System.out.println("Estado del Jugador: \nNombre: " + player.getName() + "\nVida: " + player.getLife());
                            }
                        }
                    }
                }
            }else {
                System.out.println("EL enemigo atacara, preparate!!!");
                    if (enemies.size()==1){
                        N=0;
                    } else if (enemies.size()==2) {
                        nu=num.nextInt(2);
                        if (nu==0){
                            if (enemies.get(nu).getLife()>0){
                                N=0;
                            } else {N=1;}
                        }else {
                            if (enemies.get(nu).getLife()>0){
                                N=1;
                            } else {N=0;}
                        }
                    }else if (enemies.size()==3) {
                        nu = num.nextInt(3);
                        if (nu == 0) {
                            if (enemies.get(nu).getLife()>0){
                                N=0;
                            } else {
                                if (num2.nextInt(2)==0){
                                    N=1;
                                }else {
                                    N=2;
                                }
                            }
                        } else if (nu == 1) {
                            if (enemies.get(nu).getLife()>0){
                                N=1;
                            } else {
                                if (num2.nextInt(2)==0){
                                    N=0;
                                }else {
                                    N=2;
                                }
                            }
                        } else if (nu == 2) {
                            if (enemies.get(nu).getLife()>0){
                                N=2;
                            } else {
                                if (num2.nextInt(2)==0){
                                    N=0;
                                }else {
                                    N=1;
                                }
                            }
                        }
                    }
                    switch (enemies.get(N).getPower()){
                        case 0:
                            for (Player player:players){
                                player.setLife(player.getLife()-10);
                                System.out.println("El enemigo " + N + " ataco!");
                                System.out.println("Estado del Jugador: \nNombre: " + player.getName()+ "\nVida: " + player.getLife());
                                if (player.getLife() <= 0){
                                    System.out.println("/////////////////////////////////HAS MUERTO////////////////////////////////////////////////");
                                    good=false;
                                    tf=good;
                                }
                            }
                            break;
                        case 1:
                            for (Player player:players){
                                player.setLife(player.getLife()-20);
                                System.out.println("El enemigo " + N + " ataco!");
                                System.out.println("Estado del Jugador: \nNombre: " + player.getName()+ "\nVida: " + player.getLife());
                                if (player.getLife() <= 0){
                                    System.out.println("/////////////////////////////////HAS MUERTO////////////////////////////////////////////////");
                                    good=false;
                                    tf=good;
                                }
                            }
                            break;
                        case 2:
                            for (Player player:players){
                                player.setLife(player.getLife()-30);
                                System.out.println("El enemigo " + N + " ataco!");
                                System.out.println("Estado del Jugador: \nNombre: " + player.getName()+ "\nVida: " + player.getLife());
                                if (player.getLife() <= 0){
                                    System.out.println("/////////////////////////////////HAS MUERTO////////////////////////////////////////////////");
                                    good=false;
                                    tf=good;
                                }
                            }
                            break;
                        case 3:
                            for (Player player:players){
                                player.setLife(player.getLife()-35);
                                System.out.println("El enemigo " + N + " ataco!");
                                System.out.println("Estado del Jugador: \nNombre: " + player.getName()+ "\nVida: " + player.getLife());
                                if (player.getLife() <= 0){
                                    System.out.println("/////////////////////////////////HAS MUERTO////////////////////////////////////////////////");
                                    good=false;
                                    tf=good;
                                }
                            }
                            break;
                        case 4:
                            for (Player player:players){
                                player.setLife(player.getLife()-40);
                                System.out.println("El enemigo " + N + " ataco!");
                                System.out.println("Estado del Jugador: \nNombre: " + player.getName()+ "\nVida: " + player.getLife());
                                if (player.getLife() <= 0){
                                    System.out.println("/////////////////////////////////HAS MUERTO////////////////////////////////////////////////");
                                    good=false;
                                    tf=good;
                                }
                            }
                            break;

                    }
                }
            n=n+1;
            }
        enemies.clear();
        return tf;
    }

    public static void notfigth(){
        System.out.println("Desea gastar 10 de vida para investigar la zona? \n1. Si \n2. No");
        op=in.nextInt();
        in.nextLine();
        if (op==1){
            newitem();
            for (Player player: players){
                player.setLife(player.getLife()-10);
                System.out.println("Estado del Jugador: \nNombre: " + player.getName()+ "\nVida: " + player.getLife());
            }
        }else {
            System.out.println("Sigue adelante!");
        }
    }
}
