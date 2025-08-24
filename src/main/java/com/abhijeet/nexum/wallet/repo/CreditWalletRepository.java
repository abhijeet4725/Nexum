package com.abhijeet.nexum.wallet.repo;

import com.abhijeet.nexum.wallet.domain.CreditWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreditWalletRepository extends JpaRepository<UUID, CreditWallet> {
}
