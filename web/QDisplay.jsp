<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="main.PgConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Installation QData</title>
        <link rel="icon" type="image/png" href="./img/favicon-32x32.png">
        <script src="./js/lib/jquery.js"></script>
        <link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="./js/lib/bootstrap.bundle.min.js"></script>
        <link href="./css/body.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="bg-dark">
        <div class="container pt-4 text-white">
            <h1 class="text-white"><a href="index.jsp" class="btn btn-danger"><< Accueil</a> Creation des tables: (QData) </h1>
            <div class="w-75 mx-auto mt-4 pt-4">
                <% 
            
                    boolean allCreated=true;
                    String[] tables = {"agence","cible","lastupdate","t_biz_type","t_login_log","t_ticket","t_user","t_window","t_window_status","rougga_task","rougga_ticket_task"};
                    try{
                        PgConnection con = new PgConnection();
                        DatabaseMetaData md = con.getStatement().getConnection().getMetaData();
                        ResultSet rs ;
                        for(int i=0;i < tables.length;i++){
                           rs = md.getTables(null, null, tables[i], null);
                           if (rs.next()) {
                %><%= "<h3 class='text-success'>"+rs.getString(3)+" créé.</h3>" %><%
                           }else{
                            allCreated=false;
                %><%= "<h3 class='text-danger'>"+tables[i]+" indisponible</h3>" %><%
                           }
                        }
                        con.closeConnection();
                    }
                    catch(Exception e){
                %><%= e.getMessage() %><%
                    }
                    if(!allCreated){
                %>
                <h2 class="mt-4"><img src="img/icon/x-mark-5-24.png"/> Certaines tables ne sont pas installées.</h2>
                <a href="./InstallTables" class="btn btn-lg btn-success">Installer toutes les tables</a>
                <%
                }else{
                %>
                <h2><img src="img/icon/check-mark-8-24.png"/> Toutes les tables sont installées.</h2>
                <%
                 }

                %>
            </div>
        </div>

    </body>
</html>
