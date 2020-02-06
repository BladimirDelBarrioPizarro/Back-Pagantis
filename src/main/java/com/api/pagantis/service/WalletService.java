package com.api.pagantis.service;

import com.api.pagantis.model.dto.WalletDTO;
import java.util.List;

public interface WalletService {
    List<WalletDTO> findWalletsByUserId(Long userId);
}
