package my.sxl.k_jdbctemplate.dao.impl;

import my.sxl.k_jdbctemplate.dao.AccountBalanceDAO;
import my.sxl.k_jdbctemplate.pojo.Account;
import my.sxl.k_jdbctemplate.dao.AccountDAO;
import my.sxl.k_jdbctemplate.pojo.AccountBalance;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public class AccountBalanceDAOImpl extends JdbcDaoSupport implements AccountBalanceDAO {

    private final static String SQL_UPDATE = "UPDATE learn_spring_account_balance SET balance=? WHERE id=?";
    private final static String SQL_GET_ALL = "SELECT * FROM learn_spring_account_balance";
    private final static String SQL_BY_ID = "SELECT * FROM learn_spring_account_balance WHERE id=?";
    private final static String SQL_DEPOSIT = "UPDATE learn_spring_account_balance SET balance=balance+? WHERE id=?";
    private final static String SQL_WITHDRAW = "UPDATE learn_spring_account_balance SET balance=balance-? WHERE id=?";

    @Override
    public void update(AccountBalance accountBalance) {
        Object[] args = {accountBalance.getBalance(),accountBalance.getId()};
        //assert this.getJdbcTemplate() != null;
        this.getJdbcTemplate().update(SQL_UPDATE,args);
    }

    @Override
    public List<AccountBalance> getAll(){
        return this.getJdbcTemplate().query(SQL_GET_ALL, BeanPropertyRowMapper.newInstance(AccountBalance.class));
    }

    @Override
    public AccountBalance getById(String id) {
        return this.getJdbcTemplate().queryForObject(SQL_BY_ID, BeanPropertyRowMapper.newInstance(AccountBalance.class),id);
    }

    @Override
    public int Deposit(String id, BigDecimal amount) {
        return this.getJdbcTemplate().update(SQL_DEPOSIT,amount,id);
    }

    @Override
    public int Withdraw(String id, BigDecimal amount) {
        return this.getJdbcTemplate().update(SQL_WITHDRAW,amount,id);
    }


}
