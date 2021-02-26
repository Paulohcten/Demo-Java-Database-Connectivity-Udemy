package Model.DataAccessObject;

import Db.DB;
import Model.DataAccessObject_impl.SellerDAO_JDBC;

public class DAO_Factory {

    public static SellerDAO createSellerDAO(){
        return new SellerDAO_JDBC(DB.getConnection());
    }
}
