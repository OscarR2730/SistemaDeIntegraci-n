package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EduDataDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<EduData> listarResumenDepartamental() {
        List<EduData> lista = new ArrayList<>();
        String sql = "SELECT u.departamento, SUM(d.total_desertores) AS total_desertores "
                   + "FROM hecho_desercion d "
                   + "INNER JOIN dim_ubicacion u ON d.fk_ubicacion = u.id_ubicacion "
                   + "GROUP BY u.departamento "
                   + "ORDER BY total_desertores DESC";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EduData data = new EduData();
                data.setDepartamento(rs.getString("departamento"));
                data.setTotalMatriculados(rs.getInt("total_desertores"));
                lista.add(data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}

