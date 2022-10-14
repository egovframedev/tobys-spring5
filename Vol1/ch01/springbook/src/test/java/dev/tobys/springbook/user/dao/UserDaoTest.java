package dev.tobys.springbook.user.dao;

import dev.tobys.springbook.user.domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    private UserDao dao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
    }

    @Test
    void addUserTest() throws Exception {
        User user = new User();
        user.setId("mrhong");
        user.setName("홍길동");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");
    }

    @Test
    void getUserTest() throws Exception {
        User user = dao.get("mrhong");

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());

        System.out.println(user.getId() + " 조회 성공");
    }
}