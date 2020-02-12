package com.api.pagantis.test;

import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.model.entity.Wallet;
import com.api.pagantis.model.models.Transaction;
import com.api.pagantis.service.WalletService;
import com.api.pagantis.test.dummy.WalletServiceDummy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WalletServiceTestImpl {

    private WalletService walletService = mock(WalletService.class);

    @Test
    void walletsByNameTest(){
        List<WalletDTO> walletList = WalletServiceDummy.walletListDummy();
        when(walletService.findWalletsByUserName(any())).thenReturn(walletList);
        List<WalletDTO> walletList2 = walletService.findWalletsByUserName("Test name");
        assert (walletList2.size() > 0);
    }

    @Test
    void walletsByIdTest(){
        List<WalletDTO> walletList = WalletServiceDummy.walletListDummy();
        when(walletService.findWalletsByUserId(any())).thenReturn(walletList);
        List<WalletDTO> walletList2 = walletService.findWalletsByUserId(1L);
        assert (walletList2.size() > 0);
    }

    @Test
    void transactionTest(){
        Transaction transaction = WalletServiceDummy.transactionDummy();
        when(walletService.transaction(any())).thenReturn(true);
        Boolean check = walletService.transaction(transaction);
        assert (check);
    }

}
