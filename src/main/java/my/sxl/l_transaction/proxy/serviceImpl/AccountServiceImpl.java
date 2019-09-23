package my.sxl.l_transaction.proxy.serviceImpl;

import my.sxl.k_jdbctemplate.pojo.Account;
import my.sxl.l_transaction.service.AbstractAccountServiceImpl;
import my.sxl.l_transaction.service.AccountService;

import java.math.BigDecimal;

public class AccountServiceImpl extends AbstractAccountServiceImpl {

    @Override
    public void transfer(Account payer, Account payee, BigDecimal amount) {
        //先扣款
        System.out.println("Before Withdraw");
        accountBalanceDAO.Withdraw(payer.getId(),amount);
        System.out.println("After Withdraw");
        //后存款
        accountBalanceDAO.Deposit(payee.getId(),amount);
    }

    @Override
    public void transferById(String payerId, String payeeId, BigDecimal amount) {
        //先扣款
        System.out.println("Before Withdraw");
        accountBalanceDAO.Withdraw(payerId,amount);
        System.out.println("After Withdraw");
        //后存款
        accountBalanceDAO.Deposit(payeeId,amount);
    }
}
