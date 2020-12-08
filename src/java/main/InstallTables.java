package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InstallTables extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                PgConnection con = new PgConnection();
                String[] oldTables = {};
                DatabaseMetaData md = con.getStatement().getConnection().getMetaData();
                ResultSet rs = md.getTables(null, null, "%", null);
                while (rs.next()) {
                    if (Objects.equals(rs.getString(4), "TABLE")) {
                        out.print(rs.getString(4) + " - " + rs.getString(3));
                        con.getStatement().executeUpdate("drop table if exists " + rs.getString(3) + " CASCADE;");

                        System.err.println("Table: " + rs.getString(3) + " IS DELETED");
                    }

                }

                con.getStatement().executeUpdate(Tables.agence);
                con.getStatement().executeUpdate(Tables.cible);
                con.getStatement().executeUpdate(Tables.lastupdate);
                con.getStatement().executeUpdate(Tables.t_biz_type);
                con.getStatement().executeUpdate(Tables.t_login_log);
                con.getStatement().executeUpdate(Tables.t_ticket);
                con.getStatement().executeUpdate(Tables.t_user);
                con.getStatement().executeUpdate(Tables.t_window);
                con.getStatement().executeUpdate(Tables.t_window_status);
                con.closeConnection();
                response.sendRedirect("./index.jsp");
            } catch (Exception e) {
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
