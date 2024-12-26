package umc.spring.web.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.Member;
import umc.spring.domain.Store;

public class ReviewRequestDto {

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
