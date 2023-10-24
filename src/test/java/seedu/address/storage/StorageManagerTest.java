package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.ClinicAssistant;
import seedu.address.model.ReadOnlyClinicAssistant;
import seedu.address.model.UserPrefs;

public class StorageManagerTest {

    private static final Logger logger = Logger.getLogger(StorageManagerTest.class.getName());

    @TempDir
    public Path testFolder;

    private StorageManager storageManager;

    @BeforeEach
    public void setUp() {
        JsonClinicAssistantStorage addressBookStorage = new JsonClinicAssistantStorage(getTempFilePath("ab"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(getTempFilePath("prefs"));
        storageManager = new StorageManager(addressBookStorage, userPrefsStorage);
    }

    private Path getTempFilePath(String fileName) {
        return testFolder.resolve(fileName);
    }

    @Test
    public void prefsReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonUserPrefsStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonUserPrefsStorageTest} class.
         */
        UserPrefs original = new UserPrefs();
        original.setGuiSettings(new GuiSettings(300, 600, 4, 6));
        storageManager.saveUserPrefs(original);
        UserPrefs retrieved = storageManager.readUserPrefs().get();
        assertEquals(original, retrieved);
    }

    @Test
    public void addressBookReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonAddressBookStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonAddressBookStorageTest} class.
         */
        ClinicAssistant original = getTypicalAddressBook();
        logger.info("original " + original);
        // saves to json
        storageManager.saveClinicAssistant(original);
        logger.info("reaches here ");

        // reads from json
        Optional<ReadOnlyClinicAssistant> optional = storageManager.readClinicAssistant();
        logger.info("in betweem");
        ReadOnlyClinicAssistant retrieved = optional.get();
//        ReadOnlyClinicAssistant retrieved = storageManager.readClinicAssistant().get();
        logger.info("NOT HERE");
        logger.info("retrieved " + retrieved);
        assertEquals(original, new ClinicAssistant(retrieved));
    }

    @Test
    public void getAddressBookFilePath() {
        assertNotNull(storageManager.getClinicAssistantFilePath());
    }

}
