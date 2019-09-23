package my.sxl.l_transaction.aop.serviceImpl;

import my.sxl.l_transaction.service.AbstractAccountServiceImpl;

import java.math.BigDecimal;

public class AccountServiceImpl extends AbstractAccountServiceImpl {

    @Override
    public void transferById(String payerId, String payeeId, BigDecimal amount) {
        //先扣款
        accountBalanceDAO.Withdraw(payerId,amount);
        System.out.println("After Withdraw");
        //制造异常
        if (null==payeeId){
            int i = 2333/0;
        }
        //后存款
        accountBalanceDAO.Deposit(payeeId,amount);
    }
}
