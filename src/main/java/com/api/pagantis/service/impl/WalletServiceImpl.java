package com.api.pagantis.service.impl;

import com.api.pagantis.dao.WalletDao;
import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.model.entity.Wallet;
import com.api.pagantis.model.exceptions.HandleExceptionTransaction;
import com.api.pagantis.model.exceptions.HandleExceptionWalletsByUserId;
import com.api.pagantis.model.mapper.WalletMapper;
import com.api.pagantis.model.models.Transaction;
import com.api.pagantis.service.WalletService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class WalletServiceImpl implements WalletService {

    private WalletDao walletDao;

    public WalletServiceImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }


    @Override
    public List<WalletDTO> findWalletsByUserId(Long userId) {
        try{
            List<Wallet> walletList =  walletDao.findAll().stream().filter(wallet -> wallet.getUser().getId().equals(userId)).collect(Collectors.toList());
            return WalletMapper.mapWalletListToWalletDTOList(walletList);
        }catch (Exception ex){
            log.error(" -- PAGANTIS INFO: WALLETS ERROR {}",ex.getMessage());
            throw new HandleExceptionWalletsByUserId(ex);
        }


    }

    @Override
    public List<WalletDTO> findWalletsByUserName(String name) {
        try{

        }catch (Exception ex){
            log.error(" -- PAGANTIS INFO: WALLETS ERROR {}",ex.getMessage());
        }
        List<Wallet> walletList = walletDao.findAll().stream().filter(wallet -> wallet.getUser().getName().equals(name)).collect(Collectors.toList());
        return WalletMapper.mapWalletListToWalletDTOList(walletList) ;
    }

    @Override
    public Boolean transaction(Transaction transaction) {
        try{
            Optional<Wallet> walletR = walletDao.findById(transaction.getIdRecep());
            Integer pagacointR = walletR.get().getPagacoint();
            Integer totalR = Math.toIntExact(pagacointR + transaction.getPagacoint());
            walletR.get().setPagacoint(totalR);
            walletDao.save(walletR.get());

            Optional<Wallet> walletT = walletDao.findById(transaction.getIdTrans());
            Integer pagacointT = walletT.get().getPagacoint();
            Integer totalT = Math.toIntExact(pagacointT - transaction.getPagacoint());
            walletT.get().setPagacoint(totalT);
            walletDao.save(walletT.get());
            return true;
        }catch (Exception ex){
            log.error(" -- PAGANTIS INFO: TRANSACTION ERROR {}",ex.getMessage());
            throw new HandleExceptionTransaction(ex);
        }
    }
}
