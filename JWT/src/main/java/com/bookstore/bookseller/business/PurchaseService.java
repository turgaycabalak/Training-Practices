package com.bookstore.bookseller.business;

import com.bookstore.bookseller.dataAccess.PurchaseRepository;
import com.bookstore.bookseller.dataAccess.projection.PurchaseItem;
import com.bookstore.bookseller.entity.Purchase;
import com.bookstore.bookseller.entity.dto.PurchaseDtoConverter;
import com.bookstore.bookseller.entity.dto.PurchaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseDtoConverter converter;


    public Purchase savePurchase(PurchaseRequest purchaseRequest){


        return purchaseRepository.save(converter.PurchaseRequestToPurchase(purchaseRequest));
    }

    public List<PurchaseItem> findAllPurchasesOfUser(Long userId){
        return purchaseRepository.findAllPurchasesOfUser(userId);
    }

}
