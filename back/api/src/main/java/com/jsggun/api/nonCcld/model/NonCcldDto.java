package com.jsggun.api.nonCcld.model;

import com.jsggun.api.account.model.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j2
public class NonCcldDto {


    private Long id;
    private Long ccldPrvs;
    private Long volume;

    private Long account;
}
