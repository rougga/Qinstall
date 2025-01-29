package ma.rougga.qinstall.main;

public class QstatesTables {

   private static String[] TABLES = {
        "rougga_users",
        "rougga_tasks",
        "rougga_ticket_task",
        "rougga_pars",
        "rougga_titles"
    };

    public static String[] getTABLES() {
        return TABLES;
    }
   
    public static final String ROUGGA_USERS = "CREATE TABLE rougga_users "
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

    public static final String ROUGGA_TASKS = "CREATE TABLE rougga_tasks "
            + "("
            + "id character varying(40),"
            + "name character varying(255) not null,"
            + "id_service character varying(32)"
            + ");";

    public static final String ROUGGA_TICKET_TASK = "CREATE TABLE rougga_ticket_task"
            + "("
            + "id_ticket character varying(32) ,"
            + "id_task  character varying(40) ,"
            + "quantity numeric(5,0) default 1"
            + ");";
    public static final String ROUGGA_PARS
            = "CREATE TABLE rougga_pars ("
            + "    name character varying(255) NOT NULL, "
            + "    value character varying(255) NOT NULL, "
            + "    CONSTRAINT rougga_pars_pkey PRIMARY KEY (name)"
            + ");";
    public static final String ROUGGA_TITLES = "CREATE TABLE rougga_titles ("
            + "type VARCHAR(255) NOT NULL, "
            + "title VARCHAR(255) NOT NULL, "
            + "CONSTRAINT rougga_titles_pkey PRIMARY KEY (type)"
            + ");";

}
