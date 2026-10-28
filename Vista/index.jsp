<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.EduData"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EduData Insight - Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <nav class="navbar navbar-dark bg-dark mb-4">
            <div class="container-fluid">
                <span class="navbar-brand mb-0 h1">EduData Insight - Sistema de Monitoreo MINEDU</span>
            </div>
        </nav>
        <div class="container">
            <div class="row mb-3">
                <div class="col-md-12 text-center">
                    <a href="DashboardController?accion=listar" class="btn btn-primary btn-lg">Cargar Datos de SQL Server</a>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <table class="table table-striped table-bordered shadow-sm bg-white">
                        <thead class="table-dark">
                            <tr>
                                <th>Departamento</th>
                                <th class="text-center">Total de Desertores</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<EduData> lista = (List<EduData>) request.getAttribute("listaDatos");
                                if (lista != null && !lista.isEmpty()) {
                                    for (EduData d : lista) {
                            %>
                            <tr>
                                <td><%= d.getDepartamento() %></td>
                                <td class="text-center"><%= d.getTotalMatriculados() %></td>
                            </tr>
                            <%
                                    }
                                } else {
                            %>
                            <tr>
                                <td colspan="2" class="text-center p-4">
                                    <h5 class="text-muted">Haga clic en el botón superior para visualizar la información.</h5>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

