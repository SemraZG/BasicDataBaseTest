package tests;

import Utilities.DBUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class test02 {
    @Test
    public void test02() throws SQLException {

        //students tablosunda not ortalamasının 9dan küçük olduğunu test edin.
        DBUtils.createToConnection("localhost", "DatabaseTesting", "postgres", "55.Semra");
        Statement statement= DBUtils.createStatement();

        String sql="SELECT AVG(degree) FROM students";
        ResultSet resultSet= statement.executeQuery(sql);
        resultSet.next();

        double averageNote= resultSet.getDouble(3);
        System.out.println(averageNote);

        Assert.assertTrue(averageNote<90);

    }
}
