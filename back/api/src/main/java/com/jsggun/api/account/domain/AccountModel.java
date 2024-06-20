package com.jsggun.api.account.domain;

import com.jsggun.api.common.model.BaseEntity;
import com.jsggun.api.user.domain.UserModel;
import jakarta.persistence.*;
//import com.jsggun.api.trade.model.Trade;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "accounts")
@Builder
@AllArgsConstructor
@Setter
public class AccountModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String acno;
    private String acpw;
    private Long balance;
    private String refundAcno;
    private String bank;
    private String acType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

//    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Trade> trades;




}

