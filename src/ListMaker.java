import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        String menuChoice;
        boolean done = false;

        do
        {
            displayList(list);

            menuChoice = SafeInput.getRegExString(in, "A-Add D-Delete I-Insert P-Print Q-Quit", "[AaDdIiPpQq]");

            switch(menuChoice.toUpperCase())
            {
                case "A": addItem(in, list);
                    break;

                case "D": deleteItem(in, list);
                    break;

                case "I": insertItem(in, list);
                    break;

                case "P": printList(list);
                    break;

                case "Q":

                    if(SafeInput.getYNConfirm(in, "Are you sure you want to quit?"))
                    {
                        done = true;
                    }
                    break;
            }

        }while(!done);
    }

    private static void addItem(Scanner in, ArrayList<String> list)
    {
        String item;

        item = SafeInput.getNonZeroLenString(in, "Enter item to add");

        list.add(item);

        System.out.println("Item added.");
    }

    private static void deleteItem(Scanner in, ArrayList<String> list)
    {
        int itemNum;

        if(list.size() == 0)
        {
            System.out.println("List is empty.");
            return;
        }

        printNumberedList(list);

        itemNum = SafeInput.getRangedInt(in, "Enter item number to delete", 1, list.size());

        list.remove(itemNum - 1);

        System.out.println("Item deleted.");
    }

    private static void insertItem(Scanner in, ArrayList<String> list)
    {
        int location;
        String item;

        location = SafeInput.getRangedInt(in, "Insert before item number", 1, list.size() + 1);

        item = SafeInput.getNonZeroLenString(in, "Enter item text");

        list.add(location - 1, item);

        System.out.println("Item inserted.");
    }

    private static void printList(ArrayList<String> list)
    {
        System.out.println("\nCurrent List:");

        for(String item : list)
        {
            System.out.println(item);
        }

        System.out.println();
    }

    private static void printNumberedList(ArrayList<String> list)
    {
        System.out.println();

        for(int i = 0; i < list.size(); i++)
        {
            System.out.println((i + 1) + ". " + list.get(i));
        }

        System.out.println();
    }

    private static void displayList(ArrayList<String> list)
    {
        System.out.println("\n====================");
        System.out.println("Current List");
        System.out.println("====================");

        if(list.size() == 0)
        {
            System.out.println("List is empty.");
        }
        else
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }

        System.out.println();
    }
}