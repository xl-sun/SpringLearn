package my.sxl.l_transaction.service;

import my.sxl.k_jdbctemplate.dao.AccountBalanceDAO;
import my.sxl.k_jdbctemplate.pojo.Account;
import my.sxl.k_jdbctemplate.pojo.AccountBalance;
import org.springframework.aop.framework.AopContext;

import java.math.BigDecimal;
import java.util.List;

public abstract class AbstractAccountServiceImpl implements AccountService {
    protected AccountBalanceDAO accountBalanceDAO;

    public void setAccountBalanceDAO(AccountBalanceDAO accountBalanceDAO) {
        this.accountBalanceDAO = accountBalanceDAO;
    }

    @Override
    public AccountBalance queryAccountBalanceById(String id) {
        return accountBalanceDAO.getById(id);
    }

    @Override
    public BigDecimal queryBalanceByAccount(Account account) {
        return accountBalanceDAO.getById(account.getId()).getBalance();
    }

    @Override
    public List<AccountBalance> queryAll() {
        return accountBalanceDAO.getAll();
    }

    @Override
    public void transfer(Account payer, Account payee, BigDecimal amount) {
        transferById(payer.getId(),payee.getId(),amount);
        //调用代理增强后的方法：
        //((AccountService)AopContext.currentProxy()).transferById(payer.getId(),payee.getId(),amount);
    }
}
