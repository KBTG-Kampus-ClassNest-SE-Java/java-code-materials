package com.example.javacourse.wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Modifying
//    @Transactional
    @Query("UPDATE Wallet w SET w.active = true")
    void setAllWalletsActive();

    @Modifying
//    @Transactional
    @Query("DELETE FROM Wallet w WHERE w.id < 3")
    void deleteWalletsByIdBelow3();
}