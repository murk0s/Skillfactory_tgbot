package ru.skillfactorydemo.tgbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactorydemo.tgbot.repository.StatsRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StatService {
    private final StatsRepository statsRepository;

    public int getCountIncomesThatGreater(BigDecimal amount){
        return statsRepository.getCountIncomesThatGreaterThan(amount);
    }

    public int getCountSpendsThatGreater(BigDecimal amount){
        return statsRepository.getCountSpendsThatGreaterThan(amount);
    }
}
