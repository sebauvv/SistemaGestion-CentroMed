package usuarios;

public class Paciente extends Persona{
    String diagnostico; // Pensado en pasarlo a un file

    public Paciente(String nombre, String apellido, int edad, String username, String password, int rol,
            String diagnostico, int id) {
        super(nombre, apellido, edad, username, password, rol, id);
        this.diagnostico = diagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    
    
}
