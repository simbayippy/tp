package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.DANIEL;
import static seedu.address.testutil.TypicalPersons.ELLE;
import static seedu.address.testutil.TypicalPersons.FIONA;
import static seedu.address.testutil.TypicalPersons.GEORGE;

import java.util.ArrayList;
import java.util.Arrays;

import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Appointment} objects to be used in tests.
 */
public class TypicalAppointments {

    public static final Person ALICE_WITH_APPOINTMENT = new PersonWithAppointmentBuilder(ALICE)
            .withDescription("See the doctor")
            .withDateTme("01-01-2024 00:00").build();

    public static final Person BENSON_WITHAPPOINTMENT = new PersonWithAppointmentBuilder(BENSON)
            .withDescription("Urine Exam")
            .withDateTme("01-11-2023 00:00").build();

    public static final Person CARL_WITH_APPOINTMENT = new PersonWithAppointmentBuilder(CARL)
            .withDescription("x-ray appointment")
            .withDateTme("05-02-2024 00:00").build();

    public static final Person DANIEL_WITH_APPOINTMENT = new PersonWithAppointmentBuilder(DANIEL)
            .withDescription("z-ray appointment")
            .withDateTme("05-02-2024 00:00").build();

    public static final Person ELLE_WITH_APPOINTMENT = new PersonWithAppointmentBuilder(ELLE)
            .withDescription("y-ray appointment")
            .withDateTme("05-02-2024 00:00").build();

    public static final Person FIONA_WITH_APPOINTMENT = new PersonWithAppointmentBuilder(FIONA)
            .withDescription("a-ray appointment")
            .withDateTme("05-02-2024 00:00").build();

    public static final Person GEORGE_WITH_APPOINTMENT = new PersonWithAppointmentBuilder(GEORGE)
            .withDescription("new appointment")
            .withDateTme("01-01-2026 00:00").build();

    private TypicalAppointments() {} // prevents instantiation

    public static ArrayList<Person> getTypicalPersonsWithAppointment() {
        return new ArrayList<>(Arrays.asList(ALICE_WITH_APPOINTMENT, BENSON_WITHAPPOINTMENT, CARL_WITH_APPOINTMENT,
                DANIEL_WITH_APPOINTMENT, ELLE_WITH_APPOINTMENT, FIONA_WITH_APPOINTMENT, GEORGE_WITH_APPOINTMENT));
    }
}
