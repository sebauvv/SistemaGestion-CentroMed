package usuarios;

import java.util.Scanner;
import login.Ventana_Login;

public class Administrador extends Persona{
    Scanner input = new Scanner(System.in);
    Ventana_Login vl = new Ventana_Login();

    public Administrador(String nombre, String apellido, int edad, String username, String password, int rol, int id) {
        super(nombre, apellido, edad, username, password, rol, id);
    }
}
