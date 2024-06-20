package com.jsggun.api.ownStock.model;


import com.jsggun.api.account.model.Account;
import com.jsggun.api.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "own_stocks")
@Builder
@AllArgsConstructor
public class OwnStock extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "own_stock_id")
    private Long id;

    private String pdno;
    private String prdtName;
    private Long pdQty;
    private Long avgPrvs;
    private String tradeType;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


}
