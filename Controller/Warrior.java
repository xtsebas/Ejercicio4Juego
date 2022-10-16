package Controller;

import java.util.Scanner;
/**
*clase creadora de jugadores guerreros
 */
public class Warrior extends Player{
    Scanner in= new Scanner(System.in);
    /**
    *constructor de guerrero
    * @param name, weapon, hability, life
     */

    public Warrior(String name, int weapon, int hablity, int life){
        super(name, weapon, hablity, life);
        setLife(100);
        System.out.println("Por elegir guerrero, sus armas (espadas) tienen ataques especiales, cual desea? \n1. Excalibur \nDaño: 40 \nGanancia de" +
                "vida con daño hecho: 10 \n2. Chunchunmaru \nDaño: 50 \nGanancia de vida con daño hecho: 5 \n3. Steve \nDaño: 20 \nGanancia de vida con daño hecho: 25");
        setWeapon(in.nextInt());
        try {
            if (getWeapon()<=3 && 0>=getWeapon()){
                System.out.println("Ingreso de arma correcto");
            }
        }catch (Exception e){
            System.out.println("Ingreso un numero incorrecto " + e.getMessage());
        }
        in.nextLine();
        System.out.println("Eligir tu habilidad de guerrero: \n1.Fuerza: agrega 10 puntos a su ataque \n2.Resistencia: Agrega 20 puntos en vida \n3.Bola de fuego: Daño agregado al ataque: 25 ");
        setHability(in.nextInt());
        try {
            if (getHability()<=3 && 0>=getHability()){
                System.out.println("Ingreso de arma correcto");
            }
        }catch (Exception e){
            System.out.println("Ingreso un numero incorrecto " + e.getMessage());
        }

    }

}
