package com.jsggun.api.accHistory.domain;

import com.jsggun.api.account.domain.AccountModel;
import com.jsggun.api.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "acc_histories")
@Builder
@AllArgsConstructor
public class AccHistoryModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long balance;
    private String tradeType;
    private String bank;
    private String imp_uid;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountModel accountModel;




}
