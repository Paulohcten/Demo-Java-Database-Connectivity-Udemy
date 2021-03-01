package Program;

import Model.DataAccessObject.DAO_Factory;
import Model.DataAccessObject.DepartmentDAO;
import Model.DataAccessObject.SellerDAO;
import Model.Entities.Department;
import Model.Entities.Seller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        DepartmentDAO departmentDAO = DAO_Factory.createDepartmentDAO();
        SellerDAO sellerDAO = DAO_Factory.createSellerDAO();

        System.out.println("Database connectivity ");
        System.out.println("Enter the database you want to edit:\n1-Department\n2-Sellers");
        int tableSelect = sc.nextInt();
        switch (tableSelect) {
            case 1:
                System.out.println("Department: Selected");
                System.out.println("Enter the desired function:\n1-Insert\n2-Update\n3-Delete by ID\n4-Find by ID\n5-Find All");
                int functionSelect = sc.nextInt();
                switch (functionSelect) {
                    case 1:
                        System.out.print("New department name: ");
                        sc.nextLine();
                        String newDepName = sc.nextLine();
                        Department newDepartment = new Department(null, newDepName);
                        departmentDAO.insert(newDepartment);
                        System.out.println("Inserted! New id: " + newDepartment.getId());
                        break;

                    case 2:
                        System.out.print("Enter the seller ID: ");
                        int depIdForUpdate= sc.nextInt();
                        Department department = new Department(depIdForUpdate,null);
                        System.out.print("Update department name: ");
                        sc.nextLine();
                        String upDepName = sc.nextLine();
                        department.setName(upDepName);
                        departmentDAO.update(department);
                        break;

                    case 3:
                        System.out.print("Enter the department ID: ");
                        int depIdForDel= sc.nextInt();
                        departmentDAO.deleteById(depIdForDel);
                        System.out.println("Department removed");
                        break;

                    case 4:
                        System.out.print("Enter the department ID: ");
                        int depIdSearch= sc.nextInt();
                        Department depSearch = departmentDAO.findById(depIdSearch);
                        System.out.println(depSearch);
                        break;

                    case 5:
                        List<Department> listAllDepartments = departmentDAO.findAll();
                        for (Department depAllSearch:listAllDepartments) {
                            System.out.println(depAllSearch);
                        }
                        break;

                    default:
                        System.out.println("ERROR! Invalid option");
                        break;
                }
                break;
            case 2:
                System.out.println("Sellers: Selected");
                System.out.println("Enter the desired function:\n1-Insert\n2-Update\n3-Delete by ID\n4-Find by ID\n5-Find by Department\n6-Find All");
                int sellerFunctionSelect = sc.nextInt();
                switch (sellerFunctionSelect) {
                    case 1:
                        System.out.print("New seller name: ");
                        sc.nextLine();
                        String sellerName = sc.nextLine();
                        System.out.print("New seller email: ");
                        String sellerEmail = sc.nextLine();
                        System.out.print("New seller birth date: ");
                        Date sellerBirthDate = sdf.parse(sc.next());
                        System.out.print("New seller salary: ");
                        double sellerSalary = sc.nextDouble();
                        System.out.print("New seller department: ");
                        int sellerDep = sc.nextInt();
                        Department department = new Department(sellerDep,null);
                        Seller newSeller = new Seller(null,sellerName,sellerEmail, sellerBirthDate,sellerSalary,department);
                        sellerDAO.insert(newSeller);
                        System.out.println("New seller added -  new ID:" +newSeller.getId());
                        break;

                    case 2:
                        System.out.print("Enter the seller ID: ");
                        int idForUpdate= sc.nextInt();
                        Seller seller =  sellerDAO.findById(idForUpdate);
                        System.out.print("Change seller name: ");
                        sc.nextLine();
                        String upSellerName = sc.nextLine();
                        System.out.print("Change seller email: ");
                        String upSellerEmail = sc.nextLine();
                        System.out.print("Change seller birth date: ");
                        Date upSellerBirthDate = sdf.parse(sc.next());
                        System.out.print("Change seller salary: ");
                        double upSellerSalary = sc.nextDouble();
                        System.out.print("Change seller department: ");
                        Integer upSellerDep = sc.nextInt();
                        Department upDepartment = new Department(upSellerDep,null);

                        seller.setName(upSellerName);
                        seller.setEmail(upSellerEmail);
                        seller.setBirthDate(upSellerBirthDate);
                        seller.setBaseSalary(upSellerSalary);
                        seller.setDepartment(upDepartment);
                        sellerDAO.update(seller);
                        System.out.println("Seller updated");
                        break;

                    case 3:
                        System.out.print("Enter the seller ID: ");
                        int idForDel= sc.nextInt();
                        sellerDAO.deleteById(idForDel);
                        System.out.println("Seller removed");
                        break;

                    case 4:
                        System.out.print("Enter the seller ID: ");
                        int sellerIdSearch= sc.nextInt();
                        seller = sellerDAO.findById(sellerIdSearch);
                        System.out.println(seller);
                        break;

                    case 5:
                        System.out.print("Enter the department ID: ");
                        int sellerDepIdSearch= sc.nextInt();
                        Department departmentSearch = new Department(sellerDepIdSearch,null);
                        List<Seller> listByDep = sellerDAO.findByDepartment(departmentSearch);
                        for (Seller obj:listByDep) {
                            System.out.println(obj);
                        }
                        break;

                    case 6:
                        List<Seller> listAllSellers = sellerDAO.findAll();
                        for (Seller obj:listAllSellers) {
                            System.out.println(obj);
                        }
                        break;

                    default:
                        System.out.println("ERROR! Invalid option");
                        break;
                }
                break;
        }
        sc.close();
    }
}
