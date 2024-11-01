package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;

public class ClienteDaoJDBC {
    private static final String sql = "SELECT id_cliente, nombre, apellido, email, telefono, saldo" + " from cliente";
    private static final String sqlSelectById = "SELECT id_cliente, nombre, apellido, email, telefono, saldo" + " from cliente where id_cliente = ?";
    private static final String sqlInsert = "INSERT INTO cliente(nombre, apellido, email, telefono, saldo)" + " VALUES (? ,? , ? , ? , ?)";
    private static final String sqlUpdate = "UPDATE cliente" + "SET nombre = ?, apellido = ?, email = ?, telefono = ?, saldo = ? WHERE id_cliente = ?";
    private static final String sqlDelete = "DELETE FROM cliente WHERE id_cliente = ?";
    
    public List<Cliente>listar() throws SQLException{
        List<Cliente> clientes = new ArrayList<>();
        Connection conn = Conexion.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet res = pstmt.executeQuery();
        while(res.next()){
            int idCliente = res.getInt("id_cliente");
            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            String email = res.getString("email");
            String telefono = res.getString("telefono");
            double saldo = res.getDouble("saldo");
            Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
            clientes.add(cliente);
        }
        Conexion.close(pstmt);
        Conexion.close(res);
        Conexion.connection(conn);
        return clientes;
        
    }
    public Cliente encontrar(Cliente cliente)throws SQLException{
        Connection conn = Conexion.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sqlSelectById, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstmt.setInt(1,cliente.getIdCliente());
        ResultSet res = pstmt.executeQuery();
        res.absolute(1);
        String nombre = res.getString("nombre");
        String apellido = res.getString("apellido");
        String email = res.getString("email");
        String telefono = res.getString("telefono");
        double saldo = res.getDouble("saldo");
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);
        cliente.setSaldo(saldo);
        Conexion.close(pstmt);
        Conexion.close(res);
        Conexion.connection(conn);
        return cliente;
    }
    
    public int insertar(Cliente cliente)throws SQLException{
        Connection conn = Conexion.getConnection();
        int rows;
        PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
        pstmt.setString(1, cliente.getNombre());
        pstmt.setString(2, cliente.getApellido());
        pstmt.setString(3, cliente.getEmail());
        pstmt.setString(4, cliente.getTelefono());
        pstmt.setDouble(5, cliente.getSaldo());
        rows = pstmt.executeUpdate();
        Conexion.close(pstmt);
        Conexion.connection(conn);
        return rows;
    }
    
    public int actualizar(Cliente cliente)throws SQLException{
        Connection conn = Conexion.getConnection();
        int rows;
        PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
        pstmt.setString(1, cliente.getNombre());
        pstmt.setString(2, cliente.getApellido());
        pstmt.setString(3, cliente.getEmail());
        pstmt.setString(4, cliente.getTelefono());
        pstmt.setDouble(5, cliente.getSaldo());
        pstmt.setInt(6, cliente.getIdCliente());
        rows = pstmt.executeUpdate();
        Conexion.close(pstmt);
        Conexion.connection(conn);
        return rows;
    }
    public int eliminar(Cliente cliente)throws SQLException{
        Connection conn = Conexion.getConnection();
        int rows;
        PreparedStatement pstmt = conn.prepareStatement(sqlDelete);
        pstmt.setInt(1, cliente.getIdCliente());
        rows = pstmt.executeUpdate();
        Conexion.close(pstmt);
        Conexion.connection(conn);
        return rows;
    }
}



