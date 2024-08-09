package dao.impl;

import dao.DatabaseConnection;
import dao.IDao;
import models.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoH2Impl implements IDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoH2Impl.class);
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection conn = DatabaseConnection.startConnection();
        final String SQL_INSERT = "INSERT INTO ODONTOLOGOS " +
                "(MATRICULA, NOMBRE, APELLIDO) VALUES(?, ?, ?)";

        try {
            PreparedStatement pStmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            pStmt.setInt(1, odontologo.getMatricula());
            pStmt.setString(2, odontologo.getNombre());
            pStmt.setString(3, odontologo.getApellido());

            pStmt.execute();


            ResultSet rs = pStmt.getGeneratedKeys();

            if (rs.next()) {
                odontologo.setId(rs.getInt(1));
                logger.info("Odontologo Guardado: " + odontologo);
            }

        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            try {
                if (conn != null) DatabaseConnection.endConnection(conn);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection conn = DatabaseConnection.startConnection();
        final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
        List<Odontologo> listaOdontologos = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);

            while (rs.next()) {
                Integer idDB = rs.getInt("ID");
                Integer matriculaDB = rs.getInt("MATRICULA");
                String nombreDB = rs.getString("NOMBRE");
                String apellidoDB = rs.getString("APELLIDO");

                Odontologo odontologo = new Odontologo(idDB, matriculaDB, nombreDB, apellidoDB);
                listaOdontologos.add(odontologo);
            }

            listaOdontologos.forEach(logger::info);
            System.out.println("---------------LISTA DE ODONTOLOGOS---------------");
            listaOdontologos.forEach(System.out::println);
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            try {
                if (conn != null) DatabaseConnection.endConnection(conn);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return listaOdontologos;
    }
}
