import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Categorias> categorias = new ArrayList<>();
        ArrayList<Ubicaciones> ubicaciones = new ArrayList<>();
        ArrayList<Organizadores> organizadores = new ArrayList<>();
        ArrayList<Eventos> eventos = new ArrayList<>();
        ArrayList<Usuarios> usuarios = new ArrayList<>();
    categorias.add(new Categorias ("Conferencia"));
    categorias.add(new Categorias ("Taller"));
    categorias.add(new Categorias ("Los objetivos de Desarrollo Sostenible de la ONU"));
    ubicaciones.add(new Ubicaciones ("Sala de Conferencias, Centro Ecológico"));
    ubicaciones.add(new Ubicaciones ("Centro Comunitario Verde, Calle Ecología 123, Ciudad Verde"));
    ubicaciones.add(new Ubicaciones ("Sala de Conferencias Internacional, Hotel Naciones, Ciudad Global"));
    organizadores.add(new Organizadores("EcoEventos", "contacto@ecoorg.com"));
    organizadores.add(new Organizadores("Fundación EcoCreativo", "info@sostenibilidad.com"));
    eventos.add(new Eventos("Conferencia sobre Energía Renovable", "17 de Noviembre de 2025", "3 horas", ubicaciones.get(0), categorias.get(0), organizadores.get(0)));
    eventos.add(new Eventos("Taller de Reciclaje", "20 de Noviembre de 2025", "3 horas", ubicaciones.get(1), categorias.get(1), organizadores.get(1)));
    usuarios.add(new Usuarios("Diego Larra", "diegolarra06@gmail.com", "1234"));
    usuarios.add(new Usuarios("Pedro Sanchez", "pr10@gmail.com", "abcd"));
        boolean salir = false;
        while (!salir) {
            System.out.println("\n- Portal de Eventos Sostenibles -");
            System.out.println("1. Ver eventos disponibles");
            System.out.println("2. Inscribir usuario a un evento");
            System.out.println("3. Cancelar inscripción");
            System.out.println("4. Mostrar eventos inscritos por usuario");
            System.out.println("5. Cancelar un evento");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                
                case 1:
                    System.out.println("Eventos disponibles");
                    for (int i = 0; i < eventos.size(); i++) {
                        Eventos ev = eventos.get(i);
                        System.out.println("[" + i + "] " + ev.getNombre() + " (" + ev.getFecha() + ") - " + (ev.isCancelado() ? "Cancelado" : "Activo"));
                    }
                    break;
                
                
                    case 2:
                    System.out.print("Ingrese el índice del usuario: ");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println("[" + i + "] " + usuarios.get(i).getNombre());
                    }
                    int idxUsuario = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el índice del evento: ");
                    for (int i = 0; i < eventos.size(); i++) {
                        System.out.println("[" + i + "] " + eventos.get(i).getNombre());
                    }
                    int idxEvento = sc.nextInt();
                    sc.nextLine();
                    if (esIndiceValido(idxUsuario, usuarios.size()) && esIndiceValido(idxEvento, eventos.size())) {
                        Usuarios usu = usuarios.get(idxUsuario);
                        Eventos eve = eventos.get(idxEvento);
                        if (!eve.isCancelado()) {
                            usu.inscribirEvento(eve);
                        } else {
                            System.out.println("No se puede inscribir, el evento está cancelado.");
                        }
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
             case 3:
                    System.out.print("Ingrese el índice del usuario: ");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println("[" + i + "] " + usuarios.get(i).getNombre());
                    }
                    idxUsuario = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el índice del evento: ");
                    for (int i = 0; i < eventos.size(); i++) {
                        System.out.println("[" + i + "] " + eventos.get(i).getNombre());
                    }
                    idxEvento = sc.nextInt();
                    sc.nextLine();
                    if (esIndiceValido(idxUsuario, usuarios.size()) && esIndiceValido(idxEvento, eventos.size())) {
                        Usuarios usu = usuarios.get(idxUsuario);
                        Eventos eve = eventos.get(idxEvento);
                        usu.cancelarInscripcion(eve);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                 
                    case 4:
                    System.out.print("Ingrese el índice del usuario: ");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println("[" + i + "] " + usuarios.get(i).getNombre());
                    }
                    idxUsuario = sc.nextInt();
                    sc.nextLine();
                    if (esIndiceValido(idxUsuario, usuarios.size())) {
                        Usuarios usu = usuarios.get(idxUsuario);
                        usu.mostrarEventosInscritos();
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                
                    case 5:
                    System.out.print("Ingrese el índice del evento a cancelar: ");
                    for (int i = 0; i < eventos.size(); i++) {
                        Eventos ev = eventos.get(i);
                        System.out.println("[" + i + "] " + ev.getNombre() + " (" + (ev.isCancelado() ? "Cancelado" : "Activo") + ")");
                    }
                    idxEvento = sc.nextInt();
                    sc.nextLine();
                    if (esIndiceValido(idxEvento, eventos.size())) {
                        Eventos eve = eventos.get(idxEvento);
                        eve.cancelarEvento();
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                
                    case 6:
                    salir = true;
                    System.out.println("Gracias por usar el portal.");
                    break;
                default:
                    System.out.println("Opción no válido.");
                }
        }
                sc.close();
    }

    public static boolean esIndiceValido(int indice, int tamaño) {
        return indice >= 0 && indice < tamaño;
    } 
}
