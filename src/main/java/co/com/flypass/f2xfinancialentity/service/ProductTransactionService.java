package co.com.flypass.f2xfinancialentity.service;

import co.com.flypass.f2xfinancialentity.model.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>j2x-financial-entity</b> 10/03/2024, 2:08 PM
 **/
public interface ProductTransactionService {
    @Transactional
    ProductDTO consignment(ProductDTO destinationProduct, double amount);

    ProductDTO withdrawal(ProductDTO sourceProduct, double amount);
}
