/*
    Name: Spenser Currier
    Assignment: Program #0
    Course/Semester: CS 371/ Fall 2019
    Class Section:
    Lab Section:
    Sources consulted: Sola Gbenro
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class AclAnalyzer {
    public static void main( String[] args) throws FileNotFoundException{
        /** The current UserID used for parsing */
        int UserID;
        /** The current Resource used for parsing */
        int Resource;
        /** Flag used to tell if to print none */
        int noneFlag = 0;
        /** Variable for adding the current Resource to the previous ones */
        String tempResource;
        /** Array to know what to print*/
        ArrayList<FinalGroup> PrintingList = new ArrayList<>();
        /** Array to keep track of all UserID's*/
        ArrayList<Integer> UserIDS = new ArrayList<>();
        /** The first HashMap */
        HashMap<Integer,String> AllUsers = new HashMap<>();
        /** The second HashMap */
        HashMap<String, FinalGroup> NewGroups = new HashMap<>();

        //Parse through the input file creating the first HashMap named AllUsers
        try {
            File InputFile = new File(args[0]);
            Scanner sc = new Scanner(InputFile);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] CurrentLine = str.split(" ");
                    Resource = Integer.parseInt(CurrentLine[0]);
                    for(int i = 1; i < CurrentLine.length; i++){
                        UserID = Integer.parseInt(CurrentLine[i]);
                        if (!AllUsers.containsKey(UserID)) {
                            AllUsers.put(UserID, Integer.toString(Resource));
                            UserIDS.add(UserID);
                        } else {
                            tempResource = AllUsers.get(UserID);
                            String TempConCat = tempResource + Integer.toString(Resource);
                            AllUsers.put(UserID, TempConCat);
                        }
                    }
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.print("Command Argument Invalid");
        } //End of try catch with reading the file

        //Creation of the second dictionary
        for(int i = 0; i < UserIDS.size() ; i++){
            Collections.sort(UserIDS);
            if(!NewGroups.containsKey(AllUsers.get(UserIDS.get(i)))){
                NewGroups.put(AllUsers.get(UserIDS.get(i)), new FinalGroup(UserIDS.get(i)));
                PrintingList.add(NewGroups.get(AllUsers.get(UserIDS.get(i))));
            } else {
                FinalGroup temp2 = NewGroups.get(AllUsers.get(UserIDS.get(i)));
                temp2.add(UserIDS.get(i));
            }
        }
        //end of the second dictionary parse

        //Sort and printing
        Collections.sort(PrintingList);
        for(int i = 0; i < PrintingList.size(); i++){
            if(PrintingList.get(i).getCount() >= 2){
                System.out.println(PrintingList.get(i).toString());
                noneFlag = 1;
            }
        }
        if(noneFlag == 0){
            System.out.println("none");
        }
    }
}
