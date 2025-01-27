package ma.rougga.qinstall.main;

public class QDataTables {

    public static final String ROUGGA_AGENCES
            = "CREATE TABLE public.rougga_agences ("
            + "    id character varying(40) COLLATE pg_catalog.\"default\" NOT NULL, "
            + "    name character varying(255) COLLATE pg_catalog.\"default\" NOT NULL, "
            + "    host character varying(17) DEFAULT '127.0.0.1', "
            + "    port int NOT NULL DEFAULT 8888, "
            + "    lastupdated_at character varying(40), "
            + "    status int NOT NULL DEFAULT 1, "
            + "    CONSTRAINT rougga_agences_pkey PRIMARY KEY (id)"
            + ");";
    public static final String ROUGGA_USERS = "CREATE TABLE public.rougga_users "
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
            + "id_service character varying(32) ,"
            + "id_agence character varying(40) not null references rougga_agences(id) ON DELETE CASCADE"
            + ");";

    public static final String ROUGGA_TICKET_TASK = "CREATE TABLE rougga_ticket_task"
            + "("
            + "id_ticket character varying(32) ,"
            + "id_task  character varying(40) ,"
            + "quantity numeric(5,0) default 1,"
            + "id_agence character varying(40) not null references rougga_agences(id) ON DELETE CASCADE"
            + ");";
    public static final String ROUGGA_ZONES = "CREATE TABLE public.rougga_zones "
            + "("
            + "    id character varying(40) COLLATE pg_catalog.\"default\" NOT NULL,"
            + "    name character varying(40) COLLATE pg_catalog.\"default\" NOT NULL,"
            + "    city character varying(40) ,"
            + "    code character varying(40) ,"
            + "    CONSTRAINT zones_pkey PRIMARY KEY (id)"
            + ")"
            + ";";
    public static final String ROUGA_AGENCE_ZONE = "CREATE TABLE rougga_agence_zone"
            + "("
            + "id_agence character varying(40) not null references rougga_agences(id) ON DELETE CASCADE,"
            + "id_zone  character varying(40) not null references rougga_zones(id) ON DELETE CASCADE "
            + ");";
    public static final String ROUGGA_USER_ZONE = "CREATE TABLE rougga_user_zone"
            + "("
            + "id_user character varying(40) not null references rougga_users(id) ON DELETE CASCADE,"
            + "id_zone  character varying(40) not null references rougga_zoneS(id) ON DELETE CASCADE "
            + ");";
    public static final String ROUGGA_PARS
            = "CREATE TABLE public.rougga_pars ("
            + "    id character varying(40) NOT NULL, "
            + "    name character varying(255) NOT NULL, "
            + "    value character varying(255) NOT NULL, "
            + "    CONSTRAINT rougga_pars_pkey PRIMARY KEY (id)"
            + ");";
    public static final String ROUGGA_GBL_TABLE
            = "CREATE TABLE rougga_gbl_table ("
            + "id VARCHAR(255) PRIMARY KEY, "
            + "id_service VARCHAR(255) NOT NULL, "
            + "service_name VARCHAR(255) NOT NULL, "
            + "nb_t BIGINT DEFAULT 0, "
            + "nb_tt BIGINT DEFAULT 0, "
            + "nb_a BIGINT DEFAULT 0, "
            + "nb_tl1 BIGINT DEFAULT 0, "
            + "nb_sa BIGINT DEFAULT 0, "
            + "perApT DECIMAL(6, 3) DEFAULT 00.00, "
            + "PERTL1pt DECIMAL(6, 3) DEFAULT 00.00, "
            + "perSApT DECIMAL(6, 3) DEFAULT 00.00, "
            + "avgSec_A NUMERIC DEFAULT 0, "
            + "nb_ca BIGINT DEFAULT 0, "
            + "percapt DECIMAL(6, 3) DEFAULT 00.00, "
            + "avgSec_T NUMERIC DEFAULT 0, "
            + "nb_ct BIGINT DEFAULT 0, "
            + "perctpt DECIMAL(6, 3) DEFAULT 00.00, "
            + "date TIMESTAMP DEFAULT NOW(), "
            + "id_agence VARCHAR(40) REFERENCES rougga_agences(id) ON DELETE CASCADE NOT NULL"
            + ");";
    public static final String ROUGGA_EMP_TABLE = "CREATE TABLE rougga_emp_table ("
        + "id VARCHAR(255) PRIMARY KEY, "
        + "id_emp VARCHAR(255) NOT NULL, "
        + "emp_name VARCHAR(255) NOT NULL, "
        + "nb_t BIGINT DEFAULT 0, "
        + "nb_tt BIGINT DEFAULT 0, "
        + "nb_a BIGINT DEFAULT 0, "
        + "nb_tl1 BIGINT DEFAULT 0, "
        + "nb_sa BIGINT DEFAULT 0, "
        + "perApT DECIMAL(6, 3) DEFAULT 00.00, "
        + "PERTL1pt DECIMAL(6, 3) DEFAULT 00.00, "
        + "perSApT DECIMAL(6, 3) DEFAULT 00.00, "
        + "avgSec_A NUMERIC DEFAULT 0, "
        + "nb_ca BIGINT DEFAULT 0, "
        + "percapt DECIMAL(6, 3) DEFAULT 00.00, "
        + "avgSec_T NUMERIC DEFAULT 0, "
        + "nb_ct BIGINT DEFAULT 0, "
        + "perctpt DECIMAL(6, 3) DEFAULT 00.00, "
        + "date TIMESTAMP DEFAULT NOW(), "
        + "id_agence VARCHAR(40) REFERENCES rougga_agences(id) ON DELETE CASCADE NOT NULL"
        + ");";

    
}
