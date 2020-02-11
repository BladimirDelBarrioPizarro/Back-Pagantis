package com.api.pagantis.controller.impl;

import com.api.pagantis.controller.WalletController;
import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
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
        log.info(" -- GET /wallets/{}", userId);
        return new ResponseEntity<>(walletService.findWalletsByUserId(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<WalletDTO>> findWalletsByUserName(String name) {
        log.info(" -- GET /wallets/{}", name);
        return new ResponseEntity<>(walletService.findWalletsByUserName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Link> transaction(Long idTrans, Long idRecep, Long pagacoint) {
        log.info(" -- POST /wallets Init transaction with {} pagacoint", pagacoint);
        EntityModel<Boolean> response = new EntityModel<>(walletService.transaction(idTrans,idRecep,pagacoint));
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
