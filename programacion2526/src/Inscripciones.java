public class Inscripciones {
    private Usuarios usuario;
    private Eventos evento;
    public Inscripciones(Usuarios usuario, Eventos evento) {
        this.usuario = usuario;
        this.evento = evento;
    }
    public Usuarios getUsuario() {
        return usuario;
    }
    public Eventos getEvento() {
        return evento;
    }
}
