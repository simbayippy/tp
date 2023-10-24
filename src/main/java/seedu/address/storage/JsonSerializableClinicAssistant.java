package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ClinicAssistant;
import seedu.address.model.ReadOnlyClinicAssistant;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.person.Person;

/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableClinicAssistant {

    public static final String MESSAGE_DUPLICATE_PERSON = "Persons list contains duplicate person(s).";

    private final List<JsonAdaptedPerson> persons = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given persons.
     */
    @JsonCreator
    public JsonSerializableClinicAssistant(@JsonProperty("persons") List<JsonAdaptedPerson> persons) {
        this.persons.addAll(persons);
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableClinicAssistant(ReadOnlyClinicAssistant source) {
        persons.addAll(source.getPersonList().stream().map(JsonAdaptedPerson::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public ClinicAssistant toModelType() throws IllegalValueException {
        ClinicAssistant clinicAssistant = new ClinicAssistant();
        for (JsonAdaptedPerson jsonAdaptedPerson : persons) {
            Person person = jsonAdaptedPerson.toModelType();
            System.out.println("1");
            ArrayList<Appointment> appointments = jsonAdaptedPerson.toModelTypeAppointments(person);
            System.out.println("2");
            person.setAppointments(appointments);
            System.out.println("3");
            if (clinicAssistant.hasPerson(person)) {
                System.out.println("4");
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            System.out.println("5");
            clinicAssistant.addPerson(person);
            System.out.println("6");
            // ADDS ENTIRE LIST TO BE APPENDED TO THE MAIN APPOINTMENT LIST.
            System.out.println(appointments);
            clinicAssistant.addAppointmentAsList(appointments);
            System.out.println("7");
        }
        return clinicAssistant;
    }

}
