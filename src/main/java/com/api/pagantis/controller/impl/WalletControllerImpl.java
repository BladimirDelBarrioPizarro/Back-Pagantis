package com.api.pagantis.controller.impl;

import com.api.pagantis.controller.WalletController;
import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class WalletControllerImpl implements WalletController {

    private WalletService walletService;

    public WalletControllerImpl(WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
    public ResponseEntity<List<WalletDTO>> findWalletsByUserId(Long userId) {
        return new ResponseEntity<>(walletService.findWalletsByUserId(userId), HttpStatus.OK);
    }
}
