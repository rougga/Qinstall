<%@page import="ma.rougga.qinstall.main.QstatesTables"%>
<%@page import="ma.rougga.qinstall.main.CfgHandler"%>
<%@page import="ma.rougga.qinstall.main.PgConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    String[] tables = QstatesTables.getTABLES();
    int allCreated = 1;

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Installation QStates</title>
        <link rel="icon" type="image/png" href="./img/favicon.ico">
        <script src="./js/lib/jquery.js"></script>
        <link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="./css/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <script src="./js/lib/bootstrap.bundle.min.js"></script>
        <link href="./css/body.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="">
        <div class="container text-white">
            <div class="mb-2 d-flex flex-column justify-content-between">
                <a href="https://rougga.sder.ma" target="_blank" class="d-flex justify-content-center">
                    <img src="./img/rougga.png" class="img-fluid" width="100"/>
                </a>
                <h2 class="text-white text-center" >
                    <a href="index.jsp" class="mr-4 rounded hover"><i class="fa fa-chevron-circle-left fa-lg text-danger" aria-hidden="true"></i></a>
                    Installation de 
                    <span class="badge badge-pill qstates-bg-nohover ">QStates</span>
                </h2>
            </div>
            <div class="mb-2 d-flex flex-column justify-content-between">
                <h6 class="text-white text-center" >
                    <%= getServletContext().getRealPath("/").replace("\\qinstall", "")%>
                </h6>
            </div>
            <div class="row  justify-content-center">
                <div class="row justify-content-center flex-column text-center col-12 col-md-6">
                    <h4>
                        <i class="fa fa-download" aria-hidden="true"></i>
                        Instalation des table:
                    </h4>
                    <%
                        try {
                            PgConnection con = new PgConnection();
                            DatabaseMetaData md = con.getStatement().getConnection().getMetaData();
                            ResultSet rs;
                            for (String table : tables) {
                                rs = md.getTables(null, null, table, null);
                                if (rs.next()) {
                    %>
                    <span class="d-flex justify-content-between align-items-center w-50 mx-auto">
                        <%=rs.getString(3)%> créé.
                        <i class="fa fa-check-circle-o text-success" aria-hidden="true"></i>
                    </span>
                    <%
                    } else {
                        allCreated = 0;
                    %>

                    <span class="d-flex justify-content-between align-items-center w-50 mx-auto">

                        <%= table%> indisponible.
                        <i class="fa fa-times-circle-o text-danger" aria-hidden="true"></i>
                    </span>
                    <%
                            }
                        }
                    %>

                    <%
                        con.closeConnection();
                    } catch (Exception e) {
                        allCreated = -1;
                    %>
                    <div class='alert alert-danger alert-dismissible fade show' role='alert'>
                        <b><%= e.getMessage()%></b>
                        <button type='button' class='close' data-dismiss='alert' aria-label='Close'>
                            <span aria-hidden='true'>&times;</span>
                        </button>
                    </div>

                    <%
                        }
                    %>
                </div> 
                <div class="row justify-content-center flex-column text-center  col-12 col-md-6 align-self-baseline">
                    <h4>
                        <i class="fa fa-clone" aria-hidden="true"></i>
                        Deplacement des fichiers:
                    </h4>
                    <span class="d-flex justify-content-between align-items-center w-50 mx-auto">
                        QStates.war v<%= CfgHandler.QSTATE_VERSION %> copié.
                        <i class="fa fa-check-circle-o text-success" aria-hidden="true"></i>
                    </span>
                    <span class="d-flex justify-content-between align-items-center w-50 mx-auto">
                        rougga_package.json copié.
                        <i class="fa fa-check-circle-o text-success" aria-hidden="true"></i>
                    </span>
                </div>
            </div>
            <div class="row justify-content-center flex-column align-items-center mt-3" >
                <%
                    if (allCreated == 0) {
                %>

                <a href="./InstallTablesQStates" class="btn qstates-bg text-white">
                    <i class="fa fa-download" aria-hidden="true"></i>
                    INSTALLER
                </a>
                <%
                    }
                    if (allCreated == 1) {
                %>
                <h2 class="mt-4">
                    <span class="badge badge-pill badge-success ">Toutes les tables sont installées</span>
                </h2>
                <h6 class="">
                    <a href="index.jsp" class="mr-4 rounded hover">
                        <i class="fa fa-chevron-circle-left fa-lg text-danger" aria-hidden="true"></i>
                        <span class="badge badge-pill badge-danger ">RETOUR À LA PAGE D'ACCUEIL</span>
                    </a>
                </h6>
                <%
                    }

                %>
            </div>
            <footer>
                <a target="_blank" href="https://www.marocnst.ma/">CopyRight &COPY; 2025, for <%= CfgHandler.CLIENT%></a>
                <p><%= CfgHandler.APP + " v" + CfgHandler.VERSION%></p>
            </footer>
        </div>
    </body>
</html>
