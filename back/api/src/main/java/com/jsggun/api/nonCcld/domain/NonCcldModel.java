package com.jsggun.api.nonCcld.domain;


import com.jsggun.api.account.domain.AccountModel;
import com.jsggun.api.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "non_cclds")
@Builder
@AllArgsConstructor
public class NonCcldModel extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ccldPrvs;
    private Long volume;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountModel accountModel;


}
