package com.api.pagantis.model.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Transaction {
    private Long idTrans;
    private Long idRecep;
    private Long pagacoint;
}
