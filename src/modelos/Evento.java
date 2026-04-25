package modelos;

import excepciones.DatoInvalidoException;

public class Evento {

    private String idEvento;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String fecha;
    private String hora;
    private int duracionHoras;
    private int capacidadMaxima;
    private double costo;
    private String estado;
    private String idTipoEvento;
    private String idModalidadEvento;
    private String idUbicacion;
    private String idOrganizador;

    public Evento() {

    }

    public Evento(String idEvento, String codigo, String nombre, String descripcion,
            String fecha, String hora, int duracionHoras, int capacidadMaxima, double costo,
            String estado, String idTipoEvento, String idModalidadEvento, String idUbicacion,
            String idOrganizador) throws DatoInvalidoException {

        setIdEvento(idEvento);
        setCodigo(codigo);
        setNombre(nombre);
        setDescripcion(descripcion);
        setFecha(fecha);
        setHora(hora);
        setDuracionHoras(duracionHoras);
        setCapacidadMaxima(capacidadMaxima);
        setCosto(costo);
        setEstado(estado);
        setIdTipoEvento(idTipoEvento);
        setIdModalidadEvento(idModalidadEvento);
        setIdUbicacion(idUbicacion);
        setIdOrganizador(idOrganizador);
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) throws DatoInvalidoException {
        if (idEvento == null || idEvento.trim().isEmpty()) {
            throw new DatoInvalidoException("El id del evento no puede estar vacio");
        }
        this.idEvento = idEvento.trim();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws DatoInvalidoException {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new DatoInvalidoException("El codigo del evento no puede estar vacio");
        }
        this.codigo = codigo.trim();
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws DatoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre del evento no puede estar vacio");
        }
        this.nombre = nombre.trim();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) throws DatoInvalidoException {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new DatoInvalidoException("La descripcion del evento no puede estar vacio");
        }
                this.descripcion = descripcion.trim();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) throws DatoInvalidoException {
        if (fecha == null || fecha.trim().isEmpty()) {
            throw new DatoInvalidoException("La fecha del evento no puede estar vacio");
        }
        this.fecha = fecha.trim();
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) throws DatoInvalidoException {
        if (hora == null || hora.trim().isEmpty()) {
            throw new DatoInvalidoException("La hora del evento no puede estar vacio");
        }
        this.hora = hora.trim();
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) throws DatoInvalidoException {
        if(duracionHoras<=0){
        throw new DatoInvalidoException("La duracion debe ser mayor a 0");
        }
        this.duracionHoras = duracionHoras;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) throws DatoInvalidoException {
        if(capacidadMaxima<=0){
        throw new DatoInvalidoException("La capacidad maxima debe ser mayor a 0");
        }
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) throws DatoInvalidoException {
        if(costo<=0){
        throw new DatoInvalidoException("El costo debe ser mayor a 0");
        }
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws DatoInvalidoException {
        if (estado == null || estado.trim().isEmpty()) {
            throw new DatoInvalidoException("El estado del evento no puede estar vacio");
        }
        this.estado = estado.trim();
    }

    public String getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(String idTipoEvento) throws DatoInvalidoException {
        if (idTipoEvento == null || idTipoEvento.trim().isEmpty()) {
            throw new DatoInvalidoException("El id tipo evento no puede estar vacio");
        }        
        this.idTipoEvento = idTipoEvento.trim();
    }

    public String getIdModalidadEvento() {
        return idModalidadEvento;
    }

    public void setIdModalidadEvento(String idModalidadEvento) throws DatoInvalidoException {
        if (idModalidadEvento == null || idModalidadEvento.trim().isEmpty()) {
            throw new DatoInvalidoException("El id modalidad del evento no puede estar vacio");
        }
        this.idModalidadEvento = idModalidadEvento.trim();
    }

    public String getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(String idUbicacion) throws DatoInvalidoException {
        if (idUbicacion == null || idUbicacion.trim().isEmpty()) {
            throw new DatoInvalidoException("El id ubicacion del evento no puede estar vacio");
        }
        this.idUbicacion = idUbicacion.trim();
    }

    public String getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(String idOrganizador) throws DatoInvalidoException {
        if (idOrganizador == null || idOrganizador.trim().isEmpty()) {
            throw new DatoInvalidoException("El id organizador del evento no puede estar vacio");
        }
        this.idOrganizador = idOrganizador.trim();
    }

    @Override
    public String toString() {
        return "Evento{" + "idEvento=" + 
                idEvento + ", codigo=" 
                + codigo + ", nombre=" 
                + nombre + ", descripcion=" 
                + descripcion + ", fecha=" 
                + fecha + ", hora=" + hora 
                + ", duracionHoras=" + duracionHoras 
                + ", capacidadMaxima=" + capacidadMaxima 
                + ", costo=" + costo 
                + ", estado=" + estado 
                + ", idTipoEvento=" + idTipoEvento 
                + ", idModalidadEvento=" + idModalidadEvento 
                + ", idUbicacion=" + idUbicacion 
                + ", idOrganizador=" + idOrganizador + '}';
    }

}
                                                            