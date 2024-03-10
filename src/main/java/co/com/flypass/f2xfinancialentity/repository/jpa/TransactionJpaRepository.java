package co.com.flypass.f2xfinancialentity.repository.jpa;

import co.com.flypass.f2xfinancialentity.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>j2x-financial-entity</b> 10/03/2024, 1:36 PM
 **/
@Repository
public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, String> {
}
