package com.jsggun.api.nonCcld.model;


import com.jsggun.api.account.model.Account;
import com.jsggun.api.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "non_cclds")
@Builder
@AllArgsConstructor
public class NonCcld extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "non_ccld_id")
    private Long id;
    private Long ccldPrvs;
    private Long volume;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


}
