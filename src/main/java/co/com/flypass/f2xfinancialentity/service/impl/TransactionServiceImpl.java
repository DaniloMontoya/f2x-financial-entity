package co.com.flypass.f2xfinancialentity.service.impl;

import co.com.flypass.f2xfinancialentity.enums.TransactionType;
import co.com.flypass.f2xfinancialentity.exception.MandatoryValueException;
import co.com.flypass.f2xfinancialentity.exception.NotAllowedOperationException;
import co.com.flypass.f2xfinancialentity.mapper.TransactionMapper;
import co.com.flypass.f2xfinancialentity.model.builder.TransactionBuilder;
import co.com.flypass.f2xfinancialentity.model.dto.transaction.ConsignmentDTO;
import co.com.flypass.f2xfinancialentity.model.dto.transaction.TransactionDTO;
import co.com.flypass.f2xfinancialentity.model.dto.transaction.TransferAccountDTO;
import co.com.flypass.f2xfinancialentity.model.dto.transaction.WithdrawalDTO;
import co.com.flypass.f2xfinancialentity.repository.TransactionRepository;
import co.com.flypass.f2xfinancialentity.service.ProductService;
import co.com.flypass.f2xfinancialentity.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author Ing. Danilo Montoya Hernandez;
 * Email: danilo9831montoya@gmail.com
 * @version Id: <b>j2x-financial-entity</b> 10/03/2024, 12:41 PM
 **/
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    public static final String REQUIRED_FIELDS_MESSAGE = "Campos requeridos";
    public static final String TRANSACTION_AMOUNT_MUST_MAYOR_ZERO_MESSAGE = "El valor de la transacción debe se mayor de $0 (cero)";
    private final TransactionRepository transactionRepository;
    private final ProductService productService;
    private final TransactionMapper transactionMapper;

    @Transactional
    @Override
    public TransactionDTO consignment(ConsignmentDTO consignmentDTO) {
        if (null == consignmentDTO) {
            throw new MandatoryValueException(REQUIRED_FIELDS_MESSAGE);
        }
        validateTransactionAmount(consignmentDTO.getAmount());
        var destinationProduct = productService.findByAccountNumber(consignmentDTO.getDestinationAccount());
        var productDTO = productService.consignment(destinationProduct, consignmentDTO.getAmount());
        var transactionModel = new TransactionBuilder()
                .withType(TransactionType.CONSIGNMENT)
                .withDestinationAccount(productDTO.getAccountNumber())
                .withAmount(consignmentDTO.getAmount())
                .withTransactionDate(LocalDateTime.now())
                .build();
        return transactionMapper.modelToDTO(transactionRepository.save(transactionModel));
    }

    public void validateTransactionAmount(double amount) {
        if (amount < 1) {
            throw new NotAllowedOperationException(TRANSACTION_AMOUNT_MUST_MAYOR_ZERO_MESSAGE);
        }
    }

    @Override
    public TransactionDTO withdrawal(WithdrawalDTO withdrawalDTO) {
        return null;
    }

    @Override
    public TransactionDTO transferBetweenAccounts(TransferAccountDTO transferAccountDTO) {
        return null;
    }
}
