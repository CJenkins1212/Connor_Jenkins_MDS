import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Controller{
    Model M1 = new Model();

    //Function to print entire main list
    public void printPeople() {
        //Iterates through main list and then prints the entire sub-list
        for(int i = 0; i < M1.People.size(); i++){
            //Takes item from main list for temporary use
            M1.Hold = (List<Object>) M1.People.get(i);
            System.out.println(M1.Hold);
        }
    }

    public void addManual(){
        String patch;
        M1.n = 0;
        //Makes sure person is empty
        M1.Person.clear();
        //takes user input and puts into person
        System.out.println("Enter the person's name");
        M1.Person.add(M1.myObj.nextLine());
        System.out.println("Enter the person's blood type");
        M1.two = M1.myObj.nextLine();
        //Checks if real blood type
        if(M1.two.equals("A+") || M1.two.equals("A-") || M1.two.equals("B+") || M1.two.equals("B-") || M1.two.equals("AB+") || M1.two.equals("AB-") || M1.two.equals("O+") || M1.two.equals("O-")){
            M1.Person.add(M1.two);
        }
        else{
            return;
        }
        System.out.println("Enter the person's age");
        M1.three = M1.myObj.nextInt();
        //Makes sure value is at least 0
        if(M1.three >= 0){
            M1.Person.add(M1.three);
        }
        else{
            return;
        }
        System.out.println("Enter the person's blood pressure");
        M1.four = M1.myObj.nextFloat();
        if(M1.four >= 0){
            M1.Person.add(M1.four);
        }
        else{
            return;
        }
        System.out.println("Enter the person's height");
        M1.five = M1.myObj.nextFloat();
        if(M1.five >= 0) {
            M1.Person.add(M1.five);
        }
        else{
            return;
        }
        System.out.println("Enter the person's weight");
        M1.six = M1.myObj.nextFloat();
        if(M1.six >= 0){
            M1.Person.add(M1.six);
        }
        else{
            return;
        }
        //catches an overflow
        patch = M1.myObj.nextLine();
        //Compares the name and blood type of the new person with all the people inside the list
        for(int i = 0; i < M1.People.size(); i++){
            //Temporarily takes item from main list
            M1.Hold = (List<Object>) M1.People.get(i);
            System.out.println(M1.Hold + "\n" + M1.Person);
            if((M1.Hold.get(0).toString().equals(M1.Person.get(0).toString())) && (M1.Hold.get(1).toString().equals(M1.Person.get(1).toString()))){
                //If the name and blood type matches n is set to 1
                M1.n = 1;
                //Alerts user of any people that did not get added to list
                System.out.println(M1.Person.get(0) + " did not get added to people because that person already exists.");
            }
        }

        //If n hasn't been set to 1 because the name and blood type matches a copy of the person will be added to the list
        if(M1.n == 0){
            M1.People.add(M1.Person.clone());
        }
        //Empties person when done
        M1.Person.clear();
        //Prints everything in the newly updated list out
        printPeople();
    }

    //Adds people to list from file
    public void addFile(){
        try{
            //User prompt
            System.out.println("Enter the name of the file you are entering");
            //Initializes FileReader to take file
            FileReader fileReader = new FileReader(M1.myObj.nextLine());
            //Initializes scanner to take from file
            Scanner scanner = new Scanner(fileReader);
            //Separates items by breaking them at the commas
            scanner.useDelimiter(",");
            //Ensures Person is empty
            M1.Person.clear();

            while (scanner.hasNextLine()) {
                M1.n = 0;
                //Takes data from file and adds it to Person
                Object data = scanner.next();
                M1.Person.add(data);
                data = scanner.next();
                M1.two = String.valueOf(data);
                if(M1.two.equals("A+") || M1.two.equals("A-") || M1.two.equals("B+") || M1.two.equals("B-") || M1.two.equals("AB+") || M1.two.equals("AB-") || M1.two.equals("O+") || M1.two.equals("O-")){
                    M1.Person.add(M1.two);
                }
                else{
                    M1.n = 1;
                }
                data = scanner.next();
                M1.three = Integer.parseInt(String.valueOf(data));
                if(M1.three >= 0){
                    M1.Person.add(M1.three);
                }
                else{
                    M1.n = 1;
                }
                data = scanner.next();
                M1.four = Float.parseFloat(String.valueOf(data));
                if(M1.four >= 0){
                    M1.Person.add(M1.four);
                }
                else{
                    M1.n = 1;
                }
                data = scanner.next();
                M1.five = Float.parseFloat(String.valueOf(data));
                if(M1.five >= 0){
                    M1.Person.add(M1.five);
                }
                else{
                    M1.n = 1;
                }
                //Takes data from file that doesn't end in a comma
                data = scanner.nextLine();
                String cut = data.toString();
                //Cuts off extra from data before entering it into person
                data = cut.replace(", ", "");
                M1.six = Float.parseFloat(String.valueOf(data));
                if(M1.six >= 0){
                    M1.Person.add(M1.six);
                }
                else{
                    M1.n = 1;
                }

                //Compares the name and blood type of the new person with all the people inside the list
                for(int i = 0; i < M1.People.size(); i++){
                    //Temporarily takes item from main list
                    M1.Hold = (List<Object>) M1.People.get(i);
                    if((M1.Hold.get(0).toString().equals(M1.Person.get(0).toString())) && (M1.Hold.get(1).toString().equals(M1.Person.get(1).toString()))){
                        //If the name and blood type matches n is set to 1
                        M1.n = 1;
                        //Alerts user of any people that did not get added to list
                        System.out.println(M1.Person.get(0) + " did not get added to people because the data was invalid.");
                    }
                }

                //If n hasn't been set to 1 because the ID matches a copy of the person will be added to the list
                if(M1.n == 0){
                    M1.People.add(M1.Person.clone());
                }
                else{
                    System.out.println(M1.Person.get(0) + " did not get added to people because that person already exists or is formated incorrectly.");
                }
                //Empties person when done
                M1.Person.clear();
            }
            scanner.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        //Prints everything in the newly updated list out
        printPeople();
    }

    public void removePerson(){
        //User prompt
        System.out.println("Enter name and blood type of person to remove");
        //Takes user input
        M1.r = M1.myObj.nextLine();
        M1.s = M1.myObj.nextLine();
        if(!M1.s.equals("A+") && !M1.s.equals("A-") && !M1.s.equals("B+") && !M1.s.equals("B-") && !M1.s.equals("AB+") && !M1.s.equals("AB-") && !M1.s.equals("O+") && !M1.s.equals("O-")){
            return;
        }
        //Goes through list checking name and blood type
        for(int i = 0; i < M1.People.size(); i++){
            //Temporarily takes item from main list
            M1.Hold = (List<Object>) M1.People.get(i);
            //If the name and blood type entered are the same as any person in the list, the person is removed
            if((M1.Hold.get(0).toString().equals(M1.r)) && (M1.Hold.get(1).toString().equals(M1.s))){
                M1.People.remove(i);
                //Used to check if a person matched
                M1.g = 1;
            }
        }
        //Alerts user what book was removed
        if(M1.g == 1){
            System.out.println(M1.Hold.get(0) + " removed.");
            //Prints updated list
            printPeople();
        }
        //Notifies user if that ID does not exist
        else{
            System.out.println("This person does not exist");
        }
    }

    public void editPerson(){
        M1.gfs = 0;
        //User prompt
        System.out.println("Enter name and blood type of person to edit");
        //Takes user input
        M1.r = M1.myObj.nextLine();
        M1.s = M1.myObj.nextLine();
        if(!M1.s.equals("A+") && !M1.s.equals("A-") && !M1.s.equals("B+") && !M1.s.equals("B-") && !M1.s.equals("AB+") && !M1.s.equals("AB-") && !M1.s.equals("O+") && !M1.s.equals("O-")){
            return;
        }
        M1.Person.clear();
        //Goes through list checking name and blood type
        for(int i = 0; i < M1.People.size(); i++){
            //Temporarily takes item from main list
            M1.Hold = (List<Object>) M1.People.get(i);
            //If the name and blood type entered are the same as any person in the list, the person's location is put in l
            if((M1.Hold.get(0).toString().equals(M1.r)) && (M1.Hold.get(1).toString().equals(M1.s))){
                M1.l = i;
                //stores correct person
                for(int j = 0; j < M1.Hold.size(); j++){
                    M1.Person.add(M1.Hold.get(j));
                }
                //Used to check if a person matched
                M1.g = 1;
            }
        }
        //Alerts user what book was removed
        if(M1.g == 1){
            //takes new variables to replace person
            System.out.println("Enter the person's name");
            M1.one = M1.myObj.nextLine();
            //if user leaves field empty the variable isn't changed
            if(!M1.one.isEmpty()){
                M1.Person.set(0, M1.one);
            }
            System.out.println("Enter the person's blood type");
            M1.two = M1.myObj.nextLine();
            if(!M1.two.isEmpty()){
                if(M1.two.equals("A+") || M1.two.equals("A-") || M1.two.equals("B+") || M1.two.equals("B-") || M1.two.equals("AB+") || M1.two.equals("AB-") || M1.two.equals("0+") || M1.two.equals("0-")){
                    M1.Person.set(1, M1.two);
                }
                else{
                    return;
                }
            }
            System.out.println("Enter the person's age");
            M1.et = M1.myObj.nextLine();
            if(!M1.et.isEmpty()){
                if(Integer.parseInt(String.valueOf(M1.et)) >= 0){
                    M1.Person.set(2, M1.et);
                }
            }
            System.out.println("Enter the person's blood pressure");
            M1.eo = M1.myObj.nextLine();
            if(!M1.eo.isEmpty()){
                if(Float.parseFloat(String.valueOf(M1.eo)) >= 0){
                    M1.Person.set(3, M1.eo);
                }
            }
            System.out.println("Enter the person's height");
            M1.ei = M1.myObj.nextLine();
            if(!M1.ei.isEmpty()){
                if(Float.parseFloat(String.valueOf(M1.ei)) >= 0){
                    M1.Person.set(4, M1.ei);
                }
            }
            System.out.println("Enter the person's weight");
            M1.es = M1.myObj.nextLine();
            if(!M1.es.isEmpty()){
                if(Float.parseFloat(String.valueOf(M1.es)) >= 0){
                    M1.Person.set(5, M1.es);
                }
            }

            //replaces the person with the updated version
            M1.People.remove(M1.l);
            M1.People.add(M1.Person.clone());
            //Prints updated list
            printPeople();
        }
        //Notifies user if that ID does not exist
        else{
            System.out.println("This person does not exist");
        }
        M1.gfs = 1;
    }

    public void getBMI(){
        //User prompt
        System.out.println("Enter name and blood type of person to edit");
        //Takes user input
        M1.r = M1.myObj.nextLine();
        M1.s = M1.myObj.nextLine();
        if(!M1.s.equals("A+") && !M1.s.equals("A-") && !M1.s.equals("B+") && !M1.s.equals("B-") && !M1.s.equals("AB+") && !M1.s.equals("AB-") && !M1.s.equals("O+") && !M1.s.equals("O-")){
            return;
        }
        //Goes through list checking name and blood type
        for(int i = 0; i < M1.People.size(); i++){
            //Temporarily takes item from main list
            M1.Hold = (List<Object>) M1.People.get(i);
            //If the name and blood type entered are the same as any person in the list, the person's location is put in l
            if((M1.Hold.get(0).toString().equals(M1.r)) && (M1.Hold.get(1).toString().equals(M1.s))){
                M1.l = i;
                for(int j = 0; j <M1.Hold.size(); j++){
                    M1.Person.add(M1.Hold.get(j));
                }
                //Used to check if a book matched
                M1.g = 1;
            }
        }
        if(M1.g == 1){
            //Calculates and prints BMI
            System.out.println("The BMI of " + M1.Person.get(0) + " is " + Float.parseFloat((M1.Person.get(5)).toString()) / (Float.parseFloat((M1.Person.get(4)).toString()) * Float.parseFloat((M1.Person.get(4)).toString())) * 703);
        }
        else{
            System.out.println("This person does not exist");
        }
    }
}
