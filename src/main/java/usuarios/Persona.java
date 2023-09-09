package usuarios;


public class Persona {
    public String nombre;
    public String apellido;
    public int edad;
    public String username;
    public String password; //Encriptarla luego
    public int rol; // 1 -> Paciente | 2 -> Medico | 3 -> Admin

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getRol() {
        return rol;
    }
    public void setRol(int rol) {
        this.rol = rol;
    }

    
}
