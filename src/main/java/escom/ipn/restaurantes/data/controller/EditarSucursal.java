package escom.ipn.restaurantes.data.controller;

import escom.ipn.restaurantes.data.dao.SucursalDAO;
import escom.ipn.restaurantes.data.dto.RestauranteDTO;
import escom.ipn.restaurantes.data.dto.SucursalDTO;
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
@WebServlet(name = "EditarSucursal", urlPatterns = {"/EditarSucursal"})
public class EditarSucursal extends HttpServlet {

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
            String nombre = request.getParameter("nombre");
            String calle = request.getParameter("calle");
            String colonia = request.getParameter("colonia");
            int noExt = Integer.parseInt(request.getParameter("numext"));
            int noInt = Integer.parseInt(request.getParameter("numint"));;
            int idMunicipio = Integer.parseInt(request.getParameter("municipio"));
            int idEstado = Integer.parseInt(request.getParameter("estado"));
            String telefono = request.getParameter("telefono");
            SucursalDTO dto = new SucursalDTO();
            dto.getSucursal().setNombreSucursal(nombre);
            dto.getSucursal().setCalle(calle);
            dto.getSucursal().setColonia(colonia);
            dto.getSucursal().setNumeroExterior(noExt);
            dto.getSucursal().setNumeroInterior(noInt);
            dto.getMunicipio().setIdMunicipio(idMunicipio);
            dto.getEstado().setIdEstado(idEstado);
            dto.getSucursal().setTelefono(telefono);
            int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
            dto.getSucursal().setIdSucursal(idSucursal);
            
            try{
                SucursalDAO dao = new SucursalDAO();
                dao.update(dto);
                response.sendRedirect("sucursales.jsp");
                
            }catch(Exception e){
                out.print(e.getMessage());
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
