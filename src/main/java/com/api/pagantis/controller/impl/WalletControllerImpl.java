package com.api.pagantis.controller.impl;

import com.api.pagantis.controller.WalletController;
import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
public class WalletControllerImpl implements WalletController {

    private WalletService walletService;

    public WalletControllerImpl(WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
    public ResponseEntity<List<WalletDTO>> findWalletsByUserId(Long userId) {
        log.info(" -- GET /wallets/{}",userId);
        return new ResponseEntity<>(walletService.findWalletsByUserId(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<WalletDTO>> findWalletsByUserNamw(String name) {
        log.info(" -- GET /wallets/{}",name);
        return new ResponseEntity<>(walletService.findWalletsByUserName(name), HttpStatus.OK);
    }
}
