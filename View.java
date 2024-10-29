import java.util.*;

/* The View class give the user the options to interact with the functions of the controller class
through a list of options that are output to the console, it takes the user's input to decide where to go
*/
public class View {
    public static void main(String[] args) {
        //Initializes scanner
        Scanner myObj = new Scanner(System.in);
        //Initializes variables for loop
        int inf = 0;
        int cho = 0;
        //Initializes library object
        Controller C1 = new Controller();
        Model M1 = new Model();

        //Infinite loop
        while (inf == 0) {
            //User prompt
            System.out.println("Enter 1 to display people\nEnter 2 to add a person manually\nEnter 3 to enter a person through a file\nEnter 4 to remove a person\nEnter 5 to edit a person\nEnter 6 to get a person's BMI\nEnter 0 to exit");
            //prevents wrong data types from crashing the software
            try {
                //Takes user input
                cho = myObj.nextInt();
                if (cho == 1) {
                    C1.printPeople();
                } else if (cho == 2) {
                    C1.addManual();
                } else if (cho == 3) {
                    C1.addFile();
                } else if (cho == 4) {
                    C1.removePerson();
                } else if (cho == 5) {
                    C1.editPerson();
                } else if (cho == 6) {
                    C1.getBMI();
                } else if (cho == 0) {
                    //Shuts down program
                    System.exit(0);
                }
            } catch (Exception e) {
                //alerts user
                System.out.println("That is not the correct data type");
                //breaks out of infinite loop
                myObj.next();
            }

        }
    }
}
