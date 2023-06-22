package sg.edu.iss.nus.workshop22.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import sg.edu.iss.nus.workshop22.model.Rsvp;

@Repository
public class RsvpRepository {
    
    @Autowired
    JdbcTemplate jTemplate;

    public List<Rsvp> getRsvpRecord() {
        return new ArrayList<Rsvp>(jTemplate.query("SELECT * FROM rsvp;", BeanPropertyRowMapper.newInstance(Rsvp.class)));
    }

    public Rsvp searchRsvpRecord(String fullName) {
        return jTemplate.queryForObject("SELECT * FROM rsvp WHERE full_name = ?;", BeanPropertyRowMapper.newInstance(Rsvp.class), fullName);
    }

    public Integer addRsvpRecord(Rsvp rsvp) {
        int addValue = jTemplate.update("INSERT INTO rsvp values('1', 'Joe', 'joe@email.com', '12345678', '2023-07-22', 'Here are some comments');", 
                        rsvp.getId(),
                        rsvp.getFullName(),
                        rsvp.getEmail(),
                        rsvp.getPhone(),
                        rsvp.getConfirmationDate(),
                        rsvp.getComments());
        return addValue;
    }

    public Integer updateRsvpRecord(Rsvp rsvp) {
        int updateValue = jTemplate.update("UPDATE rsvp SET full_name = ?, email = ?, phone = ?, confirmation_date = ?, comments = ? WHERE id = ?;",
                                        rsvp.getFullName(),
                                        rsvp.getEmail(),
                                        rsvp.getPhone(),
                                        rsvp.getConfirmationDate(),
                                        rsvp.getComments(),
                                        rsvp.getId());
        return updateValue;
    }
}
