package Model;

import Controller.Explorer;
import Controller.Player;
import Controller.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu2 {
    static Scanner in= new Scanner(System.in);
    private static int op;
    public static int OO;
    private static String name;
    private static int hability;
    private static int life;
    private static int weapon;
    public static int p1;
    public static int p2;
    static List<Player> players= new ArrayList<>();
    static private boolean tf;
    private static int n;
    public static Warrior newwarrior(){
        Warrior warrior=new Warrior(name, weapon, hability, life);
        if (warrior.getHability()==2){
            warrior.setLife(warrior.getLife()+20);
        }
        return warrior;
    }
    public static Explorer newexplorer(){
        Explorer explorer=new Explorer(name, weapon, hability, life);
        if (explorer.getHability()==1){
            explorer.setLife(explorer.getLife()+35);
        }
        return explorer;
    }
    public static void newplayer(){
        System.out.println("Cual nombre tendra?");
        name=in.nextLine();
        System.out.println("Que tipo de jugador desea ser: \n1. Guerrero \n2. Explorador");
        OO=in.nextInt();
        in.nextLine();
        if (OO==1){
            players.add(newwarrior());
            if (players.size()==1){
                p1=1;
            } else {
                p2=1;
            }
        } else if (OO==2) {
            players.add(newexplorer());
            if (players.size()==1){
                p1=1;
            } else {
                p2=1;
            }
        }
        System.out.println("Jugador ingresado correctamente");
    }

    public static void createbattle(){
        for (int i = 0; i < 2; i++) {
            System.out.println("/////////////////////////////////////////////////////");
            newplayer();
        }
        System.out.println("");
        System.out.println("LOS ATAQUES Y HABILIDADES EN ESTE MODO DE JUEGO SON DIFERENTES, SE PUEDE ELEGIR ENTRE " +
                "ATACAR O USAR UNA HABILIDAD");
    }
    public static void status(){
        System.out.println("////////////////////////////////////");
        System.out.println("Estado de jugadores: ");
        for (Player player:players) {
            System.out.println("Jugador " + player.getName() + "\nVida: " + player.getLife());
            System.out.println("");
        }
    }
    public static boolean fight(){
        n=0;
        while (players.get(0).getLife()>0 && players.get(1).getLife()>0){
            if (n % 2 != 0){
                System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
                System.out.println("Es tu turno de atacar " + players.get(0).getName() + " \n1. atacar \n2. usar habilidad");
                op=in.nextInt();
                if (p1==1){
                    if (op==1){
                        switch (players.get(0).getWeapon()){
                            case 1:
                                players.get(1).setLife(players.get(1).getLife()-40);
                                players.get(0).setLife(players.get(0).getLife()+10);
                                System.out.println("El jugador " + players.get(0).getName()+ " ataco a " + players.get(1).getName());
                                status();
                        }
                    }
                }
                n=1+n;
            }else {

                n=1+n;
            }
        }
        return tf;
    }
}
