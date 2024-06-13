/*
Program Description:
Java Application to help manage Hardware Devices Supplier Business
*/
package assigment_question_1;

import java.util.Scanner;

public class Assigment_Question_1 {

    public static void main(String[] args) {
         
        Products methods = new Products();
        Scanner input = new Scanner(System.in);

        //Print Program launcher
        System.out.print("BRIGHT FUTURE TECHNOLOGIES APPLICATION\n"
                         + "**************************************\n"
                + "Enter (1) to launch menu or any other key to exit: ");
        //Get user Input
        String userInput = input.next();
        //If user selects 1 call menu
        if (userInput.matches("1"))
        {
            do
            {//Display menu for user to choose an option
                methods.DisplayMenu();
                userInput = input.next();//Get user choice
                switch(userInput){   
                    case "1"://(1) Capture a new product 
                        methods.captureProduct();
                    break;
                    case "2"://(2) Search for a product
                        methods.searchProduct();
                    break;
                    case "3"://(3) Update Product
                        methods.updateProduct();
                    break;
                    case "4"://(4) Delete a product
                        methods.deleteProduct();
                    break;
                    case "5"://(5) Print Report
                        methods.printReport();
                    break;
                    case "6"://(6) Exit Application
                        methods.exitApplication();
                    break; 
                }
                //Ask user to menu or leave program
                System.out.print("\nEnter (1) to launch menu"
                                 + " or any other key to exit: ");
                //Get user choice if 1 keep loop running
                userInput = input.next();
            } while(userInput.matches("1"));
        }
        else //If user selects anything beside 1 call exit program method
        {
            methods.exitApplication();
        }
    }
}//==========================================================================END
