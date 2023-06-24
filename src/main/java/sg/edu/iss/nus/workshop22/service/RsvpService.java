package sg.edu.iss.nus.workshop22.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.iss.nus.workshop22.model.Rsvp;

@Service
public class RsvpService {
    // Service takes JSON String and changes it to JSON Rsvp object, to then pass to Repo class
    public Rsvp parseJson(String rsvpJson) {
        Rsvp newRsvp = new Rsvp();
        try {
            InputStream is = new ByteArrayInputStream(rsvpJson.getBytes());
            JsonReader reader = Json.createReader(is);
            JsonObject jo = reader.readObject();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = new Date(sdf.parse(jo.getString("confirmationDate")).getTime());

            newRsvp = new Rsvp(
                jo.getInt("id"), 
                jo.getString("fullName"), 
                jo.getString("email"), 
                jo.getString("phone"), 
                parsedDate,
                jo.getString("comments"));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return newRsvp;
    }
}
