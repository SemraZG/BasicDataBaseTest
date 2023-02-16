package tests;

import Utilities.DBUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class test01 {

    @Test
    public void test01() throws SQLException {
        //students tablosunda selma isimli öğrencinin olduğunu test edin
        DBUtils.createToConnection("localhost", "DatabaseTesting", "postgres", "55.Semra");
        Statement statement= DBUtils.createStatement();

        String sql="SELECT name FROM students";
     ResultSet resultSet= statement.executeQuery(sql);
     List<String> names=new ArrayList<>();

     while (resultSet.next()){
         //System.out.println(resultSet.getString("name"));
         names.add(resultSet.getString("name"));
     }

     Assert.assertTrue(names.contains("selma"));
     Assert.assertEquals(5, names.size());

     DBUtils.closeConnectionAndStatement();

    }

}
