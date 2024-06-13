/*
Class contains all your 
working methods
*/
package assigment_question_1;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;

public class Products {
    
    Scanner input = new Scanner(System.in);
    private ReportData productInfo = new ReportData(); 
    private ArrayList<ReportData> MyList = new ArrayList<ReportData>();
    //--------------------------------------------------------------------------
    //Method to Display Menu 
    public static void DisplayMenu() {
        //Print Menu
        System.out.print("\nPlease select one of the following menu items:\n"
                         + "(1) Capture a new product.\n"
                         + "(2) Search for a product.\n"
                         + "(3) Update a product.\n"
                         + "(4) Delete a product.\n"
                         + "(5) Print report.\n"
                         + "(6) Exit Application.\n"
                         + "Choice: ");  
    }//end of Method------------------------------------------------------------
    //Method to capture product details
    public void captureProduct() {
      
        this.productInfo = new ReportData();//Allocating memory
        
        System.out.println("\nCAPTURE A NEW PRODUCT\n"
                         + "*************************");
        //PRODUCT CODE
        System.out.print("Enter the product code: ");
        this.productInfo.setProductCode(input.next());
        //PRODUCT NAME
        System.out.print("Enter the product name: ");
        this.productInfo.setProductName(input.next());
        //PRODUCT CATEGORY
        System.out.print("Select the product category: "
                       + "\nDesktop Computer - 1"
                       + "\nLaptop - 2"
                       + "\nTablet - 3"
                       + "\nPrinter - 4"
                       + "\nGaming Console - 5\n\n"); 
        boolean valid = false;
        do{
            System.out.print("Product Category >> ");
            this.productInfo.setProductCategory(input.nextInt());
            //Check if product is between 1 and 5 
            //and if not make it invalid and inform user
            //and ask for a valid product category
            if((this.productInfo.getProductCategory() < 1) || (this.productInfo.getProductCategory() > 5))
            {
                System.out.println("Please enter a valid product category option between  1 to 5");
            }
            else {//If selection is between 1 and 5 make variable true to exit the loop
                valid = true;
            }
        } while(!valid);//If valid becomes true loop will be EXIT
        //PRODUCT WARRANTY
        System.out.print("Indicate the product warranty. Enter (1) "
                       + "for 6 months or any other key for 2 years: ");
        this.productInfo.setProductWarranty(input.next());
        //PRODUCT PRICE
        System.out.print("Enter the price for " + this.productInfo.getProductName() +" >> ");
        this.productInfo.setProductPrice(input.nextInt());
        //PRODUCT STOCK LEVEL
        System.out.print("Enter the stock level for " + this.productInfo.getProductName() + " >> ");
        this.productInfo.setProductStockLevel(input.nextInt());
        //PRODUCT SUPPLIER
        System.out.print("Enter the supplier for " + this.productInfo.getProductName() + " >> ");
        this.productInfo.setProductSupplier(input.next());
        //Info sucessfully captured message
        System.out.println("Product details has been saved succesfully");  
        
        //Add Object to array list
        this.MyList.add(productInfo);
    }//end of method------------------------------------------------------------
    //Method to search for a product using product code
    public void searchProduct() {
        //Ask User for Input product code      
        System.out.print("\nPlease enter the product code to search: ");
        String userInput = input.next();//Get Product Code input
        boolean found = false;
        //Loop for the length of array
        for (int j = 0 ; j < this.MyList.size(); j++)
        {//Check if userInput matches with array product code
            if (userInput.equals(this.MyList.get(j).getProductCode()))
            {
                found = true;//If product is found change to true
                
                System.out.print("******************************************************");
                System.out.print("\nPRODUCT SEARCH RESULTS");
                System.out.print("\n******************************************************");
                System.out.print("\nPRODUCT CODE:             " + this.MyList.get(j).getProductCode());
                System.out.print("\nPRODUCT NAME:             " + this.MyList.get(j).getProductName());
                System.out.print("\nPRODUCT WARRANTY:         " + this.MyList.get(j).getProductWarranty());
                System.out.print("\nPRODUCT CATEGORY          " + this.MyList.get(j).getProductCategoryString());
                System.out.print("\nPRODUCT PRICE              R" + this.MyList.get(j).getProductPrice());
                System.out.print("\nPRODUCT STOCK LEVELS:     " + this.MyList.get(j).getProductStockLevel());
                System.out.print("\nPRODUCT SUPPLIER:         " + this.MyList.get(j).getProductSupplier());
                System.out.print("\n******************************************************");
            }     
        }
        //If product is not found inform user
        if (found == false)
        {
            System.out.println("The product cannot be located. Invalid input.");
        }   
    }//end of method------------------------------------------------------------
    //Method to delete a product
    public void deleteProduct() {
        
        System.out.print("\nEnter product code: ");
        String userInput = input.next();
        int i = 0;
        boolean control = false;
        //Find product code
        for (i = 0; i < this.MyList.size(); i++)
        {//If Product is found
            if (this.MyList.get(i).getProductCode().equals(userInput)) 
            {//Ask user confirmation to delete
                control = true;
                System.out.print("Would you like to delete the product? Type 1 for YES or anthing else for NO: ");
                userInput = input.next();
                //If user confirms to delete
                if ("1".equals(userInput))
                {//deletes object
                 //Inform user that product was deleted
                    System.out.println("Product was successfully deleted");
                    this.MyList.remove(i);//Delete object
                    break;//exit
                }
                else//If user does not confirm delete
                {
                    break;//exit
                }
            }
        }
        //Inform user in case product code is not found
        if (control == false)
        {
            System.out.println("Product was not found");
        } 
    }//end of method------------------------------------------------------------
    //Method to  update details of product
    public void updateProduct () {
        
        System.out.print("\nPlease enter the product code to search: ");
        String userInput = input.next();
        boolean control = false;
        
        for (int i = 0; i < this.MyList.size(); i++)
        {//If Product is found     
            if (this.MyList.get(i).getProductCode().equals(userInput)) 
            {   
                control = true;
                //WARRANTY======================================================
                System.out.print("Update the warranty? (y) Yes, (n) No: ");
                userInput = input.next();
                //If answer is yes update
                if ("y".equals(userInput))
                {
                    System.out.print("Enter the new warranty for " + this.MyList.get(i).getProductName() + " >> ");
                    userInput = input.next();
                    this.MyList.get(i).setProductWarranty(userInput);
                }
                //PRICE=========================================================
                System.out.print("Update the product price? (y) Yes, (n) No: ");
                userInput = input.next();
                //If answer is yes update
                if ("y".equals(userInput))
                {
                    System.out.print("Enter the new product price for " + this.MyList.get(i).getProductName() + " >> ");
                    userInput = input.next();
                    this.MyList.get(i).setProductPrice(parseInt(userInput));
                }
                //STOCK LEVEL===================================================
                System.out.print("Update the stock level? (y) Yes, (n) No: ");
                userInput = input.next();
                //If answer is yes update
                if ("y".equals(userInput))
                {
                    System.out.print("Enter the new product stock level for " + this.MyList.get(i).getProductName() + " >> ");
                    userInput = input.next();
                    this.MyList.get(i).setProductStockLevel(parseInt(userInput));
                }
                //Inform user that product was updated sucessfully
                System.out.println("Product details has been updated sucessfully!!!");
            }
        }
        //If user does not type valid product code
        if (control == false)
        {
            System.out.println("Product was not found.");
        }
    }//end of method------------------------------------------------------------
    //Method to Display report
    public void printReport() {
        
        int totalProductCount = 0;
        int totalProductValue = 0;
        int averageProductValue = 0;
        
        System.out.println("PRODUCT REPORT");
        System.out.println("====================================================");
        //Print each object gets and sets
        for (int i = 0; i < this.MyList.size(); i++)
        {
            System.out.println("PRODUCT " + (i + 1));
            System.out.println("----------------------------------------------------");
            System.out.println("PRODUCT CODE >>           " + this.MyList.get(i).getProductCode());
            System.out.println("PRODUCT NAME >>           " + this.MyList.get(i).getProductName());
            System.out.println("PRODUCT CATEGORY >>       " + this.MyList.get(i).getProductCategory());
            System.out.println("PRODUCT WARRANTY >>       " + this.MyList.get(i).getProductWarranty());
            System.out.println("PRODUCT PRICE >>          " + this.MyList.get(i).getProductPrice());
            System.out.println("PRODUCT LEVEL >>          " + this.MyList.get(i).getProductStockLevel());
            System.out.println("PRODUCT SUPPLIER >>       " + this.MyList.get(i).getProductSupplier());
            System.out.println("----------------------------------------------------");
            
            totalProductCount = totalProductCount + 1;
            totalProductValue = totalProductValue + this.MyList.get(i).getProductPrice();
        }
        
        averageProductValue = totalProductValue / totalProductCount;
        
        System.out.println("====================================================");
        System.out.println("TOTAL PRODUCT COUNT: " + totalProductCount);
        System.out.println("TOTAL PRODUCT VALUE: R " + totalProductValue);
        System.out.println("AVERAGE PRODUCT VALUE R " + averageProductValue);
        System.out.println("====================================================");
    }//end of method------------------------------------------------------------
    //Method to terminate program
    public void exitApplication() {  
        System.exit(0);//terminate
    }//end of method------------------------------------------------------------
}//==========================================================================END

