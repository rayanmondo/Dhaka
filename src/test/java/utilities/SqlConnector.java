package utilities;

import java.sql.*;

public class SqlConnector {
    private static final String Url = "jdbc:postgresql://localhost:5432/refiCalculator";
    //"jdbc:postgresql://localhost:5432/mortgage_calculator";
    private static final String User = "postgres";
    private static final String Password = "saifan";
    /**connect to the PostgreSql database
     *
     * @return a connection object
     */
    public static Connection connect(){
        Connection connObj=null;
        try{
            connObj= DriverManager.getConnection(Url,User,Password);
            System.out.println("Connected to the PostgreSQL server successfully");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return connObj;
    }
    /**reading data from the database
     * @param SQL is the method parameter to except sql quarry
     * @return a resultSet object
     */
    public static ResultSet readData(String SQL){
        ResultSet rsObj=null;
        try{
            Connection connObj=connect();
            Statement stateObj=connObj.createStatement();
            rsObj=stateObj.executeQuery(SQL);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rsObj;
    }
}
