package ma.rougga.qinstall.main;

public class QDisplayTables {

    public static final String ROUGGA_PARS_QDISPLAY
            = "CREATE TABLE public.rougga_pars_qdisplay ("
            + "    name character varying(255) NOT NULL, "
            + "    value character varying(255) NOT NULL, "
            + "    CONSTRAINT rougga_pars_pkey PRIMARY KEY (name)"
            + ");"
            + "INSERT INTO rougga_pars_qdisplay (name, value) VALUES "
            + "('theme','normal'),"
            + "('hideEmptyTables','false'),"
            + "('isWeatherEnabled','true'),"
            + "('location','Casablanca,Morocco'),"
            + "('margin','false'),"
            + "('size','20'),"
            + "('tableRefreshTime','30'),"
            + "('text','Bonjour'),"
            + "('textColor','#ffffff'),"
            + "('titleSize','36')"
            + "";
            
}
