package umc.spring.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDto;
import umc.spring.repository.store.RegionRepository;
import umc.spring.repository.store.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    // 특정 지역에 가게 추가
    @Override
    public Store addStore(StoreRequestDto.addStoreDto request) {


        Store store = StoreConverter.toStore(request);
        Region region = regionRepository.findById(request.getRegion()).orElseThrow(() ->
                new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        store.setRegion(region);

        return storeRepository.save(store);
    }
}
