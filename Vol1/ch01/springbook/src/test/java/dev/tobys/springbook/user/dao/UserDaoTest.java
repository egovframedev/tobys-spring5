package dev.tobys.springbook.user.dao;

import dev.tobys.springbook.user.domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    private UserDao dao;

    // 관계설정 책입이 추가된 UserDao 클라이언트인 setUp() 메소드
    @BeforeEach
    void setUp() {
        // UserDao가 사용할 ConnectionMaker  구현 클래스를 결정하고 오브젝트를 생성한다.
        ConnectionMaker connectionMaker = new DConnectionMaker();
        dao = new UserDao(connectionMaker); // 사용할 ConnectionMaker 타입의 오브젝트 제공
        
    }

    @Test
    void addUserTest() throws Exception {
        User user = new User();
        user.setId("smith");
        user.setName("존스미스");
        user.setPassword("single");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");
    }

    @Test
    void getUserTest() throws Exception {
        User user = dao.get("smith");

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());

        System.out.println(user.getId() + " 조회 성공");
    }
}