package main;

import login.Ventana_Login;
//import usuarios.Administrador;
import usuarios.Medico;
import usuarios.Paciente;
import usuarios.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int opc, var;
    static int rol;
    static String seguir;
    static boolean flag, pass_p, pass_m;
    public static String nameAux, apellidoAux, usernameAux, passwordAux;
    public static int edadAux;
    static Scanner input = new Scanner(System.in);
    

    public static void main(String[] args) {
        
        Paciente arrayPaciente[] = new Paciente[50];
        Medico arrayMedico[] = new Medico[50];
        int k = 0; // aux pos int variable
        int j = 0; // j debe contener la canitdad de pacientes registrados actualmente
        int i = 0; // i debe contener la cantidad de medicos registrados actualmente

        // List<Paciente> p_list = new ArrayList<>();
        // List<Medico> m_list = new ArrayList<>();


        arrayPaciente[j] = new Paciente(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test");
        arrayMedico[i] = new Medico(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test");

        Ventana_Login vl = new Ventana_Login();

        do{
            vl.menu_inicio();

            do {
                System.out.print("Opcion: ");
                var = Integer.parseInt(input.nextLine());
                rol = var;
                if (pass_p == false && rol == 1) {
                    System.out.println("No hay pacientes registrados.");
                }
                else if (pass_m == false && rol == 2) {
                    System.out.println("No hay medicos registrados.");
                }
                else if (j == 0 && rol == 1) {
                    System.out.println("No hay pacientes registrados.");
                }
                else if (i == 0 && rol == 2) {
                    System.out.println("No hay medicos registrados.");
                }
                else {
                    flag = true;
                }

                // }
                // else if ((j == 0 && rol != 3) || pass_p == false ) {
                //     System.out.println("No hay pacientes registrados.");
                //     flag = false;
                // }
                // else if ((i == 0 && rol != 3) || pass_m == false) {
                //     System.out.println("No hay medicos registrados.");
                //     flag = false;
                // }
                // else {
                //     flag = true;
                // }
            } while ((flag  == false) || (rol < 1 || rol > 3));

            //StringBuilder: objeto mutable para pasar por referencia (las strings son inmutables aaaa)
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            switch (rol) { 
                case 1: //Paciente
                    //System.out.println(j);
                    // for(i = 0; i < j; i++) {
                    //     System.out.println("Lista de usuarios y su contrasenia: ");
                    //     System.out.println("Usuario: " + arrayPaciente[i].getUsername() + " Contrasenia: " + arrayPaciente[i].getPassword());
                    //     System.out.println(" ");
                    // }
                    
                    menu_login(sb1, sb2);
                    usernameAux = sb1.toString();
                    passwordAux = sb2.toString();
                    //System.out.println(usernameAux + " " + passwordAux);

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

                    System.out.println("\nIngreso como Medico.");
                    System.out.println("===============================");
                    /*
                     * Creacion del registro del paciente por el medico
                     * Programacion de las citas medicas
                     */

                    pass_m = true; // para que no se repita el menu de medico
                    break;
                case 3: //admin
                    System.out.println("\nIngreso como Administrador.");
                    System.out.println("==========================");
                    System.out.println("1. Registrar paciente");
                    System.out.println("2. Registrar medico");
                    //System.out.println("Mas por agregar...");
                    do{
                        System.out.print("\nOpcion: ");
                        var = Integer.parseInt(input.nextLine());
                        opc = var;
                    } while (opc != 1 && opc !=2);
                    
                    if (opc == 1) {
                        arrayPaciente[j] = new Paciente(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test");
                        arrayMedico[i] = new Medico(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test");
                        //System.out.println(j);
                        vl.menu_register(arrayPaciente[j], "paciente");
                        System.out.println("Paciente registrado exitosamente.");
                        //Test(arrayPaciente[j]); 

                        j++;
                    } else if (opc == 2) {
                        arrayPaciente[j] = new Paciente(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test");
                        arrayMedico[i] = new Medico(nameAux, apellidoAux, edadAux, usernameAux, passwordAux, rol, "test");
                        vl.menu_register(arrayMedico[i], "medico");
                        System.out.println("Medico registrado exitosamente.");
                        //Test(arrayMedico[i]);

                        i++;
                    }
                    break;
            }
            System.out.print("Desea continuar? (1. Si | 2. No): ");
            var = Integer.parseInt(input.nextLine());  
        } while (var == 1);
    }

    public static void Test(Persona p) {
        try {
            System.out.println(p.getNombre());
            System.out.println(p.apellido);
            System.out.println(p.edad);
            System.out.println(p.username);
            //System.out.println(p.contrasenia);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException shown");
        }
    }

    // Objeto StringBuilder para pasar 2 parametros Str por referencia (por alguna razon si lo deja con objetos)
    public static void menu_login(StringBuilder sb1, StringBuilder sb2) {
        System.out.println("\nMenu de inicio");
        System.out.println("============================\n");

        System.out.print("Nombre de usuario: ");
        usernameAux = input.nextLine();
        sb1.append(usernameAux);
        //input.nextLine(); //buffer problem YA NO

        System.out.print("Contrasenia: ");
        passwordAux = input.nextLine();
        sb2.append(passwordAux);
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