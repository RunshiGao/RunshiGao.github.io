package dao;

import domain.User;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class UserDao {
    //声明JDBCTemplate 对象来共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser)  {

        try {
            //编写sql
            String sql = "Select * from user where username = ? and password = ?";
            //调用query方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean register(Connection con, User registerUser) throws Exception{
        boolean flag = false;
        PreparedStatement ps = null;

        String sql = "insert into user(username,password) values (?,?)";
        ps = con.prepareStatement(sql);
        ps.setString(1,registerUser.getUsername());
        ps.setString(2,registerUser.getPassword());
        if(ps.executeUpdate()>0){
            flag = true;
        }
        return flag;

    }
}
