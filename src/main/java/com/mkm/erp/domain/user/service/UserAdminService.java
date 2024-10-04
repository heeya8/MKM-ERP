package com.mkm.erp.domain.user.service;

import com.mkm.erp.domain.common.exception.InvalidRequestException;
import com.mkm.erp.domain.user.dto.request.UserRoleChangeRequest;
import com.mkm.erp.domain.user.entity.User;
import com.mkm.erp.domain.user.entity.UserRole;
import com.mkm.erp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserAdminService {

    private final UserRepository userRepository;

    @Transactional
    public void changeUserRole(long userId, UserRoleChangeRequest userRoleChangeRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new InvalidRequestException("User not found"));
        user.updateRole(UserRole.of(userRoleChangeRequest.getRole()));
    }
}
