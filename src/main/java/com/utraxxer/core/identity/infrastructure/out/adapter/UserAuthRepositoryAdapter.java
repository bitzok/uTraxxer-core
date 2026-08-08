package com.utraxxer.core.identity.infrastructure.out.adapter;

import com.utraxxer.core.identity.domain.model.UserAuth;
import com.utraxxer.core.identity.domain.port.UserAuthRepositoryPort;
import com.utraxxer.core.identity.infrastructure.out.entity.UserAuthEntity;
import com.utraxxer.core.identity.infrastructure.out.repository.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserAuthRepositoryAdapter implements UserAuthRepositoryPort {
    private final UserAuthRepository springRepository;

    @Override
    public boolean existsByEmail(String email) {
        return springRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return springRepository.existsByUsername(username);
    }

    @Override
    public Optional<UserAuth> findByEmailOrUsername(String identifier){
        Optional<UserAuthEntity> userAuth = springRepository.findByEmailOrUsername(identifier, identifier);

        return userAuth.map(entity -> {
            UserAuth domainUser = new UserAuth();
            domainUser.setEmail(entity.getEmail());
            domainUser.setPassword(entity.getPassword());
            return domainUser;
        });
    }

    @Override
    public void save(UserAuth user) {
        UserAuthEntity entity = new UserAuthEntity();
        entity.setEmail(user.getEmail());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setState(user.getState());

        springRepository.save(entity);
    }
}
