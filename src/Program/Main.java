package Program;

import Model.DataAccessObject.DAO_Factory;
import Model.DataAccessObject.DepartmentDAO;
import Model.Entities.Department;


import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DepartmentDAO departmentDao = DAO_Factory.createDepartmentDAO();

        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        sc.close();
    }
}
