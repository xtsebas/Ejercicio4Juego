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
    private static int nu;
    static Random num= new Random();
    static Scanner in= new Scanner(System.in);
    private static String name;
    private static int hability;
    private static int life;
    private static int weapon;
    private static int op;
    static List<Enemy> enemies= new ArrayList<>();
    static List<Player> players= new ArrayList<>();
    static List<>;
    static private int n;
    static private int I;
    static private int OP;
    static private int en;
    static public int O;

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
    public static boolean randomenemies() {
        op = num.nextInt(4);
        if (op == 0) {
            System.out.println("No hay enemigos cerca, avance");
            tf = false;
        } else if (op > 0 && op < 4) {
            System.out.println("Hay " + op + " enemigo/s, HORA DE COMBATIR!");
            for (int i = 0; i < op+1; i++) {
                newenemy();
            }
            tf=true;
        }
        return tf;
    }
    public static void showenemies() {
        for (int i = 1; i < enemies.size(); i++) {
            System.out.println("Enemigo " + i + " Poder: " + enemies.get(i).getPower() + " Vida: " + enemies.get(i).getLife());
        }
    }

    public static void fight() {
        n = 1;
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
                                    player.setLife(player.getLife()+10);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                }
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 40);
                                player.setLife(player.getLife()+10);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==1) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 50);
                                player.setLife(player.getLife()+10);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==2) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 40);
                                player.setLife(player.getLife()+10);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
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
                                    player.setLife(player.getLife()+5);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                }
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 50);
                                player.setLife(player.getLife()+5);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==1) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 60);
                                player.setLife(player.getLife()+5);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==2) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 50);
                                player.setLife(player.getLife()+5);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
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
                                    player.setLife(player.getLife()+25);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                }
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 20);
                                player.setLife(player.getLife()+25);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==1) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 30);
                                player.setLife(player.getLife()+25);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==2) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 20);
                                player.setLife(player.getLife()+25);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            }
                        }
                    } else {


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
                                    player.setLife(player.getLife()+10);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                }
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 20);
                                player.setLife(player.getLife()+10);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==1) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 20);
                                player.setLife(player.getLife()+45);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==2) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 40);
                                player.setLife(player.getLife()+10);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
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
                                    player.setLife(player.getLife()+15);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                }
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 50);
                                player.setLife(player.getLife()+5);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==1) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 50);
                                player.setLife(player.getLife()+50);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==2) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 70);
                                player.setLife(player.getLife()+15);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
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
                                    player.setLife(player.getLife()+25);
                                    System.out.println("///////////////////////////////\n estado del enemigo: ");
                                    showenemies();
                                    System.out.println("//////////////////////////////// \nestado del jugador");
                                    System.out.println(player.getName()+"\nVida: "+ player.getLife());
                                }
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 20);
                                player.setLife(player.getLife()+25);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==1) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 10);
                                player.setLife(player.getLife()+30);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            } else if (player.getHability()==2) {
                                showenemies();
                                System.out.println("Cual enemigo desea atacar (ingresar el numero del enemigo)");
                                en = in.nextInt();
                                in.nextLine();
                                enemies.get(en).setLife(enemies.get(en).getLife() - 30);
                                player.setLife(player.getLife()+30);
                                System.out.println("///////////////////////////////\n estado del enemigo: ");
                                showenemies();
                                System.out.println("//////////////////////////////// \nestado del jugador");
                                System.out.println(player.getName()+"\nVida: "+ player.getLife());
                            }
                        }
                    } else {

                    }
                }

                }

            }
            n++;
        }

    public static void notfigth(){
        System.out.println("Desea gastar 10 de vida para investigar la zona? \n1. Si \n2. No");
        op=in.nextInt();
        in.nextLine();
        if (op==1){

        }else {

        }
    }
}
