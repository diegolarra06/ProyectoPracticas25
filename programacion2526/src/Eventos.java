

import java.util.ArrayList;

public class Eventos {
     private String nombre;
    private String fecha;
    private String duracion;
    private Ubicaciones ubicacion;
    private Categorias categoria;
    private Organizadores organizador;
    private boolean cancelado;
    private ArrayList<Usuarios> asistentes;

    public Eventos(String nombre, String fecha, String duracion, Ubicaciones ubicacion, Categorias categoria, Organizadores organizador) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.organizador = organizador;
        this.cancelado = false;
        this.asistentes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public Ubicaciones getUbicacion() {
        return ubicacion;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public Organizadores getOrganizador() {
        return organizador;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void cancelarEvento() {
        this.cancelado = true;
        System.out.println("El evento " + nombre + " ha sido cancelado.");
    }

    public void agregarAsistente(Usuarios usuario) {
        if (!asistentes.contains(usuario)) {
            asistentes.add(usuario);
        }
    }

    public void cancelarAsistente(Usuarios usuario) {
        asistentes.remove(usuario);
    }

    public void mostrarDetalles() {
        System.out.println("Nombre del evento: " + nombre);
        System.out.println("Fecha: " + fecha);
        System.out.println("Duración: " + duracion);
        System.out.println("Ubicación: " + ubicacion.getDireccion());
        System.out.println("Categoría: " + categoria.getNombre());
        System.out.println("Organizador: " + organizador.getNombre() + " - Contacto: " + organizador.getContacto());
        System.out.println("Estado: " + (cancelado ? "Cancelado" : "Activo"));
        System.out.println("Número de asistentes: " + asistentes.size());
    }
}