package escom.ipn.restaurantes.data.controller;

import escom.ipn.restaurantes.data.dao.RestauranteDAO;
import escom.ipn.restaurantes.data.dao.TrabajadorDAO;
import escom.ipn.restaurantes.data.dto.RestauranteDTO;
import escom.ipn.restaurantes.data.dto.TrabajadorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrarTrabajador", urlPatterns = {"/RegistrarTrabajador"})
public class RegistrarTrabajador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String nombre = request.getParameter("nombre");
            String apellidoMaterno = request.getParameter("materno");
            String apellidoPaterno = request.getParameter("paterno");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            String dueno = request.getParameter("dueno");
            String nombreRestaurante = request.getParameter("restaurante");
            TrabajadorDTO dto = new TrabajadorDTO();
            dto.getTrabajador().setNombreTrabajador(nombre);
            dto.getTrabajador().setApellidoMaterno(apellidoMaterno);
            dto.getTrabajador().setApellidoPaterno(apellidoPaterno);
            dto.getTrabajador().setEmail(email);
            dto.getTrabajador().setPassword(password);
            try{
               TrabajadorDAO dao = new TrabajadorDAO();
               dto = dao.register(dto);
               if(dueno!=null) {
                   RestauranteDTO rdto = new RestauranteDTO();
                   rdto.getDueno().setIdTrabajador(dto.getTrabajador().getIdTrabajador());
                   rdto.getRestaurante().setLogo("");
                   rdto.getRestaurante().setNombreRestaurante(nombreRestaurante);
                   RestauranteDAO rdao = new RestauranteDAO();
                   rdao.save(rdto);
               }
            }catch(Exception e){
               e.printStackTrace();
            }
            /* SESIÓN */
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
