package escom.ipn.restaurantes.data.controller;

import escom.ipn.restaurantes.data.dao.TrabajadorDAO;
import escom.ipn.restaurantes.data.dto.TrabajadorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alanm
 */
@WebServlet(name = "AgregarTrabajadorSucursal", urlPatterns = {"/AgregarTrabajadorSucursal"})
public class AgregarTrabajadorSucursal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarTrabajadorSucursal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarTrabajadorSucursal at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            String email = request.getParameter("email");
            int idRol = Integer.parseInt(request.getParameter("rol"));
            int idSucursal = Integer.parseInt(request.getParameter("sucursal"));
            TrabajadorDTO dto = new TrabajadorDTO();
            dto.getTrabajador().setEmail(email);
            dto.getRol().setIdRol(idRol);
            dto.getSucursal().setIdSucursal(idSucursal);
            try{
                TrabajadorDAO dao = new TrabajadorDAO();
                dao.emplearSucursal(dto);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}