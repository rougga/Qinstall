package ma.rougga.qinstall.controller;

import java.sql.SQLException;
import ma.rougga.qinstall.main.InstallTablesQData;
import ma.rougga.qinstall.main.PgConnection;
import ma.rougga.qinstall.main.QstatesTables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QstatesTablesController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(InstallTablesQData.class);

    public QstatesTablesController() {
    }

    public static void createTables() {
        try {
            PgConnection con = new PgConnection();
            //instalation des tables
            try {
                con.getStatement().executeUpdate(QstatesTables.ROUGGA_USERS);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            try {
                con.getStatement().executeUpdate(QstatesTables.ROUGGA_PARS);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            try {
                con.getStatement().executeUpdate(QstatesTables.ROUGGA_TASKS);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            try {
                con.getStatement().executeUpdate(QstatesTables.ROUGGA_TICKET_TASK);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            try {
                con.getStatement().executeUpdate(QstatesTables.ROUGGA_TITLES);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            try {
                con.getStatement().executeUpdate(QstatesTables.ROUGGA_CIBLES);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            // closing the connection to database
            con.closeConnection();
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
