package Program;

import Model.DataAccessObject.DAO_Factory;
import Model.DataAccessObject.SellerDAO;
import Model.Entities.Seller;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SellerDAO sellerDAO = DAO_Factory.createSellerDAO();
        Seller seller =  sellerDAO.findById(11);
        seller.setName("Luna White");
        seller.setEmail("luna@gmail.com");
        seller.setBaseSalary(2500.00);

        sellerDAO.update(seller);
    }
}
