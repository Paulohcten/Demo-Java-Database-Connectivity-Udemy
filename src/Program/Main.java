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

        System.out.print("Delete by Id: ");
        int delById = sc.nextInt();
        sellerDAO.deleteById(delById);
        System.out.println("Delete executed");

        sc.close();
    }
}
