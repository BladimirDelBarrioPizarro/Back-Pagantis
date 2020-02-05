package com.api.pagantis.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "wallets")
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pagacoint")
    private String pagacoint;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "wallet_user",
            joinColumns = @JoinColumn(name="wallet_id"),inverseJoinColumns = @JoinColumn(name="user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"wallet_id","user_id"})})
    private User user;
}

/*
*  id character varying(100) NOT NULL,
    pagacoint integer not null,
    user_id integer not null
*
*
* */
