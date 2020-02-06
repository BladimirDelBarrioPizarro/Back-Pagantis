package com.api.pagantis.dao;

import com.api.pagantis.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletDao extends JpaRepository<Wallet,Long> {

}
