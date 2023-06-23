package sg.edu.iss.nus.workshop22.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.iss.nus.workshop22.model.Rsvp;

@RestController
@RequestMapping("/api/rsvps")
public class RsvpRestController {
    // PUT ALL THIS IN A CONTROLLER
    // REST controller is the POV of the external server
    // So write so that it receives JSON string
    // Rest template will be called by controller


    @GetMapping
    public String getAllRsvps() {

        return "";
    }

    @GetMapping
    public String getRsvpRecord(@RequestParam String fullName) {
        
        return ""; 
    }

    @PostMapping
    public Integer addRsvpRecord(String rsvpJson) {
        
        return 0;
    }

    @PutMapping
    public Integer updateRsvpRecord(String rsvpJson) {

        return 0;
    }

    @GetMapping
    public Integer getRsvpCount() {
        
        return 0;
    }
}
