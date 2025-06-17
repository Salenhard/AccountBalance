package vlad.gurbatov.AccountBalance.enitty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;



@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    private Integer id;
    
    private TransactionType type;

    private Currency currency;

    private BigDecimal amount;

    private Instant timestamp;
    @ManyToOne
    private Account account;
}
