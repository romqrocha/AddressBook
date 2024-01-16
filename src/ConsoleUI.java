import java.util.Scanner;

/**
 * Provides a user interface to the AddressBook class.
 * @author Rodrigo
 * @version 1.0
 */
public class ConsoleUI implements UI {

    /** The formatted header for the address book. */
    public static final String HEADER = String.format("%-20s %-15s",
            "Name", "Phone");

    /** A Scanner instance to read user input. */
    private final Scanner scan;

    /**
     * Constructor that instantiates a Scanner object.
     */
    public ConsoleUI() {
        scan = new Scanner(System.in);
    }

    /**
     * Performs the address book functions.
     * @param book The address book accessed by the UI.
     */
    @Override
    public void run(AddressBook book) {
        String choice;
        do {
            displayMenu();
            choice = readChoice();
            switch (choice) {
                case "1": book.addPerson(); break;
                case "2": book.deletePerson(); break;
                case "3": book.findPerson(); break;
                case "4": book.displayAll(); break;
                case "5": System.out.println("Quitting program..."); break;
                default: displayErrorMsg("Invalid input, please try again.");
            }
        } while (!choice.equals("5"));
    }

    /**
     * Displays the menu prompting users to choose an action.
     */
    public void displayMenu() {
        final String MENU = """
            1) Add
            2) Delete
            3) Find
            4) Display All
            5) Exit
            """;
        System.out.print(MENU);
    }

    /**
     * Reads the user's choice from a Scanner.
     * @return the user's choice.
     */
    public String readChoice() {
        System.out.print("Your choice: ");
        String choice = scan.next(); scan.nextLine();
        return choice;
    }

    /**
     * Displays a red error message on the user interface.
     * @param msg The error message to be printed.
     */
    @Override
    public void displayErrorMsg(String msg) {
        System.out.println(msg);
    }

    /**
     * Reads in the Person data from a Scanner and returns the new Person.
     * @return a new Person created from the input data.
     */
    @Override
    public Person readPerson() {
        String name = readName();
        System.out.print("Enter the person's phone number: ");
        String phone = scan.nextLine();
        return new Person(name, phone);
    }

    /**
     * Reads in the name of a Person from a Scanner and returns the name.
     * @return the name read from the Scanner.
     */
    @Override
    public String readName() {
        System.out.print("Enter the person's name: ");
        return scan.nextLine();
    }

    /**
     * Displays the String message passed on the user interface.
     * @param msg The message to be displayed.
     */
    @Override
    public void displayMsg(String msg) {
        System.out.println(msg);
    }

    /**
     * Displays a single person's data.
     * @param person the person to be displayed.
     */
    @Override
    public void display(Person person) {
        System.out.println(HEADER);
        System.out.printf("%-20s %-15s %n", person.getName(),
                person.getPhoneNumber());
    }

    /**
     * Displays all people in the database.
     * @param people the people to be displayed.
     */
    @Override
    public void displayAll(Person[] people) {
        System.out.println(HEADER);
        for (Person person : people) {
            System.out.printf("%-20s %-15s %n", person.getName(),
                    person.getPhoneNumber());
        }
    }

}
