package ma.rougga.qinstall.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

public class InstallTablesQData extends HttpServlet {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(InstallTablesQData.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                Connection con = new CPConnection().getConnection();
                String[] oldTables = {};
                DatabaseMetaData md = con.getMetaData();
                ResultSet rs = md.getTables(null, null, "%", null);
                while (rs.next()) {
                    if (Objects.equals(rs.getString(4), "TABLE")) {
                        out.print(rs.getString(4) + " - " + rs.getString(3));
                        con.createStatement().executeUpdate("drop table if exists " + rs.getString(3) + " CASCADE;");
                        logger.info("Table: " + rs.getString(3) + " IS DELETED");
                    }

                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_AGENCES);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_USERS);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_PARS);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_TITLES);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_CIBLES);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_ZONES);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGA_AGENCE_ZONE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_USER_ZONE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_GBL_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_EMP_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_EMPSER_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_GCH_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_GCHSER_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_GLA_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_GLT_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_THT_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_THTT_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_THA_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                try {
                    con.createStatement().executeUpdate(QDataTables.ROUGGA_THSA_TABLE);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                con.close();
                response.sendRedirect("./QData.jsp");
            } catch (Exception e) {
                logger.error(e.getMessage());
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
