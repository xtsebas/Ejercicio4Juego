package Model;

public class DriverProgram {
    public static void main(String[] args) {
        System.out.println("1. Un jugador\n2. 2 jugadores\n3. Batalla personalizada");
        Menu.randomenemies();
        Menu.fight();
    }
}
