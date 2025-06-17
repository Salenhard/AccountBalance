package vlad.gurbatov.AccountBalance.enitty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    private Integer id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "account")
    private Set<Transaction> transactionList;

    public BigDecimal getBalance() {
        BigDecimal usd = BigDecimal.valueOf(1);
        BigDecimal[] arr = new BigDecimal[]{
                BigDecimal.valueOf(1), BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)
        };
        return transactionList.stream()
                .map(x -> x.getAmount().multiply(usd.divide(arr[x.getCurrency().ordinal()])))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
