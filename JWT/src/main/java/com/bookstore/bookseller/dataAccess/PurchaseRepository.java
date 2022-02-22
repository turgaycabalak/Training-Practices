package com.bookstore.bookseller.dataAccess;

import com.bookstore.bookseller.dataAccess.projection.PurchaseItem;
import com.bookstore.bookseller.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

    @Query("select b.title as title, ph.price as price, ph.purchaseTime as purchase_time " +
            "from Purchase ph left join Book b on b.id=ph.book.id " +
            "where ph.user.id = :userId")
    List<PurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);

}
