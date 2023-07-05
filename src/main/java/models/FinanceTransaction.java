package models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "finance_transaction")
@Data
@NoArgsConstructor
public class FinanceTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private Status status;

    private double sum;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    private boolean isDone;

    @Type(type = "text")
//    @Column(length = 65535)
    private String paymentTxt;

    public FinanceTransaction(TransactionType transactionType, Status status, double sum, boolean isDone, String paymentTxt) {
        this.transactionType = transactionType;
        this.status = status;
        this.sum = sum;
        this.isDone = isDone;
        this.paymentTxt = paymentTxt;
    }
}
