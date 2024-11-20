package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDto;
import umc.spring.web.dto.StoreResponseDto;

import java.time.LocalDateTime;

public class StoreConverter {


    public static StoreResponseDto.addResultDTO addResultDTO(Store store) {
        return StoreResponseDto.addResultDTO.builder()
                .storeId(store.getId())
                .name(store.getName())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static Store toStore (StoreRequestDto.addStoreDto requestDto) {

        return Store.builder()
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .build();

    }
}
