package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDCategoria extends Conexion {

    public List<CategoriaProducto> listarCategorias() {
        List<CategoriaProducto> listaCategorias = new ArrayList<>();
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return listaCategorias;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_listar_categorias()}")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");

                CategoriaProducto categoria = new CategoriaProducto(id, nombre);
                listaCategorias.add(categoria);
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al listar categorías", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return listaCategorias;
    }

    public List<CategoriaProducto> buscarCategoriaProductoPorNombre(String textoBusqueda) {
        List<CategoriaProducto> categoriasEncontradas = new ArrayList<>();
        Connection cnx = getConexion();
        if (cnx == null) {
            Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "No se pudo establecer conexión con la base de datos.");
            return categoriasEncontradas;
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_buscar_categoria_por_nombre(?)}")) {
            stmt.setString(1, textoBusqueda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");

                CategoriaProducto categoria = new CategoriaProducto(id, nombre);
                categoriasEncontradas.add(categoria);
            }
        } catch (SQLException e) {
            Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al buscar categorías por nombre", e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
        return categoriasEncontradas;
    }

    public String agregarCategoria(CategoriaProducto categoria) {
        Connection cnx = getConexion();
        if (cnx == null) {
            return "No se pudo establecer conexión con la base de datos.";
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_agregar_categoria(?)}")) {
            stmt.setString(1, categoria.getNombre());

            stmt.execute();
            return "Categoría agregada correctamente.";
        } catch (SQLException e) {
            Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al agregar categoría", e);
            return "Error: " + e.getMessage();
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }

    public String actualizarCategoria(CategoriaProducto categoria) {
        Connection cnx = getConexion();
        if (cnx == null) {
            return "No se pudo establecer conexión con la base de datos.";
        }

        try (CallableStatement stmt = cnx.prepareCall("{CALL sp_actualizar_categoria(?, ?)}")) {
            stmt.setInt(1, categoria.getId());
            stmt.setString(2, categoria.getNombre());

            stmt.execute();
            return "Categoría actualizada correctamente.";
        } catch (SQLException e) {
            Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al actualizar categoría", e);
            return "Error: " + e.getMessage();
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }

            public String eliminarCategoria(Long idCategoria) {
            Connection cnx = getConexion();
            if (cnx == null) {
                return "No se pudo establecer conexión con la base de datos.";
            }

            try (CallableStatement stmt = cnx.prepareCall("{CALL sp_eliminar_categoria(?)}")) {
                stmt.setLong(1, idCategoria);

                stmt.execute();
                return "Categoría eliminada correctamente.";
            } catch (SQLException e) {
                Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al eliminar categoría", e);
                return "Error: " + e.getMessage();
            } finally {
                try {
                    cnx.close();
                } catch (SQLException e) {
                    Logger.getLogger(CRUDCategoria.class.getName()).log(Level.SEVERE, "Error al cerrar conexión", e);
            }
        }
    }
}
