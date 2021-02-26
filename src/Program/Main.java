package Program;

import Model.DataAccessObject.DAO_Factory;
import Model.DataAccessObject.SellerDAO;
import Model.Entities.Department;
import Model.Entities.Seller;

import java.util.Date;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SellerDAO sellerDAO = DAO_Factory.createSellerDAO();
        Department department = new Department(2,null);

        Seller newSeller = new Seller(null,"Greg Black","greg@gmail.com", new Date(),4000.00, department);
        sellerDAO.insert(newSeller);
        System.out.println("New seller added -  new ID:" +newSeller.getId());
    }
}
