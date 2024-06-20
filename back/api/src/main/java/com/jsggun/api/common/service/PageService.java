package com.jsggun.api.common.service;

import com.jsggun.api.common.model.PageDTO;
import org.springframework.stereotype.Component;

@Component
public interface PageService {
    PageDTO getPageDTO(int toTalPageSize, int pageNo);

}
