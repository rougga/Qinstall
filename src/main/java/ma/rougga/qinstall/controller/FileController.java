package ma.rougga.qinstall.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileController {

    public FileController() {
    }

    public static String getInstaledQdataVersion(ServletContext servletContext) {
        FileReader in = null;
        try {
            String rootURL = servletContext.getRealPath("/").replace("\\qinstall", "");
            in = new FileReader(rootURL + "rougga_package.json");
            BufferedReader reader = new BufferedReader(in);
            StringBuilder response2 = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response2.append(line);
            }
            reader.close();
            //simple json
            JSONParser parser = new JSONParser();
            JSONObject ob = (JSONObject) parser.parse(response2.toString());
            return "";
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public static boolean uploadLastestQdata() {

        return true;
    }
}
