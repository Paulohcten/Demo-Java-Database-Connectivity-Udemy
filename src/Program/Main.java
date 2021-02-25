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

        /*Test

        Department obj =new Department(1,"Books");
        Seller seller = new Seller(21,"Bob","bob@gmail",new Date(), 3000.0,obj);

        SellerDAO sellerDAO = DAO_Factory.createSellerDAO();

        System.out.println(seller);

         */
    }
}
