package Controller;

import java.util.Scanner;
/*
*clase creadora de jugador
 */
public class Player {
    protected int weapon;
    protected static int life;
    protected int hability;
    protected String name;
    Scanner in= new Scanner(System.in);
    /**
    *constructor
     */
    public  Player(String name, int weapon, int habilityelse, int life){
        this.life=life;
        this.name=name;
        this.weapon=weapon;
        this.hability=hability;
    }
/**
* getters y setters
 */
    public  String getName() {
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getHability() {
        return hability;
    }

    public void setHability(int hability) {
        this.hability = hability;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        Player.life = life;
    }
}
