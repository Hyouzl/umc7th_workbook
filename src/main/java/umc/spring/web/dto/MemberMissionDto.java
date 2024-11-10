package umc.spring.web.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import umc.spring.domain.enums.MissionStatus;

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
