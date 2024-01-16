/**
 * An address book that can store phone numbers and can link them to a name.
 * @author Rodrigo
 * @version 2.0
 */
public class AddressBook {

    /** A database storing all names and phone numbers in this address book. */
    private final Database database;

    /** The UI instance that will display the records of this address book. */
    private final UI ui;

    /**
     * Constructor that instantiates a UI object and a Database object.
     * @param ui The UI instance to be used for this address book.
     */
    public AddressBook(final UI ui)
    {
        this.ui = ui;
        database = new Database();
    }

    /**
     * Reads a Person from the user interface and adds them to the database.
     */
    public void addPerson() {
        database.add(ui.readPerson());
        ui.displayMsg("New entry successfully added.");
    }

    /**
     * Reads a Person's name from the user interface and tries to delete them.
     * If no such person exists, an error message is displayed.
     */
    public void deletePerson() {
        String name = ui.readName();
        if (database.removeByName(name) == null) {
            ui.displayErrorMsg("No person named " + name + " found.");
        } else {
            ui.displayMsg(name + " removed.");
        }
    }

    /**
     * Reads a Person's name from the user interface and tries to find them in
     * the database. If no such person exists, an error message is displayed.
     */
    public void findPerson() {
        String name = ui.readName();
        Person person = database.findByName(name);
        if (person == null) {
            ui.displayErrorMsg("No person named " + name + " found.");
        } else {
            display(person);
        }
    }

    /**
     * Displays the requested person on the user interface.
     * @param person The person to be displayed.
     */
    private void display(final Person person) {
        ui.display(person);
    }

    /**
     * Displays all people in the database on the user interface.
     */
    public void displayAll() {
        ui.displayAll(database.getAll());
    }

}
