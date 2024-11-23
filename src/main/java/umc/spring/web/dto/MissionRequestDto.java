package umc.spring.web.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDto {


    @Getter
    public static class addMissionDto {

        @NotNull
        Long storeId;

        @NotNull
        String missionSpec;

        @NotNull
        int reward;

        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime deadline;

    }



}
