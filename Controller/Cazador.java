package Controller;

public class Cazador extends Player{
    /**
     * constructor
     *
     * @param name
     * @param weapon
     * @param hability
     * @param life
     */
    public Cazador(String name, int weapon, int hability, int life) {
        super(name, weapon, hability, life);
        setLife(100);
        System.out.println("Por elegir cazador, solo contiene un arma, siendo una espada de largo de 2 metros " +
                "\nNombre: Mata Dragones \nDaño: 40 \nVida ganada por daño hecho: 10");
        setWeapon(1);
        try {
            if (getWeapon()<=3 && 0>getWeapon()){
                System.out.println("Ingreso de arma correcto");
            }
        }catch (Exception e){
            System.out.println("Ingreso un numero incorrecto " + e.getMessage());
        }
        System.out.println("");
        System.out.println("Eligir tu mascota de guerrero: \n1.Pochita: agrega 35 puntos a su vida cuando esta se pierde" +
                "\n2.Weaky: Agrega 35 puntos en ataque \n3.Judy: Agrega 20 puntos al ataque y 15 puntos a la vida cuando esta se pierde ");
        setHability(in.nextInt());
        try {
            if (getHability()<=3 && 0>getHability()){
                System.out.println("Ingreso de mascota correcto");
            }
        }catch (Exception e){
            System.out.println("Ingreso un numero incorrecto " + e.getMessage());
        }
    }
}
