package my.sxl.k_jdbctemplate.pojo;

import java.math.BigDecimal;

public class AccountBalance {
    private String id;
    private BigDecimal balance;

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }
}
