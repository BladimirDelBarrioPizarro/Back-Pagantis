package com.api.pagantis.test.dummy;

import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.model.entity.Wallet;
import com.api.pagantis.model.models.Transaction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WalletServiceDummy {


    public static List<WalletDTO> walletListDummy() {
        return Collections.singletonList(walletDTODummy());
    }

    public static WalletDTO walletDTODummy() {
        return WalletDTO.builder()
                .id(1L)
                .bank("Test Bank")
                .pagacoint(1000)
                .build();
    }

    public static Wallet walletDummy() {
        return Wallet.builder()
                .id(1L)
                .bank("Test Bank")
                .pagacoint(1000)
                .build();
    }

    public static Transaction transactionDummy(){
        return Transaction.builder()
                .idRecep(1L)
                .idTrans(2L)
                .pagacoint(1000L)
                .build();
    }
}
