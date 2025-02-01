package ma.rougga.qinstall.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.rougga.qinstall.main.PgConnection;
import ma.rougga.qinstall.main.QstatesTables;

public class QstatesTablesController {

    public QstatesTablesController() {
    }

    public static void createTables() throws ClassNotFoundException, SQLException {
        PgConnection con = new PgConnection();
        //instalation des tables
        con.getStatement().executeUpdate(QstatesTables.ROUGGA_USERS);
        con.getStatement().executeUpdate(QstatesTables.ROUGGA_PARS);
        con.getStatement().executeUpdate(QstatesTables.ROUGGA_TASKS);
        con.getStatement().executeUpdate(QstatesTables.ROUGGA_TICKET_TASK);
        con.getStatement().executeUpdate(QstatesTables.ROUGGA_TITLES);
        con.getStatement().executeUpdate(QstatesTables.ROUGGA_CIBLES);
        // closing the connection to database
        con.closeConnection();
    }
}
