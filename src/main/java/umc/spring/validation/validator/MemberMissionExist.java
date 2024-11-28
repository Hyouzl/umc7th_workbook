package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.memberMission.MemberMissionQueryService;
import umc.spring.validation.annotation.ExistMemberMission;

@Component
@RequiredArgsConstructor
public class MemberMissionExist implements ConstraintValidator<ExistMemberMission, Long> {

    private final MemberMissionQueryService memberMissionService;
    @Override
    public void initialize(ExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        if(value == null) {
            return false;
        }

        System.out.println(value);
        boolean isValid = memberMissionService.findMemberMission(value).isPresent();

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_NOT_EXIST.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
