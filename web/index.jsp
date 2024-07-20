<%@page import="main.CfgHandler"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="main.PgConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QInstall</title>
        <link rel="icon" type="image/png" href="./img/favicon.ico">
        <script src="./js/lib/jquery.js"></script>
        <link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="./js/lib/bootstrap.bundle.min.js"></script>
        <link href="./css/body.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="bg-dark">
        <div class="container pt-4">
            <h1 class="text-white text-center">INSTALLATION </h1>
            <h3 class="text-white text-center"><%= CfgHandler.APP + " v" + CfgHandler.VERSION%></h3>
            <!<!-- les cartes -->
            <div class="mt-5 row">  
                <!-- carte QStates -->
                <div class="card col-12 col-md-3 mx-1" >
                    <img src="img/qstates.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Installer QStates</h5>
                        <p class="card-text">
                            <strong>Version  <%= CfgHandler.QSTATE_VERSION%></strong>
                            <br>
                            Installation des tables pour les fonctions des taches.
                        </p>
                        <a href="QStates.jsp" class="btn btn-success font-weight-bold w-100" style="background-color: #b83dba"><img src="img/icon/install-16-white.png" alt="..."> INSTALLER</a>
                    </div>
                </div>
                <!-- carte QData -->
                <div class="card col-12 col-md-3 mx-1" >
                    <img src="img/qdata.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Installer QData</h5>
                        <p class="card-text">
                            <strong>Version <%= CfgHandler.QDATA_VERSION%></strong>
                            <br>
                            Suppression et l'installation des tables pour l'application.
                        </p>
                        <a href="QData.jsp" class="btn btn-success w-100 font-weight-bold" style="background-color: #14b6fa;"><img src="img/icon/install-16-white.png" alt="..."> INSTALLER</a>
                    </div>
                </div>
                <!-- carte QDisplay -->
                <div class="card col-12 col-md-3 mx-1" >
                    <img src="img/qdd.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Installer QDisplay</h5>
                        <p class="card-text">
                            <strong>Version <%= CfgHandler.QDISPLAY_VERSION %></strong>
                            <br>
                            Suppression et l'installation des tables pour l'application.
                        </p>
                        <a href="QDisplay.jsp" class="btn btn-dark w-100 font-weight-bold disabled" style="background-color: blue;"><img src="img/icon/install-16-white.png" alt="..."> INSTALLER</a>
                    </div>
                </div>
            </div>
            <footer>
                <a target="_blank" href="https://www.marocnst.ma/">CopyRight &COPY; 2020 <%= CfgHandler.CLIENT%></a>
                <p><%= CfgHandler.APP + " v" + CfgHandler.VERSION%></p>
            </footer>
        </div>


    </body>
</html>
