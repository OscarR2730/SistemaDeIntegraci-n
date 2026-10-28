package Controlador;

import Modelo.EduData;
import Modelo.EduDataDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DashboardController", urlPatterns = {"/DashboardController"})
public class DashboardController extends HttpServlet {

    EduDataDAO dao = new EduDataDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null || accion.isEmpty()) {
            accion = "listar";
        }

        if (accion.equals("listar")) {
            List<EduData> datos = dao.listarResumenDepartamental();
            request.setAttribute("listaDatos", datos);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

