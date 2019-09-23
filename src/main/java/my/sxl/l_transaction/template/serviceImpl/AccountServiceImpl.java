package my.sxl.l_transaction.template.serviceImpl;

import my.sxl.k_jdbctemplate.pojo.Account;
import my.sxl.l_transaction.service.AbstractAccountServiceImpl;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

public class AccountServiceImpl extends AbstractAccountServiceImpl {

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    //当payerID=payeeID存在只减不加的问题！！！ = =后来再运行却没再发生
    public void transfer(final Account payer, final Account payee, final BigDecimal amount) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                System.out.println("Before Withdraw");
                //先扣款
                accountBalanceDAO.Withdraw(payer.getId(),amount);
                //制造可能的异常 payer.getClass(); 参数getId()方法会触发此异常，不用再写了
                System.out.println("After Withdraw");
                //后存款
                accountBalanceDAO.Deposit(payee.getId(),amount.add(BigDecimal.valueOf(0)));
                System.out.println("After Deposit");
                //制造可能的异常
                //payee.getClass();
            }
        });
    }

    @Override
    public void transferById(String payerId, String payeeId, BigDecimal amount) {
        System.out.println("暂不实现transferById方法,请调用transfer");
    }


}
