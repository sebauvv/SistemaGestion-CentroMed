package main;

//import usuarios.Administrador;
import usuarios.Medico;
import usuarios.Paciente;
import usuarios.Persona;

import static login.Ventana_Login.*;

import java.util.Scanner;

public class Main {
    static int opc, var, rol; 
    // var: variable auxiliar para el try-catch | rol: rol del usuario | opc: opcion
    static boolean flag, pass_p, pass_m; 
    // flag: bandera para el try-catch | pass_p: bandera para el menu de paciente | pass_m: bandera para el menu de medico
    public static String nameAux, apellidoAux, usernameAux, passwordAux;
    // nameAux: nombre auxiliar | apellidoAux: apellido auxiliar | usernameAux: username auxiliar | passwordAux: password auxiliar
    public static int edadAux, id_aux;
    // edadAux: edad auxiliar | id_aux: id auxiliar
    static Scanner input = new Scanner(System.in);
    

    public static void main(String[] args) {
        
        Paciente arrayPaciente[] = new Paciente[50];
        Medico arrayMedico[] = new Medico[50];
        int k = 0; // aux pos int variable
        int j = 0; // j debe contener la canitdad de pacientes registrados actualmente
        int i = 0; // i debe contener la cantidad de medicos registrados actualmente

        //arrayPaciente[j] = new Paciente(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test", id_aux);
        //arrayMedico[i] = new Medico(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test", id_aux);

        do{
            menu_inicio();

            do {
                try {
                    System.out.print("Opcion: ");
                    rol = Integer.parseInt(input.nextLine());

                    if (pass_p == false && rol == 1 && j == 0) {
                        System.out.println("No hay pacientes registrados.");
                        flag = false;
                    }
                    else if (pass_m == false && rol == 2 && i == 0) {
                        System.out.println("No hay medicos registrados.");
                        flag = false;
                    }
                    else {
                        flag = true;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Opcion invalida.");
                    flag = false;
                }
            } while ((flag  == false) || (rol < 1 || rol > 3));

            //StringBuilder: objeto mutable para pasar por referencia (las strings son inmutables aaaa)
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            switch (rol) { 
                case 1: //Paciente
                
                    menu_login(sb1, sb2);
                    usernameAux = sb1.toString();
                    passwordAux = sb2.toString();

                    for (int x = 0; x < j; x++) {
                        if(arrayPaciente[x].getUsername().equals(usernameAux) && arrayPaciente[x].getPassword().equals(passwordAux)) {
                            k = x;
                            flag = true;
                        }
                        else{
                            flag = false;
                        }
                    }
            
                    if(flag) {
                        System.out.println("Bienvenido " + arrayPaciente[k].getNombre() + " " + arrayPaciente[k].getApellido());
                    } else {
                        System.out.println("Usuario o contrasenia incorrectos.");
                    }

                    /*
                     * Presentacion del horario de cita disponible para los pacientes
                     */

                    pass_p = true; // para que no se repita el menu de paciente
                    break;

                case 2: //medico
                
                    menu_login(sb1, sb2);
                    for (int x = 0; x < i; x++) {
                        if(arrayMedico[x].getUsername().equals(usernameAux) && arrayMedico[x].getPassword().equals(passwordAux)) {
                            k = x;
                            flag = true;
                        }
                        else {
                            flag = false;
                        }
                    }
            
                    if(flag) {
                        System.out.println("Bienvenido " + arrayMedico[k].getNombre() + " " + arrayMedico[k].getApellido());
                    } else {
                        System.out.println("Usuario o contrasenia incorrectos.");
                    }


                    /* Por agregar...
                     * Creacion del registro del paciente por el medico
                     * Programacion de las citas medicas
                     */

                    pass_m = true; // Para que no se repita el menu de medico
                    break;
                case 3: //admin
                    System.out.println("\nIngreso como Administrador.");
                    System.out.println("==========================");
                    System.out.println("1. Registrar paciente.");
                    System.out.println("2. Registrar medico.");
                    System.out.println("3. Buscar paciente por ID.");
                    //System.out.println("Mas por agregar...");
                    do{
                        try{
                            System.out.print("\nOpcion: ");
                            opc = Integer.parseInt(input.nextLine());
                            //opc = var;
                            flag = true;
                        } catch (NumberFormatException ex) {
                            System.out.println("Opcion invalida.");
                            flag = false;
                        }
                    } while (opc != 1 && opc !=2 && opc != 3 && flag == false || opc >= 4 || opc <= 0);
                    
                    
                    if (opc == 1) { //Registrar paciente
                        arrayPaciente[j] = new Paciente(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test", id_aux);
                        arrayMedico[i] = new Medico(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test", id_aux);
                        menu_register(arrayPaciente[j], "paciente");
                        System.out.println("Paciente registrado exitosamente.");

                        j++;
                    } else if (opc == 2) { //Registrar medico
                        arrayPaciente[j] = new Paciente(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test", id_aux);
                        arrayMedico[i] = new Medico(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test", id_aux);
                        menu_register(arrayMedico[i], "medico");
                        System.out.println("Medico registrado exitosamente.");

                        i++;
                    } else if (opc == 3) { //buscar paciente por ID
                        do{
                            try {
                                System.out.print("Ingrese el ID del paciente: ");
                                id_aux = Integer.parseInt(input.nextLine());
                                //id_aux = vr;
                            } catch (NumberFormatException ex) {
                                System.out.println("ID invalido.");
                            }
                        } while( id_aux < 100 || id_aux >= 1000);
                        for (int x = 0; x < j; x++) {
                            if(arrayPaciente[x].getId() == id_aux) {
                                k = x;
                                flag = true;
                            }
                            else {
                                flag = false;
                            }
                        }
                
                        if(flag) {
                            System.out.println("Paciente encontrado.");
                            show_persona(arrayPaciente[k]);
                        } else {
                            System.out.println("Paciente no encontrado.");
                        }
                    }
                    break;
            }
            do {
                try{
                    System.out.print("Desea continuar? (1. Si | 2. No): ");
                    var = Integer.parseInt(input.nextLine());
                    flag = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Opcion invalida.");
                    flag = false;
                }
            } while(var != 1 && var != 2 && flag == false || var >= 3 || var <= 0);
            flag = false;

        } while (var == 1);
    }

    // Objeto StringBuilder para pasar 2 parametros Str por referencia (por alguna razon si lo deja con objetos)
    public static void menu_login(StringBuilder sb1, StringBuilder sb2) {
        System.out.println("\nMenu de inicio");
        System.out.println("============================\n");

        System.out.print("Nombre de usuario: ");
        usernameAux = input.nextLine();
        sb1.append(usernameAux);

        System.out.print("Contrasenia: ");
        passwordAux = input.nextLine();
        sb2.append(passwordAux);
    }

    // Mostrar datos del usuario
    public static void show_persona(Persona p) {
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Apellido: " + p.getApellido());
        System.out.println("Edad: " + p.getEdad());
        System.out.println("Username: " + p.getUsername());
        System.out.println("Password: " + p.getPassword());
        System.out.println("ID: " + p.getId());
    }
}

/*
 * Seleccion del tipo de rol e inicio de sesion V
 * Registro de pacientes V
 * Registro de Medicos V
 * Registro de administradores
 * Asignacion de roles por el administrador V
 * Creacion del registro del paciente por el medico
 * Programacion de las citas medicas
 * Presentacion del horario de cita disponible para los pacientes
 */