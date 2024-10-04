package com.mkm.erp.config;

import com.mkm.erp.domain.common.annotation.Auth;
import com.mkm.erp.domain.common.dto.AuthUser;
import com.mkm.erp.domain.user.entity.UserRole;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AuthUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasAuthAnnotation = parameter.getParameterAnnotation(Auth.class) != null;
        boolean isAuthUserType = parameter.getParameterType().equals(AuthUser.class);

        // @Auth 어노테이션과 AuthUser 타입이 함께 사용되지 않은 경우 예외 발생
        if (hasAuthAnnotation != isAuthUserType) {
            try {
                throw new AuthException("@Auth와 AuthUser 타입은 함께 사용되어야 합니다.");
            } catch (AuthException e) {
                throw new RuntimeException(e);
            }
        }

        return hasAuthAnnotation;
    }

    @Override
    public Object resolveArgument(
            @Nullable MethodParameter parameter,
            @Nullable ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            @Nullable WebDataBinderFactory binderFactory
    ) {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        // JwtFilter 에서 set 한 userId, email, userRole 값을 가져옴
        Long userId = (Long) request.getAttribute("userId");
        String email = (String) request.getAttribute("email");
        String name = (String) request.getAttribute("name");
        UserRole userRole = UserRole.of((String) request.getAttribute("userRole"));

        return new AuthUser(userId, email, name, userRole);
    }
}
