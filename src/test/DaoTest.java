package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class DaoTest {
    @Test
    public void LoginTest(){
        User loginUser = new User();
        loginUser.setUsername("admin");
        loginUser.setPassword("admin");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
