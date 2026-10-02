package chapter05.lesson07;

import java.sql.*;

public class JdbcPostWorkflow {
    private static final String URL = "jdbc:mysql://localhost:3306/kdt?sslMode=DISABLED";
    private static final String USER = "root";
    private static final String PASS = "kdtpass";

    public static void main(String[] args) throws SQLException {
        String sql = "SELECT id FROM jdbc_member limit 1;";
        int member_id;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            {
                try (PreparedStatement ps = conn.prepareStatement(sql);
                     ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        System.out.println("no jdbc_member");
                        return;
                    }
                    member_id = rs.getInt("id");
                    System.out.println(member_id);
                }
            }
            int postId = 0;
            try (PreparedStatement ps = conn.prepareStatement("SELECT id from jdbc_post where title=? ORDER BY id")) {
                ps.setString(1, "jdbc-flow");
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next())
                        postId = rs.getInt("id");
                }

            }
            if (postId == 0)
                try (PreparedStatement ps = conn.prepareStatement("INSERT INTO jdbc_post(member_id,title,BODY) VALUES(?,?,?);")) {
                    ps.setInt(1,member_id);
                    ps.setString(2, "jdbc-flow");
                    ps.setString(3, "draft");
                    ps.executeUpdate();
                }
            try (PreparedStatement ps = conn.prepareStatement("SELECT id from jdbc_post where title=? ORDER BY id")) {
                ps.setString(1, "jdbc-flow");
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next())
                        postId = rs.getInt("id");
                }
            }
            try(PreparedStatement ps=conn.prepareStatement("UPDATE jdbc_post SET  title=? where id=?")){
                ps.setString(1,"verified");
                ps.setInt(2,postId);
                ps.executeUpdate();
            }
            try(PreparedStatement ps=conn.prepareStatement("SELECT id,title,body from jdbc_post where id=? ORDER BY id;")){
                ps.setInt(1,postId);
                try(ResultSet rs=ps.executeQuery()){
                    if(rs.next())
                        System.out.println(rs.getInt("id")+" "+rs.getString("title")+" "+rs.getString("body"));
                }

            }
        }
    }
}
