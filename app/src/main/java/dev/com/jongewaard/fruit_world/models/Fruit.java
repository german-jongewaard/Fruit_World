package dev.com.jongewaard.fruit_world.models;

/**
 * Created by german on 10-11-17.
 */

public class Fruit {

    private String name;
    private int icono;
    private String origin;

    public Fruit(String name, int icono, String origin) {
        this.name = name;
        this.icono = icono;
        this.origin = origin;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getIcono() {return icono;}

    public void setIcono(int icono) {this.icono = icono;}

    public String getOrigin() {return origin;}

    public void setOrigin(String origin) {this.origin = origin;}
}
