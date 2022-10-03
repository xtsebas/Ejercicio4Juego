package Controller;

import java.util.Random;

public class Items {
    Random num=new Random();
    private static int lifes;
    private static int n;
    public Items(){
        setN(num.nextInt(4));
        switch (n){
            case 0:
                System.out.println("No se encontro nada, siga avanzando");
                setLifes(0);
                break;
            case 1:
                System.out.println("Se encontro un item\nCONTIENE 10 PUNTOS DE VIDA");
                setLifes(10);
                break;
            case 2:
                System.out.println("Se encontro un item\nCONTIENE 20 PUNTOS DE VIDA");
                setLifes(20);
                break;
            case 3:
                System.out.println("Se encontro un item\nCONTIENE 35 PUNTOS DE VIDA");
                setLifes(35);
                break;
        }

    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        Items.lifes = lifes;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        Items.n = n;
    }
}
