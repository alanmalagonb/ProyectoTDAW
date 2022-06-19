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
import javax.servlet.http.HttpSession;

/**
 *
 * @author alanm
 */
@WebServlet(name = "IniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

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
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            TrabajadorDTO dto = new TrabajadorDTO();
            dto.getTrabajador().setEmail(email);
            dto.getTrabajador().setPassword(password);
            try{
                TrabajadorDAO dao = new TrabajadorDAO();
                boolean lol = dao.login(dto);
                
                out.println(lol);
                
                if(!lol){
                    response.sendRedirect("login.html");
                } else{
                    dto = dao.get(dto);
                    out.println(dto);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", dto);
                    out.println(dto);
                    if(dto.getRol().getIdRol() == 1){
                        
                        RestauranteDAO rdao = new RestauranteDAO();
                        RestauranteDTO rdto;
                        rdto = rdao.getByOwner(dto);
                        session.setAttribute("restaurante", rdto);
                        response.sendRedirect("dueno.html");
                    }else{
                        response.sendRedirect("trabajador.html");
                    
                    }
                }
            }catch(Exception e){
                out.println(e.getMessage());
            } finally {
                
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
