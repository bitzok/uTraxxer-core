package com.utraxxer.core.identity.domain.port;

import com.utraxxer.core.identity.domain.model.UserProfile;

public interface UserProfileRepositoryPort {
    UserProfile save(UserProfile userProfile);
}
