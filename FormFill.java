public class FormFill
{
    
    private String fName;
    private String lName;
    private int streetNumber;
    private String streetName;
    private String aptNumber;
    
    // Constructor that sets the first and last name
    // streetNumber defaults to 0
    // the others default to an empty String
    public FormFill(String firstName, String lastName)
    {
        this.fName = firstName;
        this.lName = lastName;
        this.streetNumber = 0;
        this.streetName = "";
        this.aptNumber = "";
    }
    
    // Sets streetNumber, streetName, and aptNumber to the given values
    public void setAddress(int number, String street, String apt)
    {
        this.streetNumber = number;
        this.streetName = street;
        this.aptNumber = apt;
    }
    

    // Return string should be formatted 
    // with the last name, then a comma and space, then the first name.
    // For example: LastName, FirstName
    public String fullName()
    {
        return this.lName + ", " + this.fName;
    }
    
    // Returns the formatted address
    // Formatted like this
    // 
    // streetNumber streetName
    // Apt aptNumber
    //
    public String streetAddress()
    {
        return streetNumber + " " + streetName + 
            "\nApt " +  aptNumber;
    }
    
    // Returns a string with the credit card information
    // Formatted like this:
    // 
    // Card Number: Card#
    // Expires: expMonth/expYear
    //
    // Takes Credit Card Number and other info as parameter so it doesn't 
    // store sensitive info
    public String creditCardInfo(int creditCardNumber, int expMonth, int expYear)
    {
        return "Card Number: " + creditCardNumber +
            "\nExpires: " + expMonth + "/" + expYear;
    }
    
}
