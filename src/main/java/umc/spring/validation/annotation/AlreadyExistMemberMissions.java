package umc.spring.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MemberMissionAlreadyExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionAlreadyExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AlreadyExistMemberMissions {

    String message() default "이미 도전중/도전 진행 중인 미션입니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
