import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final ArrayList<String> itemList = new ArrayList<>();

    //this is were my public method
    public static void main(String[] args) {
        boolean quit = false;
        do {
            Litz();  // Show the current list and the box
            Menu();  // Show the menu
            String cmd = SafeInput.getRegExString(in, "Enter your choice", "[AaDdIiPpQq]").toUpperCase();

            if (cmd.equals("A")) { //if else statement for letters simple
                Addmorestuff();
            } else if (cmd.equals("D")) {
                Deli();
            } else if (cmd.equals("I")) {
                More();
            } else if (cmd.equals("P")) {
                printmore();
            } else if (cmd.equals("Q")) {
                quit = StopNow();
            }

        } while (!quit); //this helps with end
    //start of the private methods
    }
    //old code deleted comments for some reason
    //recheck the methods
    //changed the spacing it was getting hard to read
    //add a comment for each letter
    //don't forget toa
private static void Menu() {
        System.out.println("Menu Options:");
        System.out.println("A = Add an item to the list");
        System.out.println("D = Delete an item from the list");
        System.out.println("I = Insert an item into the list");
        System.out.println("P = Print the list");
        System.out.println("Q = Quit the program");
    }
    //
private static void Litz() {
        SafeInput.prettyHeader("Current List");
        if (itemList.isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            for (int i = 0; i < itemList.size(); i++) {
                System.out.printf("%d: %s\n", i + 1, itemList.get(i));
            }
        }
    }

    //a
private static void Addmorestuff() {
        System.out.println("Add Item");
        String item = SafeInput.getNonZeroLengthString(in, "Enter item to add");
        itemList.add(item);
    }

    //d
private static void Deli() {
        System.out.println("Delete Item");
        if (itemList.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        Litz();  // Show list with numbers
        int index = SafeInput.getRangedInt(in, "Enter item number to delete", 1, itemList.size());
        itemList.remove(index - 1);
        System.out.println("Item deleted.");
    }

    //i
private static void More() {
        System.out.println("Insert Item");
        String item = SafeInput.getNonZeroLengthString(in, "Enter item to insert");
        int index = SafeInput.getRangedInt(in, "Enter position to insert at", 1, itemList.size() + 1);
        itemList.add(index - 1, item);
        System.out.println("Item inserted.");
    }
    //p
private static void printmore() {
        System.out.println("Print List");
        Litz();
    }

    //q
private static boolean StopNow() {
        System.out.println("Quit");
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
    }
}