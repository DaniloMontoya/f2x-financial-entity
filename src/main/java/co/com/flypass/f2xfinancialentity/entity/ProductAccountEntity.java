package co.com.flypass.f2xfinancialentity.entity;

import co.com.flypass.f2xfinancialentity.enums.AccountStatus;
import co.com.flypass.f2xfinancialentity.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>j2x-financial-entity</b> 09/03/2024, 4:54 PM
 **/
@Data
@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
public class ProductAccountEntity {
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Column(unique = true)
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private double balance;
    private boolean excludeGMF;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
}
