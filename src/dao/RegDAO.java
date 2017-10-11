package dao;

import entity.Record;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegDAO {
    private static final String DRIVER = 
            "com.mysql.jdbc.Driver";
    private static final String URL = 
            "jdbc:mysql://contac01.mysql.ukraine.com.ua:3306/contac01_prilosh";
    private static final String LOGIN = 
            "contac01_prilosh";
    private static final String PASS = 
            "4h57futz";
    private static Connection getConnection(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, LOGIN, PASS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }
    static void add(Record r){
        Connection c = getConnection();
        Statement st = null;
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            st.executeUpdate("INSERT INTO "
                    + "pr_alex VALUES("
                    +new Random().nextInt()
                    +", '"+r.getUrl()+"', '"
                    +r.getLogin()+"', '"
                    +r.getPass()+"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    static List<Record> get(){
        List<Record> recs = new LinkedList<>();
        Connection c = getConnection();
        Statement st = null;
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT url,login,pass FROM pr_alex");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(rs != null){
            try {
                while(rs.next()){
                    recs.add(new Record(rs.getString("url")
                            , rs.getString("login")
                            , rs.getString("pass")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        try {
            st.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return recs;
    }
}
