package login;

import java.util.Scanner;

//import usuarios.Medico;
import usuarios.Persona;

public class Ventana_Login {
    static int var;
    public static String nameAux, apellidoAux, usernameAux, passwordAux;
    public static int edadAux;
    Scanner input = new Scanner(System.in);

    public void menu_inicio() {
        String aux = "";
        aux += "\nMenu de inicio\n";
        aux += "===================\n";
        aux += "Iniciar sesión como...\n";
        aux += "1. Paciente\n";
        aux += "2. Medico\n";
        aux += "3. Administrador\n";
        System.out.println(aux);
    }


    public void menu_register(Persona p, String rol) {
        System.out.println("Registrar " + rol + ": ");
        System.out.println("===============");

        System.out.print("Nombres: ");
        nameAux = input.nextLine();
        p.setNombre(nameAux);

        System.out.print("Apellidos: ");
        apellidoAux = input.nextLine();
        p.setApellido(apellidoAux);

        System.out.print("Edad: ");
        var = Integer.parseInt(input.nextLine());
        edadAux = var;
        p.setEdad(edadAux);

        System.out.println("===============");
        // input.nextLine(); //buffer problem

        System.out.print("Nombre de usuario: ");
        usernameAux = input.nextLine();
        p.setUsername(usernameAux);

        // contrasenia random gen
        System.out.print("Contrasenia: ");
        passwordAux = input.nextLine();
        p.setPassword(passwordAux);

    }
}
