package com.api.pagantis.service.impl;

import com.api.pagantis.dao.WalletDao;
import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.model.entity.Wallet;
import com.api.pagantis.model.mapper.UserMapper;
import com.api.pagantis.model.mapper.WalletMapper;
import com.api.pagantis.service.WalletService;

import java.util.List;
import java.util.stream.Collectors;

public class WalletServiceImpl implements WalletService {

    private WalletDao walletDao;

    public WalletServiceImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }


    @Override
    public List<WalletDTO> findWalletsByUserId(Long userId) {
        List<Wallet> walletList =  walletDao.findAll().stream().filter(wallet -> wallet.getUser().getId().equals(userId)).collect(Collectors.toList());
        return WalletMapper.mapWalletListToWalletDTOList(walletList);
    }

    @Override
    public List<WalletDTO> findWalletsByUserName(String name) {
        List<Wallet> walletList = walletDao.findAll().stream().filter(wallet -> wallet.getUser().getName().equals(name)).collect(Collectors.toList());
        return WalletMapper.mapWalletListToWalletDTOList(walletList) ;
    }
}
