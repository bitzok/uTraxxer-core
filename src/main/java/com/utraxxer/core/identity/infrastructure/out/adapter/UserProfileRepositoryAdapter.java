package com.utraxxer.core.identity.infrastructure.out.adapter;

import com.utraxxer.core.identity.domain.model.UserProfile;
import com.utraxxer.core.identity.domain.port.UserProfileRepositoryPort;
import com.utraxxer.core.identity.infrastructure.out.entity.UserAuthEntity;
import com.utraxxer.core.identity.infrastructure.out.entity.UserProfileEntity;
import com.utraxxer.core.identity.infrastructure.out.repository.UserAuthRepository;
import com.utraxxer.core.identity.infrastructure.out.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileRepositoryAdapter implements UserProfileRepositoryPort {

    private final UserProfileRepository profileRepository;
    private final UserAuthRepository authRepository;

    @Override
    public void save(UserProfile userProfile) {
        UserAuthEntity authEntity = authRepository.findByEmail(userProfile.getUserAuth().getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado para vincular el perfil"));

        UserProfileEntity profileEntity = new UserProfileEntity();
        profileEntity.setName(userProfile.getName());
        profileEntity.setLastname(userProfile.getLastname());

        profileEntity.setUserAuthEntity(authEntity);
        profileRepository.save(profileEntity);
    }
}