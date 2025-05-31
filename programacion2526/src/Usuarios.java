import java.util.ArrayList;

public class Usuarios {
     private String nombre;
    private String correo;
    private String contrasena;
    private ArrayList<Eventos> eventosInscritos;

    public Usuarios(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.eventosInscritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void inscribirEvento(Eventos evento) {
        if (!eventosInscritos.contains(evento)) {
            eventosInscritos.add(evento);
            evento.agregarAsistente(this);
            System.out.println(nombre + " se ha inscrito en el evento: " + evento.getNombre());
        } else {
            System.out.println(nombre + " ya está inscrito en el evento: " + evento.getNombre());
        }
    }

    public void cancelarInscripcion(Eventos evento) {
        if (eventosInscritos.contains(evento)) {
            eventosInscritos.remove(evento);
            evento.cancelarAsistente(this);
            System.out.println(nombre + " ha cancelado la inscripción en el evento: " + evento.getNombre());
        } else {
            System.out.println(nombre + " no está inscrito en el evento: " + evento.getNombre());
        }
    }

    public void mostrarEventosInscritos() {
        System.out.println("Eventos inscritos de " + nombre + ":");
        if (eventosInscritos.isEmpty()) {
            System.out.println("  No hay eventos inscritos.");
        } else {
            for (Eventos e : eventosInscritos) {
                System.out.println("  - " + e.getNombre() + " en " + e.getFecha());
            }
        }
    }
}
