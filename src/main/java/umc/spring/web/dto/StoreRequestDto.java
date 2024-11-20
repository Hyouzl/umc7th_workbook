package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

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



}
