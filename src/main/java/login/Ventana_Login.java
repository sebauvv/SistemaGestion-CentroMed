package login;

import java.util.Random;
import java.util.Scanner;

//import usuarios.Medico;
import usuarios.Persona;

public class Ventana_Login {
    public static int var;
    public static boolean flag;
    public static String nameAux, apellidoAux, usernameAux, passwordAux;
    public static int edadAux;
    static Scanner input = new Scanner(System.in);

    public static void menu_inicio() {
        String aux = "";
        aux += "\nMenu de inicio\n";
        aux += "===================\n";
        aux += "Iniciar sesión como...\n";
        aux += "1. Paciente\n";
        aux += "2. Medico\n";
        aux += "3. Administrador\n";
        System.out.println(aux);
    }


    public static void menu_register(Persona p, String rol) {
        Random rn = new Random();
        System.out.println("Registrar " + rol + ": ");
        System.out.println("===============");

        System.out.print("Nombres: ");
        nameAux = input.nextLine();
        p.setNombre(nameAux);

        System.out.print("Apellidos: ");
        apellidoAux = input.nextLine();
        p.setApellido(apellidoAux);

        do{
            try{
                System.out.print("Edad: ");
                var = Integer.parseInt(input.nextLine());
                edadAux = var;
                flag = true;
            }catch(NumberFormatException e){
                System.out.println("Ingrese un numero valido");
                flag = false;
            }
        }while(var < 18 || var > 120 || !flag);
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

        p.setId(rn.nextInt(999-100) + 100);
        System.out.println("ID autogenerada: " + p.getId());
    }
}
