package principal;

import conexion.ConexionBD;
import excepciones.DatoInvalidoException;
import excepciones.EventoNoEncontradoException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelos.Evento;
import servicios.EventoServicio;
import utilidades.Entrada;

public class Main {

    private static final EventoServicio eventoServicio = new EventoServicio();

    public static void main(String[] args) {

        if (!ConexionBD.probarConexion()) {
            System.out.println("No fue posible conectarse con la base de datos");
            return;
        }
        int opcion;
        do {
            System.out.println("<<<MENU EVENTOS>>>");
            System.out.println("1. Crear evento");
            System.out.println("2. Editar evento");
            System.out.println("3. Eliminar evento");
            System.out.println("4. Mostrar todos los eventos");
            System.out.println("5. Mostrar eventos programados");
            System.out.println("6. Buscar evento por ID");
            System.out.println("0. Salir");

            opcion = Entrada.leerEntero("Seleccione una opcion");

            switch (opcion) {
                case 1:
                    crearEvento();
                    break;
                case 2:
                    editarEvento();
                    break;
                case 3:
                    eliminarEvento();
                    break;
                case 4:
                    mostrarEventos();
                    break;
                case 5:
                    mostrarEventosProgramados();
                    break;
                case 6:
                    buscarEvento();
                    break;
                case 0:
                    ConexionBD.cerrarConexion();
                    System.out.println("Saliendo, hasta una proxima ocasion");

                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");

            }

        } while (opcion != 0);

    }

    private static void crearEvento() {
        try {
            String idEvento = Entrada.leerTexto("Ingrese id del evento: ");
            String codigo = Entrada.leerTexto("Ingrese el codigo: ");
            String nombre = Entrada.leerTexto("Ingrese el nombre del evento: ");
            String descripcion = Entrada.leerTexto("Ingrese la descripcion del evento: ");
            LocalDate fecha = LocalDate.parse(Entrada.leerTexto("Ingrese la fecha (AAAA-MM-DD): "));
            LocalTime hora = LocalTime.parse(Entrada.leerTexto("Ingrese Hora (HH:MM): "));
            int duracionHoras = Entrada.leerEntero("Ingrese la duracion en horas: ");
            int capacidadMaxima = Entrada.leerEntero("Ingrese la capacidad maxima: ");
            double costo = Entrada.leerDouble("Ingrese el costo: ");
            String estado = Entrada.leerTexto("Ingrese el estado: ");
            String idTipoEvento = Entrada.leerTexto("Ingrese el id tipo de evento");
            String idModalidadEvento = Entrada.leerTexto("Ingrese la modalidad del evento: ");
            String idUbicacion = Entrada.leerTexto("Ingrese id de la ubicacion evento: ");
            String idOrganizador = Entrada.leerTexto("Ingrese id organizador: ");

            Evento evento = new Evento(idEvento, codigo, nombre, descripcion, fecha, hora, duracionHoras, capacidadMaxima,
                    costo, estado, idTipoEvento, idModalidadEvento, idUbicacion, idOrganizador);
            eventoServicio.crear(evento);
            System.out.println("Evento creado con exito");

        } catch (DatoInvalidoException e) {
            System.out.println("Error, " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al crear evento: " + e.getMessage());
        }
    }

    private static void editarEvento() {

        try {
            String idEvento = Entrada.leerTexto("Ingrese id del evento: ");
            Evento existente = eventoServicio.buscarPorId(idEvento);

            System.out.println("Evento encontrado " + existente.getNombre());

            String codigo = Entrada.leerTexto("Ingrese el nuevo codigo: ");
            String nombre = Entrada.leerTexto("Ingrese el nuevo nombre del evento: ");
            String descripcion = Entrada.leerTexto("Ingrese la nueva descripcion del evento: ");
            LocalDate fecha = LocalDate.parse(Entrada.leerTexto("Ingrese la nueva fecha (AAAA-MM-DD): "));
            LocalTime hora = LocalTime.parse(Entrada.leerTexto("Ingrese la nueva Hora (HH:MM): "));
            int duracionHoras = Entrada.leerEntero("Ingrese la nueva duracion en horas: ");
            int capacidadMaxima = Entrada.leerEntero("Ingrese la nueva capacidad maxima: ");
            double costo = Entrada.leerDouble("Ingrese el nuevo costo: ");
            String estado = Entrada.leerTexto("Ingrese el nuevo estado: ");
            String idTipoEvento = Entrada.leerTexto("Ingrese el nuevo id tipo de evento");
            String idModalidadEvento = Entrada.leerTexto("Ingrese la nueva modalidad del evento: ");
            String idUbicacion = Entrada.leerTexto("Ingrese id de la nueva ubicacion evento: ");
            String idOrganizador = Entrada.leerTexto("Ingrese el nuevo id organizador: ");

            Evento eventoActualizado = new Evento(idEvento, codigo, nombre, descripcion, fecha, hora, duracionHoras, capacidadMaxima,
                    costo, estado, idTipoEvento, idModalidadEvento, idUbicacion, idOrganizador);
            eventoServicio.actualizar(existente);
            System.out.println("Evento actualizado con exito");

        } catch (DatoInvalidoException e) {
            System.out.println("Error, " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al crear evento: " + e.getMessage());
        }

    }

    private static void eliminarEvento() {
        try {
            String idEvento = Entrada.leerTexto("Ingrese id del evento a eliminar: ");
            eventoServicio.eliminar(idEvento);
            System.out.println("Evento eliminado correctamente");

        } catch (EventoNoEncontradoException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

    private static void mostrarEventos() {
        ArrayList<Evento> eventos = eventoServicio.listar();
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados");
        } else {
            for (Evento evento : eventos) {
                System.out.println(evento.mostrarInformacion());
            }
        }

    }

    private static void mostrarEventosProgramados() {
    }

    private static void buscarEvento() {
    }
}
