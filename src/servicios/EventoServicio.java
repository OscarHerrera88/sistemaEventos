package servicios;

import dao.EventoDao;
import excepciones.DatoInvalidoException;
import excepciones.EventoNoEncontradoException;
import java.util.ArrayList;
import modelos.Evento;

public class EventoServicio {

    private EventoDao eventoDao;

    public EventoServicio() {
        this.eventoDao = new EventoDao();
    }

    public void crear(Evento evento) throws DatoInvalidoException {
        if (evento == null) {
            throw new DatoInvalidoException("el evento no puede ser nulo");
        }
        eventoDao.crear(evento);
    }

    public ArrayList<Evento> listar() {
        return eventoDao.listar();
    }

    public ArrayList<Evento> listarProgramados() {
        return eventoDao.listarProgramados();
    }

    public Evento buscarPorId(String id) throws EventoNoEncontradoException {
        Evento evento = eventoDao.buscarPorId(id);
        if (evento == null) {
            throw new EventoNoEncontradoException(" No se encontro el evento con id: " + id);

        }
        return evento;
    }

    public void actualizar(Evento evento) throws DatoInvalidoException, EventoNoEncontradoException {
        if (evento == null) {
            throw new DatoInvalidoException("El evento no puede ser nulo");
        }
        Evento existente = eventoDao.buscarPorId(evento.getIdEvento());
        if (existente == null) {
            throw new EventoNoEncontradoException("No se encontro el evento para actualizar");
        }
        eventoDao.actualizar(evento);
    }

    public void eliminar(String id) throws EventoNoEncontradoException {
        Evento existente = eventoDao.buscarPorId(id);
        if (existente == null) {
            throw new EventoNoEncontradoException("No se encontro el evento para eliminar");
        }    
        eventoDao.eliminar(id);
    }
}
