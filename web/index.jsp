<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="main.PgConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Installation QData</title>
    </head>
    <body>
        <h1>Creation des tables: (QData)</h1>
        <% 
            
            boolean allCreated=true;
            String[] tables = {"agence","cible","lastupdate","t_biz_type","t_login_log","t_ticket","t_user","t_window","t_window_status"};
            try{
                PgConnection con = new PgConnection();
                DatabaseMetaData md = con.getStatement().getConnection().getMetaData();
                ResultSet rs ;
                for(int i=0;i < tables.length;i++){
                   rs = md.getTables(null, null, tables[i], null);
                   if (rs.next()) {
                    %><%= "<h3>"+rs.getString(3)+" créé.</h3>" %><%
                   }else{
                    allCreated=false;
                    %><%= "<h3>"+tables[i]+" indisponible</h3>" %><%
                   }
                }
                con.closeConnection();
                %><%= "<h2>toutes les tables sont créées? - "+ allCreated +"</h2>" %><%
            }
            catch(Exception e){
                %><%= e.getMessage() %><%
            }
            if(!allCreated){
            %>
            <a href="./InstallTables" >Installer toutes les tables</a>
            <%
            }

         %>


    </body>
</html>
