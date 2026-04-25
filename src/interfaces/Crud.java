
package interfaces;

import java.util.List;


public interface Crud <T, ID> {
    void crear (T objeto);
    void actualizar (T objeto);
    void eliminar (ID id);
    T buscarPorId(ID id);
    List<T>listar();
}
