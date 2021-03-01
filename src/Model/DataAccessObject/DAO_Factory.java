package Model.DataAccessObject;

import Db.DB;
import Model.DataAccessObject_impl.DepartmentDAO_JDBC;
import Model.DataAccessObject_impl.SellerDAO_JDBC;

public class DAO_Factory {

    public static SellerDAO createSellerDAO(){
        return new SellerDAO_JDBC(DB.getConnection());
    }

    public static DepartmentDAO createDepartmentDAO() {
        return new DepartmentDAO_JDBC(DB.getConnection());
    }
}
