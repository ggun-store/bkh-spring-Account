package com.jsggun.api.ownStock.domain;


import com.jsggun.api.account.domain.AccountModel;
import com.jsggun.api.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "own_stocks")
@Builder
@AllArgsConstructor
public class OwnStockModel extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pdno;
    private String prdtName;
    private Long pdQty;
    private Long avgPrvs;
    private String tradeType;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountModel accountModel;


}
