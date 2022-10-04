package Controller;

import java.util.Scanner;
/*
*clase creadora de jugadores exploradores
 */
public class Explorer extends Player{
    Scanner in= new Scanner(System.in);
    /*
    *Constructor de exploradores
    * @param name, weapon, hability, life
     */
    public Explorer(String name, int weapon, int hability, int life){
        super(name, weapon, hability, life);
        setLife(100);
        System.out.println("Por elegir explorador, sus armas tienen ataques especiales, cual desea? \n1. Egolas(arco) \nDaño: 20 \nGanancia de" +
                "vida con daño hecho: 20 \n2. Griffith(mazo) \nDaño: 50 \nGanancia de vida con daño hecho: 15 \n3.Lighting(magia) \nDaño: 10 \nGanancia de vida con daño hecho: 30");
        setWeapon(in.nextInt());
        try {
            if (getWeapon()<=3 && 0>getWeapon()){
                System.out.println("Ingreso de arma correcto");
            }
        }catch (Exception e){
            System.out.println("Ingreso un numero incorrecto " + e.getMessage());
        }
        in.nextLine();
        System.out.println("Eligir tu habilidad de guerrero: \n1.Curacion: agrega 35 puntos a su vida\n2.Ojo de halcon: Agrega 20 puntos en ataque \n3.Yisus: Daño agregado al ataque: 15 ");
        setHability(in.nextInt());
        try {
            if (getHability()<=3 && 0>getHability()){
                System.out.println("Ingreso de arma correcto");
            }
        }catch (Exception e){
            System.out.println("Ingreso un numero incorrecto " + e.getMessage());
        }
    }

}
