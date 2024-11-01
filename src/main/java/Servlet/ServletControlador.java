package Servlet;

import datos.ClienteDaoJDBC;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import models.Cliente;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String accion = req.getParameter("accion");
        
        String accionGet = req.getParameter("accion");
        
        if (accion.equals("cliente")) {
            this.accionDefault(req, resp);
        }
        
        if (accionGet != null) {
            switch (accionGet) {
                
                case "editar":
                    this.editarCliente(req, resp);
                    break;

                /*case "eliminar":
                    this.eliminarCliente(req, resp);
                    break;*/
                default:
                    this.accionDefault(req, resp);
                
            }
        }
        
    }
    
    private void accionDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            List<Cliente> clientes = new ClienteDaoJDBC().listar();
            req.setAttribute("clientes", clientes);
            req.setAttribute("totalClientes", clientes.size());
            req.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
            req.getRequestDispatcher("clientes.jsp").forward(req, resp);
            
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    
    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }
    
    private void editarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        try {
            Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
            req.setAttribute("cliente", cliente);
            req.getRequestDispatcher("/WEB-INF/cliente/editar.jsp").forward(req, resp);
        } catch (SQLException ex) {
            req.setAttribute("Error", ex.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion.equals("insertar")) {
            this.insertarCliente(req, resp);
        }
        if (accion.equals("modificar")) {
            this.modificarCliente(req, resp);
        }
        
    }
    
    private void insertarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        saldo = Double.valueOf(saldoString);
        try {
            Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
            cliente.validarFormulario();
            new ClienteDaoJDBC().insertar(cliente);
            this.accionDefault(req, resp);
        } catch (IllegalArgumentException IaEx) {
            req.setAttribute("Error", IaEx.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            
        } catch (SQLException sql) {
            req.setAttribute("Error", sql.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
        
    }

    private void modificarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        saldo = Double.valueOf(saldoString);
        try {
            Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
           // cliente.validarFormulario();
            int registroModificados = new ClienteDaoJDBC().actualizar(cliente);
            this.accionDefault(req, resp);
        } catch (IllegalArgumentException IaEx) {
            req.setAttribute("Error", IaEx.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        } 
        catch (SQLException sqlEx) {
            req.setAttribute("Error", sqlEx.getMessage());
        }
    }
}
