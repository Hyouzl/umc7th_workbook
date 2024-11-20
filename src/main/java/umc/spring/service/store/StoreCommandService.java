package umc.spring.service.store;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDto;

public interface StoreCommandService {

    Store addStore(StoreRequestDto.addStoreDto request);
}
