package org.openjfx.javafxpresentation.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openjfx.javafxpresentation.entity.Attendee;
import org.openjfx.javafxpresentation.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Attendee dao test.
 */
public class AttendeeDAOTest {
    /**
     * The Attendee dao.
     */
    GenericDAO<Attendee> attendeeDAO;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        attendeeDAO = new GenericDAO<>(Attendee.class);
        Database db = new Database();
        db.runSQL("cleanDB.sql");
    }

    /**
     * Inserts.
     */
    @Test
    void insert() {
        int insertedAttendeeId;
        Attendee attendee = new Attendee("aj", "fait", "ajfait@gmail.com", false, "608-999-5555", true);
        insertedAttendeeId = attendeeDAO.insert(attendee);
        Attendee attendeeInserted = (Attendee)attendeeDAO.getById(insertedAttendeeId);
        assertNotNull(attendeeInserted);
        assertEquals("ajfait@gmail.com", attendeeInserted.getEmail());
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        attendeeDAO.getAll();
        List<Attendee> attendees = attendeeDAO.getAll();
        assertEquals(3, attendees.size());
    }

    /**
     * Gets by id.
     */
    @Test
    void getById() {
        Attendee attendee = attendeeDAO.getById(1);
        assertNotNull(attendee);
        assertEquals("jordyfait@gmail.com", attendee.getEmail());
    }

    /**
     * Updates.
     */
    @Test
    void update() {
        Attendee attendee = attendeeDAO.getById(2);
        attendee.setFirstName("aj");
        attendeeDAO.update(attendee);
        Attendee attendeeUpdated = attendeeDAO.getById(2);
        assertEquals("aj", attendeeUpdated.getFirstName());
    }

    /**
     * Deletes.
     */
    @Test
    void delete() {
        Attendee attendee = attendeeDAO.getById(3);
        attendeeDAO.delete(attendee);
        Attendee attendeeDeleted = attendeeDAO.getById(3);
        assertNull(attendeeDeleted);
    }
}