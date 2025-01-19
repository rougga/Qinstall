package ma.rougga.qinstall.main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InstallTablesQStates extends HttpServlet {
   
       

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            try {
                PgConnection con = new PgConnection();
                //instalation des tables
                con.getStatement().executeUpdate(Tables.task);
                con.getStatement().executeUpdate(Tables.ticket_task);
                // closing the connection to database
                con.closeConnection();
                //redirecting to page
                resp.sendRedirect("./QStates.jsp");
            } catch (Exception e) {
                out.print(e.getMessage());
            }

        }
    }
   
}
