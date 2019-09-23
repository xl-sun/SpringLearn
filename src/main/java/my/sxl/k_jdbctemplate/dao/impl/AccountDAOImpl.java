package my.sxl.k_jdbctemplate.dao.impl;

import my.sxl.k_jdbctemplate.pojo.Account;
import my.sxl.k_jdbctemplate.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {

    private final static String SQL_UPDATE = "UPDATE learn_spring_account SET username=?,phone=? WHERE id=?";
    private final static String SQL_GET_ALL = "SELECT * FROM learn_spring_account";
    private final static String SQL_BY_ID = "SELECT * FROM learn_spring_account WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("jdbcTemplateDBCP")
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void update(Account account) {
        Object[] args = {account.getUsername(),account.getPhone(),account.getId()};
        jdbcTemplate.update(SQL_UPDATE,args);
    }

    @Override
    public List<Account> getAll(){
        return jdbcTemplate.query(SQL_GET_ALL, BeanPropertyRowMapper.newInstance(Account.class));
    }

    @Override
    public Account getById(String id) {
        return jdbcTemplate.queryForObject(SQL_BY_ID, BeanPropertyRowMapper.newInstance(Account.class),id);
    }
}
