package chapter05.lesson07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 제목이 "tea"인 글이 없을 때만 INSERT 하는 예제.
 * 같은 main을 여러 번 실행해도 글이 계속 늘어나지 않게, 넣기 전에 먼저 조회한다.
 */
public class JdbcTeaInsert {
    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/kdt?sslMode=DISABLED";
    private static final String USER = "root";
    private static final String PASS = "kdtpass";

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            // 1) 글을 달아 줄 회원 id. 가장 작은 id 1명.
            int memberId;
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT id FROM jdbc_member ORDER BY id LIMIT 1");
                 ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    System.out.println("no jdbc_member");
                    return;
                }
                memberId = rs.getInt("id");
            }

            // 2) 제목 tea가 이미 있는지. rs.next()가 true면 1행 이상 있다는 뜻.
            boolean exists;
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT id FROM jdbc_post WHERE title = ? LIMIT 1")) {
                ps.setString(1, "tea"); // 첫 번째 ? 에 제목을 넣는다.
                try (ResultSet rs = ps.executeQuery()) {
                    exists = rs.next();
                }
            }

            // 3) 없을 때만 INSERT. 이미 있으면 inserted는 0으로 남는다.
            int inserted = 0;
            if (!exists) {
                try (PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO jdbc_post (member_id, title, body) VALUES (?, ?, ?)")) {
                    ps.setInt(1, memberId);
                    ps.setString(2, "tea");
                    ps.setString(3, "hot");
                    inserted = ps.executeUpdate();
                }
            }
            System.out.println("inserted " + inserted);

            // 4) 제목 tea인 행이 지금 몇 개인지. COUNT(*)는 행 개수를 숫자 한 칸으로 돌려준다.
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT COUNT(*) FROM jdbc_post WHERE title = ?")) {
                ps.setString(1, "tea");
                try (ResultSet rs = ps.executeQuery()) {
                    // COUNT는 행이 0개여도 결과 행이 항상 1개(값은 0)라 next()가 true다.
                    rs.next();
                    // 열 이름이 없으므로 1번째 열 번호로 읽는다.
                    System.out.println("count=" + rs.getInt(1));
                }
            }
        }
    }
}