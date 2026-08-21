package com.utraxxer.core.habits.application.usecase;

import com.utraxxer.core.habits.domain.model.Intervale;
import com.utraxxer.core.habits.domain.port.IntervaleRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetIntervaleUseCase {
    private final IntervaleRepositoryPort intervaleRepositoryPort;

    @Transactional(readOnly = true)
    public List<Intervale> execute() { return intervaleRepositoryPort.findAll(); }

}
