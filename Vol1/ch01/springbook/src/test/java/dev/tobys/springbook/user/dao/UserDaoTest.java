package dev.tobys.springbook.user.dao;

import dev.tobys.springbook.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDaoTest {
    private UserDao dao;


    @BeforeEach
    void setUp() {
       dao = new DaoFactory().userDao();
    }

    @Test
    void addUserTest() throws Exception {
        User user = new User();
        user.setId("simpsons");
        user.setName("심프슨");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");
    }

    @Test
    void getUserTest() throws Exception {
        User user = dao.get("simpsons");

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());

        System.out.println(user.getId() + " 조회 성공");
    }
}