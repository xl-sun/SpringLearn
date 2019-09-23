package my.sxl.k_jdbctemplate.dao;

import my.sxl.k_jdbctemplate.pojo.Account;

import java.util.List;

public interface AccountDAO {
    void update(Account account);
    List<Account> getAll();
    Account getById(String id);
}
