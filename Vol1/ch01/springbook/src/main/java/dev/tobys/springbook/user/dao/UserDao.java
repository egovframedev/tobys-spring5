package dev.tobys.springbook.user.dao;

import dev.tobys.springbook.user.domain.User;

import java.sql.*;

/**
 * 1. JDBC를 이용한 등록과 조회 기능이 있는 UserDao 클래스
 * 2. getConnection() 메소드를 추출해서 중복을 제거한 UserDao 클래스
 */
public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/springbook",
//                "springuser",
//                "springpass");
        // DB 연결 기능이 필요하면 getConnection() 메소드를 이용하게 한다.
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement(
                "INSERT INTO users(id, name, password) VALUES (?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/springbook",
//                "springuser",
//                "springpass");
        // DB 연결 기능이 필요하면 getConnection() 메소드를 이용하게 한다.
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    // 중복된 코드를 독립적인 메서드로 만들어서 중복을 제거 했다.
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/springbook",
                "springuser",
                "springpass");
        return c;
    }
}
