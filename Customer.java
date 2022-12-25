public class Customer{
    private  String customer_name, customer_surname, customer_gender, customer_country,customer_uniqueID;
    private  int customer_roomnumber, customer_age,customer_plan,customer_spendamount;

    public Customer(String customer_name, String customer_surname, String customer_gender, String customer_country, int customer_roomnumber, int customer_age, String customer_uniqueID,int customer_plan,int customer_spendamount) {
        this.customer_name = customer_name;
        this.customer_surname = customer_surname;
        this.customer_gender = customer_gender;
        this.customer_country = customer_country;
        this.customer_roomnumber = customer_roomnumber;
        this.customer_age = customer_age;
        this.customer_uniqueID = customer_uniqueID;
        this.customer_plan=customer_plan;
        this.customer_spendamount=customer_spendamount;
    }



    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_surname() {
        return customer_surname;
    }

    public void setCustomer_surname(String customer_surname) {
        this.customer_surname = customer_surname;
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_country() {
        return customer_country;
    }

    public void setCustomer_country(String customer_country) {
        this.customer_country = customer_country;
    }

    public int getCustomer_roomnumber() {
        return customer_roomnumber;
    }

    public void setCustomer_roomnumber(int customer_roomnumber) {
        this.customer_roomnumber = customer_roomnumber;
    }

    public int getCustomer_age() {
        return customer_age;
    }

    public void setCustomer_age(int customer_age) {
        this.customer_age = customer_age;
    }

    public String getCustomer_uniqueID() {
        return customer_uniqueID;
    }

    public void setCustomer_uniqueID(String customer_uniqueID) {
        this.customer_uniqueID = customer_uniqueID;
    }

    public int getCustomer_plan() {
        return customer_plan;
    }

    public void setCustomer_plan(int customer_plan) {
        this.customer_plan = customer_plan;
    }
    public int getCustomer_spendamount() {
        return customer_spendamount;
    }

    public void setCustomer_spendamount(int customer_spendamount) {
        this.customer_spendamount = customer_spendamount;
    }

}
