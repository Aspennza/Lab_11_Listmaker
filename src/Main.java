import java.util.ArrayList;
import java.util.Scanner;

/**ADD JAVADOC**/

public class Main
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> listContainer = new ArrayList<>();
        String menuChoice = "";


        do {
            display(listContainer);

            menuChoice = SafeInput.getRegExString(in, "Enter A to add to the list, D to delete from the list, I to insert into the list, P to print the list, or Q to quit", "[AaDdIiPpQq]");

            switch (menuChoice)
            {
                case "a":
                case "A":
                    addItem(in, listContainer);
                    break;
                case "d":
                case "D":
                    deleteItem(in, listContainer);
                    break;
                case "i":
                case "I":
                    insertItem(in, listContainer);
                    break;
                case "p":
                case "P":

                case "q":
                case "Q":
            }



        }while(!menuChoice.equalsIgnoreCase("Q"));
    }

    private static void addItem(Scanner pipe, ArrayList<String> list)
    {
        String listItem = "";
        listItem = SafeInput.getNonZeroLenString(pipe, "Please enter your list item");

        list.add(listItem);
    }

    private static void deleteItem(Scanner pipe, ArrayList<String> list)
    {
        int itemIndex = 0;
        int lowRange = 1;
        int highRange = list.size();

        displayNumberedList(list);

        itemIndex = SafeInput.getRangedInt(pipe, "Enter the number of the item you want to delete", lowRange, highRange);

        itemIndex = itemIndex - 1;

        list.remove(itemIndex);
    }

    private static void insertItem(Scanner pipe, ArrayList<String> list)
    {
        String listItem = "";
        int itemIndex = 0;
        int lowRange = 1;
        int highRange = list.size();

        listItem = SafeInput.getNonZeroLenString(pipe, "Please enter your list item");

        displayNumberedList(list);

        itemIndex = SafeInput.getRangedInt(pipe, "Enter the list number where you want your item inserted", lowRange, highRange);

        itemIndex = itemIndex - 1;

        list.add(itemIndex, listItem);
    }

    private static void display(ArrayList<String> list)
    {
        String menu = "\nMenu: Add / Delete / Insert / Print / Quit";

        for(int x = 0; x < list.size(); x++)
        {
            System.out.println(list.get(x));
        }

        System.out.println(menu);
    }

    private static void displayNumberedList(ArrayList<String> list)
    {
        for(int x = 0; x < list.size(); x++)
        {
            int y = 0;
            y = x + 1;

            System.out.print(y + ". ");
            System.out.println(list.get(x));
        }
    }


}