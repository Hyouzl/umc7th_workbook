package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionDto;
import umc.spring.repository.mission.MissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;
    @Override
    public List<MissionDto> findMissionInHome(Long memberId, String regionName, int cursor) {

        List<MissionDto> filteredMissionsInHome = missionRepository.findMissionInHome(memberId, regionName, cursor);

        filteredMissionsInHome.forEach(missionDto ->
                System.out.println("missionDto: " + missionDto));

        return null;
    }

    @Override
    public Optional<Mission> findMission(Long missionId) {
        return missionRepository.findById(missionId);
    }


}
