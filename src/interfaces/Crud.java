
package interfaces;

import java.util.ArrayList;
import java.util.List;


public interface Crud <T, ID> {
    void crear (T objeto);
    void actualizar (T objeto);
    void eliminar (String id);
    T buscarPorId(String id);
    ArrayList<T>listar();
    }
