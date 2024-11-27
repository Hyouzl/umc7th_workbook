package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDto;
import umc.spring.web.dto.StoreResponseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static StoreResponseDto.ReviewPreviewDto reviewPreViewDTO(Review review){

        return  StoreResponseDto.ReviewPreviewDto.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreResponseDto.ReviewPreviewListDto reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDto.ReviewPreviewDto>  reviewPreViewDTOList =
                reviewList.stream()
                        .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDto.ReviewPreviewListDto.builder()
                .reviewList(reviewPreViewDTOList)
                .listSize(reviewPreViewDTOList.size())
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .build();


    }


}
