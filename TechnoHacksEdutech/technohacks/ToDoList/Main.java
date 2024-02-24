import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<String> toDoItems;

    public Main() {
        toDoItems = new ArrayList<>();
    }

    public void addItem(String item) {
        toDoItems.add(item);
        System.out.println("Item added: " + item);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < toDoItems.size()) {
            String removedItem = toDoItems.remove(index);
            System.out.println("Item removed: " + removedItem);
        } else {
System.out.println("Invalid index. Please enter a valid index.");
        }
    }

    public void viewItems() {
        if (toDoItems.isEmpty()) {
            System.out.println("The to-do list is empty.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < toDoItems.size(); i++) {
                System.out.println((i + 1) + ". " + toDoItems.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Main Main = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. View items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to add: ");
                    String newItem = scanner.nextLine();
                    Main.addItem(newItem);
                    break;
                case 2:
System.out.print("Enter the index of the item to remove: ");
                    int indexToRemove = scanner.nextInt();
                    Main.removeItem(indexToRemove - 1); 
                    break;
                case 3:
                    Main.viewItems();
                    break;
                case 4:
System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
