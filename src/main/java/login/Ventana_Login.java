package login;

import java.util.Scanner;
import usuarios.Persona;
import usuarios.*;

public class Ventana_Login {
    Scanner input = new Scanner(System.in);
    public String menu_login() {
        String aux = "";
        aux += "\nMenu de inicio de sesión\n";
        aux += "============================\n";
        aux += "Iniciar sesión como...\n";
        aux += "1. Paciente\n";
        aux += "2. Médico\n";
        aux += "3. Administrador\n";
        return aux;
    }

    public void menu_register(Persona p, String rol) {
        System.out.println("Registrar " + rol +": " );
        System.out.print("Nombres: ");
        p.nombre = input.nextLine();
        System.out.print("Apellidos: ");
        p.apellido = input.nextLine();
        System.out.print("Edad: ");
        p.edad = input.nextInt();
        System.out.println("===============");
        System.out.print("Nombre de usuario: ");
        p.username = input.nextLine();
        System.out.print("Contrasenia: ");
        p.password = input.nextLine();

    }
}


