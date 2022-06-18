<%-- 
    Document   : sucursales
    Created on : 13 jun. 2022, 23:06:39
    Author     : alanm
--%>

<%@page import="escom.ipn.restaurantes.data.dto.TrabajadorDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="escom.ipn.restaurantes.data.dto.SucursalDTO"%>
<%@page import="escom.ipn.restaurantes.data.dto.RestauranteDTO"%>
<%@page import="escom.ipn.restaurantes.data.dao.SucursalDAO"%>
<%@page import="java.util.Map"%>
<%@page import="java.lang.Integer"%>
<%@page import="utils.Catalogos"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Administrador - Dashboard</title>

    <!-- Custom fonts for this template-->
    <script src="https://kit.fontawesome.com/05005d4b0d.js" crossorigin="anonymous"></script>
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fa-solid fa-mug-saucer"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Restaurantes</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Panel de control</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Restaurante
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fa-solid fa-database"></i>
                    <span>Datos</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Opciones</h6>
                        <a class="collapse-item" href="datos.jsp">Datos</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fa-solid fa-shop"></i>
                    <span>Sucursales</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Opciones</h6>
                        <a class="collapse-item" href="sucursales.jsp">Sucursales</a>
                    </div>
                </div>
            </li>
            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fa-solid fa-layer-group"></i>
                    <span>Inventario</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Opciones</h6>
                        <a class="collapse-item" href="inventario.jsp">Inventario</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="receta.jsp">
                    <i class="fa-solid fa-file-waveform"></i>
                    <span>Receta</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="menu.jsp">
                    <i class="fa-solid fa-burger"></i>
                    <span>Menu</span></a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="trabajadores.jsp">
                    <i class="fa-solid fa-users-line"></i>
                    <span>Trabajadores</span></a>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Juan Pérez</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <!-- <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div> -->
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid" style="display: flex; flex-direction: column; align-items: center; max-width: 60vw;">
                    <!-- Content Row -->
                    <div style="background:white; border-radius: 10px; padding: 10px; box-shadow: 3px 3px 5px 5px lightgray"> 
                        <form style="padding: 20px" method="POST" action="AgregarSucursal">
                            <div class="mb-3">
                                <label for="formGroupExampleInput" class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre de la Sucursal" required>
                                <label for="formGroupExampleInput" class="form-label" style="margin-top:20px">Dirección</label>
                                <div class="row">
                                    <div class="col">
                                        <input type="text" id="calle" name="calle" class="form-control" placeholder="Calle" aria-label="calle" required>
                                    </div>
                                    <div class="col">
                                        <input type="text" id="colonia" name="colonia" class="form-control" placeholder="Colonia" aria-label="colonia" required>
                                    </div>
                                    <div class="col">
                                        <input type="text" id="numext" name="numext" class="form-control" placeholder="No. Ext" aria-label="No. Ext" required>
                                    </div>
                                    <div class="col">
                                        <input type="text" id="numint" name="numint" class="form-control" placeholder="No. Interior" aria-label="No. Interior">
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 20px;">
                                    <div class="col">
                                        <select id="estado" name="estado" class="custom-select custom-select-sm form-control form-control-sm" aria-label="Default select example">
                                            < <!-- <option selected>Selecciona tu estado</option> -->
                                           <% 
                                                for(Map.Entry<Integer, String> entry: Catalogos.getEstados().entrySet()){
                                                    int key = entry.getKey();
                                                    String value = entry.getValue();
                                                
                                               
                                               
                                            %>
                                            <option value="<%=key%>"><%=value%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <select id="municipio" name="municipio" class="custom-select custom-select-sm form-control form-control-sm" aria-label="Default select example">
                                            <% 
                                                for(Map.Entry<Integer, String> entry: Catalogos.getMunicipios().entrySet()){
                                                    int key = entry.getKey();
                                                    String value = entry.getValue();
                                                
                                               
                                               
                                            %>
                                            <option value="<%=key%>"><%=value%></option>
                                            <%
                                                }
                                            %>
                                          </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col" style="margin-top: 20px;">
                                        <input type="text" id="telefono" name="telefono" class="form-control" placeholder="Telefono" aria-label="Telefono" required>
                                    </div>
                                </div>
                                <div class="button__submit" style="display: flex; justify-content: center;">
                                    <button type="submit" class="btn btn-primary" style="margin-top: 20px; width: 150px;">Agregar</button>
                                </div>

                            </div>

                        </form>
                        </div>
                        <table class="table" style="margin-top: 40px;">
                            <thead>
                              <tr>
                                <th scope="col">Sucursal</th>
                                <th colspan="2">Accion</th>
                              </tr>
                            </thead>
                            <tbody>
                              
                                <% 
                                    SucursalDAO dao = new SucursalDAO();
                                    HttpSession sesion = request.getSession();
                                    TrabajadorDTO dto = (TrabajadorDTO)sesion.getAttribute("user");
                                    RestauranteDTO rdto = new RestauranteDTO();
                                    rdto = (RestauranteDTO) sesion.getAttribute("restaurante");
                                    
                                    for(SucursalDTO s : dao.getAllByIdRestaurante(rdto)){
                                    
                                    
                                %>
                                <tr>
                                    <td><%= s.getSucursal().getNombreSucursal() %></td>
                                    <td>
                                        <a class="btn btn-warning" href="editarSucursal.jsp?id=<%= s.getSucursal().getIdSucursal() %>">
                                            Editar
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-danger" href="EliminarSucursal?id=<%= s.getSucursal().getIdSucursal() %>">
                                            Eliminar
                                        </a>
                                    </td>
                                </tr>
                                    <%}%>
                              
                            </tbody>
                          </table>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; ESCOM 2022</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>