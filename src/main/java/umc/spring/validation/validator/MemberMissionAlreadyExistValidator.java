package umc.spring.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.memberMission.MemberMissionService;
import umc.spring.validation.annotation.AlreadyExistMemberMissions;

@Component
@RequiredArgsConstructor
public class MemberMissionAlreadyExistValidator implements ConstraintValidator<AlreadyExistMemberMissions, Long> {

    private final MemberMissionService memberMissionService;
    @Override
    public void initialize(AlreadyExistMemberMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        if(value == null) {
            return true;
        }

        boolean isValid = memberMissionService.existMemberMission(value, 1L);

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_ALREADY_EXIST.toString()).addConstraintViolation();
            return false;
        }

        return !isValid;
    }
}
