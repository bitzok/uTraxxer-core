package com.utraxxer.core.habits.application.usecase;

import com.utraxxer.core.habits.domain.model.Icon;
import com.utraxxer.core.habits.domain.port.IconRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetIconUseCase {
    private final IconRepositoryPort iconRepositoryPort;

    @Transactional(readOnly = true)
    public List<Icon> execute() { return iconRepositoryPort.findAll(); }

}
