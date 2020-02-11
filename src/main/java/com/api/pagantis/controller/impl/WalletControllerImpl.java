package com.api.pagantis.controller.impl;

import com.api.pagantis.controller.WalletController;
import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.Entity;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.core.WebHandler.linkTo;

@Slf4j
public class WalletControllerImpl implements WalletController {

    private WalletService walletService;
    private final EntityLinks entityLinks;


    public WalletControllerImpl(WalletService walletService, EntityLinks entityLinks) {
        this.walletService = walletService;
        this.entityLinks = entityLinks;
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
        URI uri = URI.create("/api/v1/wallets");
        Link link = new Link(uri.getPath());
        walletService.transaction(idTrans,idRecep,pagacoint);
        link.withTitle("Operation TRUE");
        return new ResponseEntity(link, HttpStatus.OK);
    }


}
