package org.openjfx.javafxpresentation.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openjfx.javafxpresentation.entity.Attendee;
import org.openjfx.javafxpresentation.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
     * Gets all.
     */
    @Test
    void getAll() {
        attendeeDAO.getAll();
        List<Attendee> attendees = attendeeDAO.getAll();
        assertEquals(3, attendees.size());
    }
}