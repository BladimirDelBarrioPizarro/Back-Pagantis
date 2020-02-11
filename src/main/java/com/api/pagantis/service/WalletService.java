package com.api.pagantis.service;

import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.model.entity.Wallet;
import com.api.pagantis.model.models.Transaction;

import java.util.List;

public interface WalletService {
    List<WalletDTO> findWalletsByUserId(Long userId);
    List<WalletDTO> findWalletsByUserName(String name);
    Boolean transaction(Transaction transaction);
}
