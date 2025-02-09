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
            + "('gchser', 'Rapport Guichet par service'), "
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
            + "agence_id character varying(40) not null references rougga_agences(id) ON DELETE CASCADE,"
            + "CONSTRAINT rougga_cibles_pkey PRIMARY KEY (service_id,agence_id)"
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
            + ");"
            + "CREATE INDEX idx_gbl_table_id_service ON rougga_gbl_table(id_service);"
            + "CREATE INDEX idx_gbl_table_id_agence ON rougga_gbl_table(id_agence);"
            + "CREATE INDEX idx_gbl_table_date ON rougga_gbl_table(date);";
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
            + ");"
            + "CREATE INDEX idx_emp_table_id_emp ON rougga_emp_table(id_emp);"
            + "CREATE INDEX idx_emp_table_id_agence ON rougga_emp_table(id_agence);"
            + "CREATE INDEX idx_emp_table_date ON rougga_emp_table(date);";
    public static final String ROUGGA_EMPSER_TABLE = "CREATE TABLE rougga_empser_table ("
            + "id VARCHAR(255) PRIMARY KEY, "
            + "id_emp VARCHAR(255) NOT NULL, "
            + "emp_name VARCHAR(255) NOT NULL, "
            + "service_id VARCHAR(255) NOT NULL, "
            + "service_name VARCHAR(255) NOT NULL, "
            + "agence_id VARCHAR(40) NOT NULL REFERENCES rougga_agences(id) ON DELETE CASCADE, "
            + "nb_t BIGINT DEFAULT 0, "
            + "nb_tt BIGINT DEFAULT 0, "
            + "nb_a BIGINT DEFAULT 0, "
            + "nb_tl1 BIGINT DEFAULT 0, "
            + "nb_sa BIGINT DEFAULT 0, "
            + "perApT DECIMAL(10, 3) DEFAULT 0.00, "
            + "perTl1Pt DECIMAL(10, 3) DEFAULT 0.00, "
            + "perSaPt DECIMAL(10, 3) DEFAULT 0.00, "
            + "avgSec_A NUMERIC DEFAULT 0, "
            + "avgSec_T NUMERIC DEFAULT 0, "
            + "nb_ca BIGINT DEFAULT 0, "
            + "percapt DECIMAL(10, 3) DEFAULT 0.00, "
            + "nb_ct BIGINT DEFAULT 0, "
            + "perCtPt DECIMAL(10, 3) DEFAULT 0.00, "
            + "date TIMESTAMP DEFAULT NOW()"
            + ");"
            + "CREATE INDEX idx_empser_id_emp ON rougga_empser_table(id_emp);"
            + "CREATE INDEX idx_empser_id_agence ON rougga_empser_table(agence_id);"
            + "CREATE INDEX idx_empser_id_service ON rougga_empser_table(service_id);"
            + "CREATE INDEX idx_empser_date ON rougga_empser_table(date);";
    public static final String ROUGGA_GCH_TABLE = "CREATE TABLE rougga_gch_table ("
            + "id VARCHAR(255) PRIMARY KEY, "
            + "agence_id VARCHAR(40) NOT NULL REFERENCES rougga_agences(id) ON DELETE CASCADE, "
            + "guichet_id VARCHAR(255) NOT NULL, "
            + "guichet_name VARCHAR(255) NOT NULL, "
            + "nb_t BIGINT DEFAULT 0, "
            + "nb_tt BIGINT DEFAULT 0, "
            + "nb_a BIGINT DEFAULT 0, "
            + "nb_tl1 BIGINT DEFAULT 0, "
            + "nb_sa BIGINT DEFAULT 0, "
            + "perApT DECIMAL(10, 3) DEFAULT 0.00, "
            + "perTl1Pt DECIMAL(10, 3) DEFAULT 0.00, "
            + "perSaPt DECIMAL(10, 3) DEFAULT 0.00, "
            + "avgSec_A NUMERIC DEFAULT 0, "
            + "avgSec_T NUMERIC DEFAULT 0, "
            + "nb_ca BIGINT DEFAULT 0, "
            + "percapt DECIMAL(10, 3) DEFAULT 0.00, "
            + "nb_ct BIGINT DEFAULT 0, "
            + "perCtPt DECIMAL(10, 3) DEFAULT 0.00, "
            + "date TIMESTAMP DEFAULT NOW()"
            + ");"
            + "CREATE INDEX idx_gch_id_agence ON rougga_gch_table(agence_id);"
            + "CREATE INDEX idx_gch_guichet_id ON rougga_gch_table(guichet_id);"
            + "CREATE INDEX idx_gch_date ON rougga_gch_table(date);";
    public static final String ROUGGA_GCHSER_TABLE = "CREATE TABLE rougga_gchser_table ("
            + "id VARCHAR(255) PRIMARY KEY, "
            + "date TIMESTAMP DEFAULT NOW(), "
            + "agence_id VARCHAR(40) NOT NULL REFERENCES rougga_agences(id) ON DELETE CASCADE, "
            + "service_id VARCHAR(255) NOT NULL, "
            + "service_name VARCHAR(255) NOT NULL, "
            + "guichet_id VARCHAR(255) NOT NULL, "
            + "guichet_name VARCHAR(255) NOT NULL, "
            + "nb_t BIGINT DEFAULT 0, "
            + "nb_tt BIGINT DEFAULT 0, "
            + "nb_a BIGINT DEFAULT 0, "
            + "nb_tl1 BIGINT DEFAULT 0, "
            + "nb_sa BIGINT DEFAULT 0, "
            + "perApT DECIMAL(10, 3) DEFAULT 0.000, "
            + "perTl1Pt DECIMAL(10, 3) DEFAULT 0.000, "
            + "perSaPt DECIMAL(10, 3) DEFAULT 0.000, "
            + "avgSec_A NUMERIC DEFAULT 0, "
            + "nb_ca BIGINT DEFAULT 0, "
            + "percapt DECIMAL(10, 3) DEFAULT 0.000, "
            + "avgSec_T NUMERIC DEFAULT 0, "
            + "nb_ct BIGINT DEFAULT 0, "
            + "perCtPt DECIMAL(10, 3) DEFAULT 0.000"
            + ");"
            + "CREATE INDEX idx_gchser_id_agence ON rougga_gchser_table(agence_id);"
            + "CREATE INDEX idx_gchser_service_id ON rougga_gchser_table(service_id);"
            + "CREATE INDEX idx_gchser_guichet_id ON rougga_gchser_table(guichet_id);"
            + "CREATE INDEX idx_gchser_date ON rougga_gchser_table(date);";
    public static final String ROUGGA_GLA_TABLE = "CREATE TABLE rougga_gla_table ("
            + "id VARCHAR(255) PRIMARY KEY, "
            + "date TIMESTAMP DEFAULT NOW(), "
            + "agence_id VARCHAR(40) NOT NULL REFERENCES rougga_agences(id) ON DELETE CASCADE, "
            + "service_id VARCHAR(255) NOT NULL, "
            + "service_name VARCHAR(255) NOT NULL, "
            + "s0_15 BIGINT DEFAULT 0, "
            + "s15_30 BIGINT DEFAULT 0, "
            + "s30_60 BIGINT DEFAULT 0, "
            + "s60_90 BIGINT DEFAULT 0, "
            + "s90_120 BIGINT DEFAULT 0, "
            + "s120 BIGINT DEFAULT 0, "
            + "m0_5 BIGINT DEFAULT 0, "
            + "m5_10 BIGINT DEFAULT 0, "
            + "m10_20 BIGINT DEFAULT 0, "
            + "m20_30 BIGINT DEFAULT 0, "
            + "m30_45 BIGINT DEFAULT 0, "
            + "m45_50 BIGINT DEFAULT 0, "
            + "m50 BIGINT DEFAULT 0, "
            + "total BIGINT DEFAULT 0"
            + ");"
            + "CREATE INDEX idx_gla_id_agence ON rougga_gla_table(agence_id);"
            + "CREATE INDEX idx_gla_service_id ON rougga_gla_table(service_id);"
            + "CREATE INDEX idx_gla_date ON rougga_gla_table(date);";
    public static final String ROUGGA_GLT_TABLE = "CREATE TABLE rougga_glt_table ("
            + "id VARCHAR(255) PRIMARY KEY, "
            + "date TIMESTAMP DEFAULT NOW(), "
            + "agence_id VARCHAR(40) NOT NULL REFERENCES rougga_agences(id) ON DELETE CASCADE, "
            + "service_id VARCHAR(255) NOT NULL, "
            + "service_name VARCHAR(255) NOT NULL, "
            + "s0_15 BIGINT DEFAULT 0, "
            + "s15_30 BIGINT DEFAULT 0, "
            + "s30_60 BIGINT DEFAULT 0, "
            + "s60_90 BIGINT DEFAULT 0, "
            + "s90_120 BIGINT DEFAULT 0, "
            + "s120 BIGINT DEFAULT 0, "
            + "m0_5 BIGINT DEFAULT 0, "
            + "m5_10 BIGINT DEFAULT 0, "
            + "m10_20 BIGINT DEFAULT 0, "
            + "m20_30 BIGINT DEFAULT 0, "
            + "m30_45 BIGINT DEFAULT 0, "
            + "m45_50 BIGINT DEFAULT 0, "
            + "m50 BIGINT DEFAULT 0, "
            + "total BIGINT DEFAULT 0"
            + ");"
            + "CREATE INDEX idx_glt_id_agence ON rougga_glt_table(agence_id);"
            + "CREATE INDEX idx_glt_service_id ON rougga_glt_table(service_id);"
            + "CREATE INDEX idx_glt_date ON rougga_glt_table(date);";
}
