package com.api.pagantis.model.dto;

import com.api.pagantis.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class WalletDTO {
    private Long id;
    private Integer pagacoint;
    private User user;
}
