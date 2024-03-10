package co.com.flypass.f2xfinancialentity.service;

import co.com.flypass.f2xfinancialentity.exception.MandatoryValueException;
import co.com.flypass.f2xfinancialentity.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>j2x-financial-entity</b> 09/03/2024, 7:07 PM
 **/
@Service
@RequiredArgsConstructor
public class ValidateProductsService {

    private final ProductRepository productRepository;
    public boolean existProductsByClientId(String clientId){
        if(null == clientId){
            throw new MandatoryValueException("Id de cliente requerido");
        }
        return productRepository.existsByClientId(clientId);
    }
}
