package usuarios;

import java.util.Scanner;
import login.Ventana_Login;

public class Administrador extends Persona{
    Scanner input = new Scanner(System.in);

    Ventana_Login vl = new Ventana_Login();

    public void registrar_Usuario(Paciente p, Medico m) {
        if(rol == 1) { // Paciente
            vl.menu_register(p, "paciente");
            //pasarlo a funcion y crear una consistencia en la DB
        } else if(rol == 2) { //Paciente

        }
        
    }
}
