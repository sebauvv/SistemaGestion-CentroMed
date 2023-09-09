package main;

import login.Ventana_Login;

public class Main {

    public static void main(String[] args) {

        Ventana_Login vl = new Ventana_Login();
        System.out.println(vl.menu_login());
    }
}

/*
 * Seleccion del tipo de rol e inicio de sesion
 * Registro de pacientes
 * Registro de Medicos
 * Registro de administradores
 * Asignacion de roles por el administrador
 * Creacion del registro del paciente por el medico
 * Programacion de las citas medicas
 * Presentacion del horario de cita disponible para los pacientes
 */