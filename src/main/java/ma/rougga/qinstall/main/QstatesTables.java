package ma.rougga.qinstall.main;

public class QstatesTables {

    private static final String[] TABLES = {
        "rougga_users",
        "rougga_tasks",
        "rougga_ticket_task",
        "rougga_pars",
        "rougga_titles",
        "rougga_cibles"
    };

    public static String[] getTABLES() {
        return TABLES;
    }

    public static final String ROUGGA_USERS = "CREATE TABLE IF NOT EXISTS rougga_users "
            + "("
            + "    id character varying(40)  NOT NULL,"
            + "    username character varying(255) NOT NULL unique,"
            + "    password character varying(255) not null ,"
            + "    grade character varying(17) not null ,"
            + "    first_name character varying(32) ,"
            + "    last_name character varying(32) ,"
            + "    date character varying(40),"
            + "    sponsor character varying(255),"
            + "    CONSTRAINT rougga_users_pkey PRIMARY KEY (id)"
            + ")"
            + ";"
            + "insert into rougga_users (id,username,password,grade,first_name,last_name)"
            + " values('f2c1cf31-f2dd-46ca-9b92-9d60c45e1227',"
            + "'admin',"
            + "'$31$16$3HyoGMKLc4EvcO0ljwLKNY8pclDUAmd7o_oAQUA7J20',"
            + "'adm','admin','admin');";

    public static final String ROUGGA_TASKS = "CREATE TABLE IF NOT EXISTS rougga_tasks "
            + "("
            + "id character varying(40),"
            + "name character varying(255) not null,"
            + "id_service character varying(32)"
            + ");";

    public static final String ROUGGA_TICKET_TASK = "CREATE TABLE IF NOT EXISTS rougga_ticket_task"
            + "("
            + "id_ticket character varying(32) ,"
            + "id_task  character varying(40) ,"
            + "quantity numeric(5,0) default 1"
            + ");";
    public static final String ROUGGA_PARS
            = "CREATE TABLE IF NOT EXISTS rougga_pars ("
            + "    name character varying(255) NOT NULL, "
            + "    value character varying(255) NOT NULL, "
            + "    CONSTRAINT rougga_pars_pkey PRIMARY KEY (name)"
            + ");";
    public static final String ROUGGA_TITLES = "CREATE TABLE IF NOT EXISTS rougga_titles ("
            + "type VARCHAR(255) NOT NULL, "
            + "title VARCHAR(255) NOT NULL, "
            + "CONSTRAINT rougga_titles_pkey PRIMARY KEY (type)"
            + ");"
            + "INSERT INTO rougga_titles (type, title) VALUES "
            + "('gbl', 'Rapport Globale'), "
            + "('emp', 'Rapport Employée'), "
            + "('empser', 'Rapport Employée par service'), "
            + "('gch', 'Rapport Guichet'), "
            + "('gchserv', 'Rapport Guichet par service'), "
            + "('gla', 'Grille d''attente'), "
            + "('glt', 'Grille de traitement'), "
            + "('apl', 'Appele'), "
            + "('ndt', 'Nombre de tickets edités'), "
            + "('ndtt', 'Nombre de tickets traités'), "
            + "('ndta', 'Nombre de tickets absents'), "
            + "('ndtsa', 'Nombre de tickets sans affectation'), "
            + "('cnx', 'Connexions'), "
            + "('remp', 'Rendement Employés'), "
            + "('sgch', 'Supervision: Employée-Guichet'), "
            + "('ser', 'Supervision: Service'), "
            + "('tch', 'Rapport Tache');";
    public static final String ROUGGA_CIBLES = "CREATE TABLE rougga_cibles ("
            + "service_id VARCHAR(40), "
            + "service_name VARCHAR(255) NOT NULL, "
            + "cible_a BIGINT DEFAULT 0, "
            + "cible_t BIGINT DEFAULT 0, "
            + "cible_per DECIMAL(6, 3) DEFAULT 0.000, "
            + "CONSTRAINT rougga_cibles_pkey PRIMARY KEY (service_id)"
            + ");";
}
