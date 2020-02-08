package com.api.pagantis.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "wallets")
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pagacoint")
    private Integer pagacoint;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "wallet_user",
            joinColumns = @JoinColumn(name="wallet_id"),inverseJoinColumns = @JoinColumn(name="user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"wallet_id","user_id"})})
    private User user;
}