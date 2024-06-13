/*
 Class contains products info, all gets and sets
*/
package assigment_question_1;

public class ReportData {
    
    private String productCode;
    private String productName;
    private int productCategory;
    private String productWarranty;
    private int productPrice;
    private int productStockLevel;
    private String productSupplier;

    public ReportData() {
        
    }
    
    /**
     * @return the productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * @param productCode the productCode to set
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    /**
     * @return product category matched from int to string
     */
    public String getProductCategoryString() {
   
        String productCategoryString = "";//Store Product Category
        //Match int with correct product category
        switch (productCategory) {
            case 1:
                productCategoryString = "Desktop Computer";
                break;
            case 2:
                productCategoryString = "Laptop";
                break;
            case 3:
                productCategoryString = "Tablet";
                break;
            case 4:
                productCategoryString = "Printer";
                break;
            case 5:
                productCategoryString = "Gaming Console";
                break; 
            default:
                break;
        }  
        return productCategoryString;
    }
    
    /**
     * @return the productCategory
     */
    public int getProductCategory() {
        return productCategory;
    }

    /**
     * @param productCategory the productCategory to set
     */
    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }

    /**
     * @return determine the productWarranty time based 
     * on userInput and return it
     */
    public String getProductWarranty() {

        String warranty = "";
        //If user inputs 1 return 6 months ortherwise return 2 years
        if (productWarranty.equals("1"))
        {
            warranty = "6 months";
        } else {
             warranty = "2 years";
        }
        
        return warranty;
    }

    /**
     * @param productWarranty the productWarranty to set
     */
    public void setProductWarranty(String productWarranty) {
        this.productWarranty = productWarranty;
    }

    /**
     * @return the productPrice
     */
    public int getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice the productPrice to set
     */
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return the productStockLevel
     */
    public int getProductStockLevel() {
        return productStockLevel;
    }

    /**
     * @param productStockLevel the productStockLevel to set
     */
    public void setProductStockLevel(int productStockLevel) {
        this.productStockLevel = productStockLevel;
    }

    /**
     * @return the productSupplier
     */
    public String getProductSupplier() {
        return productSupplier;
    }

    /**
     * @param productSupplier the productSupplier to set
     */
    public void setProductSupplier(String productSupplier) {
        this.productSupplier = productSupplier;
    }
      
}//==========================================================================END
