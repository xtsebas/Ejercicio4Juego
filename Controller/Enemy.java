package Controller;

import java.util.Random;
/**
*Clase creadora de enemigos
 */

public class Enemy {
    private int power;
    private int life;
    Random num= new Random();
    /**
    *Constructor de enemigo
     */

    public Enemy(){
        setPower(num.nextInt(5));
        switch (getPower()){
            case 0:
                setLife(50);
                break;
            case 1:
                setLife(75);
                break;
            case 2:
                setLife(100);
                break;
            case 3:
                setLife(110);
                break;
            case 4:
                setLife(130);
                break;
        }

    }

    /**
    *Getters y setters de enemigos
     */

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
