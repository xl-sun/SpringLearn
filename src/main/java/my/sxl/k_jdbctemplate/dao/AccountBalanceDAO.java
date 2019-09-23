package my.sxl.k_jdbctemplate.dao;

import my.sxl.k_jdbctemplate.pojo.AccountBalance;

import java.math.BigDecimal;
import java.util.List;

public interface AccountBalanceDAO {
    void update(AccountBalance accountBalance);
    List<AccountBalance> getAll();
    AccountBalance getById(String id);
    int Deposit (String id,BigDecimal amount);
    int Withdraw (String id,BigDecimal amount);
}
