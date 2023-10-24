package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.testutil.TypicalAppointments.getTypicalAddressBookPatientsAndAppointments;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_APPOINTMENT;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.EditAppointmentCommand.EditAppointmentDescriptor;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.person.Person;
import seedu.address.testutil.EditAppointmentDescriptorBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for RemarkCommand.
 */
public class EditAppointmentCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    @Test
    public void execute_editAppointmentSuccessful() throws ParseException {
//        Person validPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
//        Appointment validAppointment = model.getFilteredAppointmentList().get(INDEX_FIRST_APPOINTMENT.getZeroBased());
//
//        LocalDateTime time1 = ParserUtil.parseDateTime("02-01-2024 12:00");
//        Appointment editedAppointment = new Appointment("one", time1, validPerson);
//
//        EditAppointmentDescriptor descriptor = new EditAppointmentDescriptorBuilder(editedAppointment).build();
//        Index index = Index.fromZeroBased(model.getFilteredAppointmentList().indexOf(validAppointment));
//
//        EditAppointmentCommand editAppointmentCommand = new EditAppointmentCommand(index, descriptor);
//
//        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
//        expectedModel.setAppointment(validAppointment, editedAppointment);
//
//        String expectedMessage = String.format(EditAppointmentCommand.MESSAGE_EDIT_APPOINTMENT_SUCCESS,
//                editedAppointment, Messages.format(validPerson));
//
//        assertCommandSuccess(editAppointmentCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_AppointmentOnlyDescriptionEdited_success() throws ParseException, CommandException {
//        Person validPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
//        Appointment validAppointment = model.getFilteredAppointmentList().get(INDEX_FIRST_APPOINTMENT.getZeroBased());
//
//        EditAppointmentDescriptor descriptor = new EditAppointmentDescriptorBuilder()
//                .withDescription(VALID_APPOINTMENT_DESCRIPTION).build();
//        Appointment editedAppointment = new Appointment(VALID_APPOINTMENT_DESCRIPTION,
//                validAppointment.getDateTime(), validPerson);
//        Index index = Index.fromZeroBased(model.getFilteredAppointmentList().indexOf(validAppointment));
//
//        EditAppointmentCommand editAppointmentCommand = new EditAppointmentCommand(index, descriptor);
//
//        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
//        expectedModel.setAppointment(validAppointment, editedAppointment);
//
//        String expectedMessage = String.format(EditAppointmentCommand.MESSAGE_EDIT_APPOINTMENT_SUCCESS,
//                editedAppointment, Messages.format(validPerson));
//        assertCommandSuccess(editAppointmentCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noFieldSpecified_failure() throws ParseException {
//        Person validPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
//        LocalDateTime time1 = ParserUtil.parseDateTime("02-01-2024 12:00");
//        Appointment initialAdd = new Appointment("one", time1, validPerson);
//        validPerson.addAppointment(initialAdd);
//        model.addAppointment(initialAdd);
//        Index index = Index.fromZeroBased(model.getFilteredAppointmentList().indexOf(initialAdd));
//
//        EditAppointmentDescriptor descriptor = new EditAppointmentDescriptorBuilder().build();
//        Appointment edited = createEditedAppointment(initialAdd, descriptor, validPerson);
//
//        EditAppointmentCommand editAppointmentCommand = new EditAppointmentCommand(index, descriptor);
//        // testcase returns MESSAGE_DUPLICATE_APPOINTMENT as without proper input -> takes .orElse() (original input)
//        // thus, tests with MESSAGE_DUPLICATE_APPOINTMENT.
//        assertCommandFailure(editAppointmentCommand, model, editAppointmentCommand.MESSAGE_DUPLICATE_APPOINTMENT);
    }

    @Test
    public void execute_duplicateAppointment_failure() throws ParseException {
//        Person validPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
//        LocalDateTime time1 = ParserUtil.parseDateTime("02-01-2024 12:00");
//        Appointment initialAdd = new Appointment("one", time1, validPerson);
//        validPerson.addAppointment(initialAdd);
//        model.addAppointment(initialAdd);
//        Index index = Index.fromZeroBased(model.getFilteredAppointmentList().indexOf(initialAdd));
//
//        // edited person has SAME description and date
//        EditAppointmentDescriptor descriptor = new EditAppointmentDescriptorBuilder().withDescription("one")
//                .withDateTime("02-01-2024 12:00").build();
//
//        EditAppointmentCommand editAppointmentCommand = new EditAppointmentCommand(index, descriptor);
//
//        assertCommandFailure(editAppointmentCommand, model, editAppointmentCommand.MESSAGE_DUPLICATE_APPOINTMENT);
    }

    private static Appointment createEditedAppointment(Appointment apptToEdit, EditAppointmentDescriptor editApptDesc,
                                                       Person person) {
        assert apptToEdit != null;

        String updatedDescription = editApptDesc.getDescription().orElse(apptToEdit.getDescription());
        LocalDateTime updatedDateTime = editApptDesc.getDateTime().orElse(apptToEdit.getDateTime());

        return new Appointment(updatedDescription, updatedDateTime, person);
    }

}
