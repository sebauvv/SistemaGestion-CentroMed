package usuarios;

public class Medico extends Persona{
    String especializacion;

    public Medico(String nombre, String apellido, int edad, String username, String password, int rol,
            String especializacion) {
        super(nombre, apellido, edad, username, password, rol);
        this.especializacion = especializacion;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    
    
}
