package dev.tobys.springbook.user.dao;

import dev.tobys.springbook.user.domain.User;
import java.sql.*;

/**
 * 독립된 SimpleConnectionMaker를 사용하게 만든 UserDao
 */
public class UserDao {
    private SimpleConnectionMaker simpleConnectionMaker;

    public UserDao() {
        // 상태를 관리하는 것도 아니니 한 번만 만들어 인스턴스 변수에 저장해두고
        // 메소드에서 사용하게 한다.
        simpleConnectionMaker = new SimpleConnectionMaker();

    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = simpleConnectionMaker.makeNewConnection();
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
        Connection c = simpleConnectionMaker.makeNewConnection();
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
}
