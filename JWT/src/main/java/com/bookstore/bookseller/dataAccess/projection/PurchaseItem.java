package com.bookstore.bookseller.dataAccess.projection;

import java.time.LocalDateTime;

public interface PurchaseItem { // Projection

    String getTitle();
    Double getPrice();
    LocalDateTime getPurchaseTime();

}
