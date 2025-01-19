<%@page import="ma.rougga.qinstall.main.CfgHandler"%>
<%@page import="ma.rougga.qinstall.main.CfgHandler"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QInstall</title>
        <link rel="icon" type="image/png" href="./img/favicon.ico">
        <script src="./js/lib/jquery.js"></script>
        <link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="./css/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <script src="./js/lib/bootstrap.bundle.min.js"></script>
        <link href="./css/body.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="">
        <div class="container">
            <div class="mb-2 d-flex flex-column justify-content-between">
                <a href="https://rougga.sder.ma" target="_blank" class="d-flex justify-content-center">
                    <img src="./img/rougga.png" class="img-fluid" width="100"/>
                </a>
                <h1 class="text-white text-center">INSTALLATION</h1>
            </div>
            <!<!-- les cartes -->
            <div class="row justify-content-center">  
                <!-- carte QStates -->
                <div class="card col-12 col-md-3 mx-1 p-0" >
                    <img src="img/qstates.png" class="card-img-top" >
                    <div class="card-body ">
                        <h5 class="card-title text-center">QStates
                        </h5>
                        <p class="card-text">
                            <strong>Version  <%= CfgHandler.QSTATE_VERSION%></strong>
                            <br>
                            Installation des tables pour les fonctions des taches.
                        </p>
                        <div class="d-flex justify-content-between">
                            <a href="QStates.jsp" class="btn text-white font-weight-bold w-75 qstates-bg" >
                                <i class="fa fa-download" aria-hidden="true"></i> INSTALLER
                            </a>
                            <a href="./doc/qstates.pdf" class="btn btn-secondary font-weight-bold " >
                                <i class="fa fa-info" aria-hidden="true"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- carte QData -->
                <div class="card col-12 col-md-3 mx-1  p-0" >
                    <img src="img/qdata.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title text-center">QData</h5>
                        <p class="card-text">
                            <strong>Version <%= CfgHandler.QDATA_VERSION%></strong>
                            <br>
                            Suppression et l'installation des tables pour l'application.
                        </p>
                        <div class="d-flex justify-content-between">
                            <a href="QData.jsp" class="btn text-white font-weight-bold w-75 qdata-bg" >
                                <i class="fa fa-download" aria-hidden="true"></i> INSTALLER
                            </a>
                            <a href="./doc/qdata.pdf" class="btn btn-secondary font-weight-bold " >
                                <i class="fa fa-info" aria-hidden="true"></i>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- carte QDisplay -->
                <div class="card col-12 col-md-3 mx-1  p-0" >
                    <img src="img/qdd.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title text-center">QDisplay</h5>
                        <p class="card-text">
                            <strong>Version <%= CfgHandler.QDISPLAY_VERSION%></strong>
                            <br>
                            Suppression et l'installation des tables pour l'application.
                        </p>
                        <div class="d-flex justify-content-between">
                            <a href="QData.jsp" class="btn text-white font-weight-bold w-75 qdisplay-bg disabled" >
                                <i class="fa fa-download" aria-hidden="true"></i> INSTALLER
                            </a>
                            <a href="./doc/qdisplay.pdf" class="btn btn-secondary font-weight-bold " >
                                <i class="fa fa-info" aria-hidden="true"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <footer>
                <a target="_blank" href="https://www.marocnst.ma/">CopyRight &COPY; 2025, for <%= CfgHandler.CLIENT%></a>
                <p><%= CfgHandler.APP + " v" + CfgHandler.VERSION%></p>
            </footer>
        </div>


    </body>
</html>
