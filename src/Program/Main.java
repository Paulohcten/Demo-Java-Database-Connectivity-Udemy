package Program;

import Model.DataAccessObject.DAO_Factory;
import Model.DataAccessObject.SellerDAO;
import Model.Entities.Department;
import Model.Entities.Seller;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SellerDAO sellerDAO = DAO_Factory.createSellerDAO();

        Department department = new Department(2,null);
        List<Seller> list = sellerDAO.findByDepartment(department);
        for (Seller obj:list) {
            System.out.println(obj);
        }
    }
}
