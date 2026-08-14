package com.utraxxer.core.identity.infrastructure.out.adapter;

import com.utraxxer.core.identity.domain.model.UserAuth;
import com.utraxxer.core.identity.domain.model.UserState;
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
            UserAuth domainUser = UserAuth.restoreFromRepository(
                    entity.getId(),
                    entity.getEmail(),
                    entity.getUsername(),
                    entity.getPassword(),
                    UserState.valueOf(entity.getState().toUpperCase()),
                    entity.getCreatedAt()
            );

            return domainUser;
        });
    }

    @Override
    public UserAuth save(UserAuth user) {
        UserAuthEntity entity = new UserAuthEntity();
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setState(user.getState().name());
        entity.setCreatedAt(user.getCreatedAt());

        UserAuthEntity saved = springRepository.save(entity);

        return UserAuth.restoreFromRepository(
                saved.getId(),
                saved.getEmail(),
                saved.getUsername(),
                saved.getPassword(),
                UserState.valueOf(saved.getState().toUpperCase()),
                saved.getCreatedAt()
        );
    }
}
