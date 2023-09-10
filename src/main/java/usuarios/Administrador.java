package usuarios;

import java.util.Scanner;
import login.Ventana_Login;

public class Administrador extends Persona{
    Scanner input = new Scanner(System.in);
    Ventana_Login vl = new Ventana_Login();

    public Administrador(String nombre, String apellido, int edad, String username, String password, int rol) {
        super(nombre, apellido, edad, username, password, rol);
    }

    // public void registrar_Usuario(Paciente p, Medico m, int rol) {
        
    //     if(rol == 1) { // Paciente
    //         vl.menu_register(p, "paciente");  //crear una consistencia en la DB
    //         /*
    //          * Proceso de pasarlo a la DB
    //          */
    //         System.out.println("Paciente registrado exitosamente.");

    //     } else if(rol == 2) { //Paciente
    //         vl.menu_register(m, "medico"); 
    //         /* DB */
    //         System.out.println("Paciente registrado exitosamente.");

    //     }
        
    // }
}
