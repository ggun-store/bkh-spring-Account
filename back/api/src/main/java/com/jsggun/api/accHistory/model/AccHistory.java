package com.jsggun.api.accHistory.model;

import com.jsggun.api.account.model.Account;
import com.jsggun.api.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "acc_histories")
@Builder
@AllArgsConstructor
public class AccHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_history_id")
    private Long id;

    private Long balance;
    private String tradeType;
    private String bank;
    private String imp_uid;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;




}
