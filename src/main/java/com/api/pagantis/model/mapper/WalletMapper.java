package com.api.pagantis.model.mapper;


import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.model.entity.Wallet;
import java.util.List;
import java.util.stream.Collectors;

public class WalletMapper {

    public static List<WalletDTO> mapWalletListToWalletDTOList(List<Wallet> walletList) {
        return walletList.stream().map(WalletMapper::mapWalletToWalletDTO).collect(Collectors.toList());
    }

    private static WalletDTO mapWalletToWalletDTO(Wallet wallet) {
        return WalletDTO.builder()
                .id(wallet.getId())
                .pagacoint(wallet.getPagacoint())
                .user(wallet.getUser())
                .build();
    }
}
