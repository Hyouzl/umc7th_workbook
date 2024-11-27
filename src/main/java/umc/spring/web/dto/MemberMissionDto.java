package umc.spring.web.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.validation.annotation.AlreadyExistMemberMissions;
import umc.spring.validation.annotation.ExistMissions;

@Data
public class MemberMissionDto {

    private Long id;
    private String missionSpec;
    private Integer reward;
    private MissionStatus missionStatus;
    private String storeName;
    private float storeScore;

    // Constructor
    @QueryProjection
    public MemberMissionDto(Long id, String missionSpec, Integer reward, MissionStatus missionStatus, String storeName, float storeScore) {
        this.id = id;
        this.missionSpec = missionSpec;
        this.reward = reward;
        this.missionStatus = missionStatus;
        this.storeName = storeName;
        this.storeScore = storeScore;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class resultAddMemberMission {
        Long memberMissionId;
        Long missionId;
        Long memberId;

    }


    @Getter
    public static class addMemberMissionDto {

        @ExistMissions
        @AlreadyExistMemberMissions
        Long missionId;
    }



    @Override
    public String toString() {
        return "MemberMissionDto{" +
                "id=" + id +
                ", missionSpec='" + missionSpec + '\'' +
                ", reward=" + reward +
                ", missionStatus=" + missionStatus +
                ", storeName='" + storeName + '\'' +
                ", storeScore=" + storeScore +
                '}';
    }
}
