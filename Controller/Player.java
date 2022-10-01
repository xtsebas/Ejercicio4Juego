package Controller;

import java.util.Scanner;

public class Player {
    protected String name;
    Scanner in= new Scanner(System.in);
    public  Player(String name){
        this.name=name;
    }

    public  String getName() {
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

}
