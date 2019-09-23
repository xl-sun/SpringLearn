package my.sxl.l_transaction.service;

import my.sxl.k_jdbctemplate.pojo.Account;
import my.sxl.k_jdbctemplate.pojo.AccountBalance;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    //转帐:转出者\转入者\金额
    void transfer(Account payer, Account payee, BigDecimal amount);
    void transferById(String payerId, String payeeId, BigDecimal amount);
    AccountBalance queryAccountBalanceById(String id);
    BigDecimal queryBalanceByAccount(Account account);
    List<AccountBalance> queryAll();
}
