package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.person.Person;

/**
 * Deletes the appointment of an existing person in the address book.
 */
public class DeleteAppointmentCommand extends Command {
    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Index: %2$s";

    public static final String COMMAND_WORD = "delete_appt";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the Appointment identified "
            + "by the index number used in the displayed appointments list.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_APPOINTMENT_SUCCESS = "Deleted Appointment %1$s of %2$s";

    private final Index appointmentIndex;

    /**
     * @param appointmentIndex Index of the appointment
     */
    public DeleteAppointmentCommand(Index appointmentIndex) {
        requireAllNonNull(appointmentIndex);

        this.appointmentIndex = appointmentIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Appointment> lastShownAppointmentList = model.getFilteredAppointmentList();
        int zeroBasedAppointmentIndex = appointmentIndex.getZeroBased();
        System.out.println("HERE2");

        if (zeroBasedAppointmentIndex >= lastShownAppointmentList.size() || zeroBasedAppointmentIndex < 0) {
            System.out.println("HERE");
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
        System.out.println("HERE3");

        // Delete appointment from model and patient
        Appointment appointmentToDelete = lastShownAppointmentList.get(zeroBasedAppointmentIndex);
        Person patient = appointmentToDelete.getPerson();
        System.out.println("HERE4");
        int appointmentIndexInPatient = patient.getAppointments().indexOf(appointmentToDelete);
        System.out.println("HERE5");
        System.out.println(appointmentIndexInPatient); // this is -1

        patient.deleteAppointment(appointmentIndexInPatient);
        model.deleteAppointment(appointmentToDelete);
        System.out.println("HERE4");

        return new CommandResult(String.format(MESSAGE_DELETE_APPOINTMENT_SUCCESS, appointmentToDelete,
                Messages.format(patient)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteAppointmentCommand)) {
            return false;
        }

        DeleteAppointmentCommand otherDeleteApptCommand = (DeleteAppointmentCommand) other;
        return appointmentIndex.equals(otherDeleteApptCommand.appointmentIndex);
    }
}

