package my.sxl.l_transaction.anno.serviceImpl;

import my.sxl.k_jdbctemplate.dao.AccountBalanceDAO;
import my.sxl.k_jdbctemplate.pojo.Account;
import my.sxl.l_transaction.service.AbstractAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service("accountService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly=false,transactionManager = "txManager")
public class AccountServiceImpl extends AbstractAccountServiceImpl {

    @Override
    //@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly=false,transactionManager = "txManager")
    public void transferById(String payerId, String payeeId, BigDecimal amount) {
        //先扣款
        accountBalanceDAO.Withdraw(payerId,amount);
        System.out.println("After Withdraw");
        //制造异常
        payeeId.getClass();
        //后存款
        accountBalanceDAO.Deposit(payeeId,amount);
    }

    @Override
    @Autowired
    @Transactional(propagation = Propagation.NOT_SUPPORTED) //这个方法好像没什么效果
    public void setAccountBalanceDAO(AccountBalanceDAO accountBalanceDAO) {
        super.setAccountBalanceDAO(accountBalanceDAO);
    }

    @Override
    public void transfer(Account payer, Account payee, BigDecimal amount) {
        super.transfer(payer, payee, amount);
    }
}
