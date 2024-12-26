package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.web.bind.annotation.PathVariable;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistStore;

public class StoreRequestDto {


    @Getter
    public static class addStoreDto {
        @NotBlank
        private String name;
        @Size(min = 5, max = 12)
        private String address;
        @NotNull
        private Long region;
    }

    @Getter
    public static class reviewRequest {

        @ExistStore
        Long storeId;

        @CheckPage
        Integer page;
    }

    @Getter
    public static class addReviewDto {

        @NotNull
        Long memberId;

        @NotNull
        Long storeId;

        @NotNull
        String body;

        @NotNull
        float score;


    }



}
