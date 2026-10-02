package chapter05.lesson07;

import java.sql.*;

public class jdbcPostInsert {
    private static final String URL = "jdbc:mysql://localhost:3306/kdt?sslMode=DISABLED";
    private static final String USER = "root";
    private static final String PASS = "kdtpass";

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
        int member_Id=0;
        String findsql="SELECT id FROM jdbc_member ORDER BY id limit 1";
        try(PreparedStatement find=conn.prepareStatement(findsql);
       ResultSet rs= find.executeQuery()){
    if(!rs.next()){
        System.out.println("no jdbc_member");
        return;
    }
    member_Id=rs.getInt("id");
            }
            String sql="Insert INTO jdbc_post(member_id,title,body) VALUES(?,?,?);";
        try(PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,member_Id);
            ps.setString(2,"jdbc");
            ps.setString(3,"from java");

            int n=ps.executeUpdate();
            System.out.println("inserted "+n);
        }
        }
    }
}