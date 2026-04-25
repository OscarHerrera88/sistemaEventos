package dao;

import conexion.ConexionBD;
import interfaces.Crud;
import modelos.Evento;
import excepciones.EventoNoEncontradoException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EventoDao implements Crud<Evento, String> {

    @Override
    public void crear(Evento evento) {
        String sql = "insert into evento(idevento,codigo,nombre,descripcion,,fecha,hora,"
                + " duracionhoras,capacidadmaxima,costo,estado,idtipoevento,idmodalidadevento,"
                + " idubicacion,idorganizador) values()??????????????)";

        try {
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, evento.getIdEvento());
            ps.setString(2, evento.getCodigo());
            ps.setString(3, evento.getNombre());
            ps.setString(4, evento.getDescripcion());

            ps.setDate(5, java.sql.Date.valueOf(evento.getFecha()));
            ps.setTime(6, java.sql.Time.valueOf(evento.getHora()));

            ps.setInt(7, evento.getDuracionHoras());
            ps.setInt(8, evento.getCapacidadMaxima());
            ps.setDouble(9, evento.getCosto());
            ps.setString(10, evento.getEstado());
            ps.setString(11, evento.getIdTipoEvento());
            ps.setString(12, evento.getIdModalidadEvento());
            ps.setString(13, evento.getIdUbicacion());
            ps.setString(14, evento.getIdOrganizador());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al crear evento: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Evento> listar() throws SQLException {
        ArrayList<Evento> lista = new ArrayList<>();
        String sql = "select * from evento order by fecha,hora";

        try {
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Evento evento = new Evento(
                        rs.getString("idevento"),
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora").toLocalTime(),
                        rs.getInt("duracionhoras"),
                        rs.getInt("capacidadmaxima"),
                        rs.getDouble("costo"),
                        rs.getString("estado"),
                        rs.getString("idtipoevento"),
                        rs.getString("idmodalidadevento"),
                        rs.getString("idubicacion"),
                        rs.getString("idorganizador")
                );
                lista.add(evento);

            }

            ps.executeUpdate();
            ps.close();
            

        } catch (SQLException e) {
            System.out.println("Error al crear evento: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Evento buscarPorId(String id) throws SQLException, EventoNoEncontradoException {

    }

    @Override
    public void actualizar(Evento evento) throws SQLException, EventoNoEncontradoException {
    }

    @Override
    public void eliminar(String id) throws SQLException, EventoNoEncontradoException {
    }
}
