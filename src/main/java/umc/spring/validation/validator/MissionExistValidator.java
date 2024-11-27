package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.mission.MissionQueryService;
import umc.spring.validation.annotation.ExistMissions;


@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMissions, Long> {

    private final MissionQueryService missionQueryService;

    @Override
    public void initialize(ExistMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        boolean isValid = missionQueryService.findMission(value).isPresent();

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_NOT_EXIST.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
