package ru.skillfactorydemo.tgbot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.skillfactorydemo.tgbot.repository.SpendRepository;
import ru.skillfactorydemo.tgbot.repository.StatsRepository;

import java.math.BigDecimal;

@SpringBootTest
//@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class StatServiceTest {

    @InjectMocks
    @Autowired
    private StatService statService;

    @Mock
    private StatsRepository statsRepository;

    @DisplayName("COUNT_SPENDS_THAT_GREATER_test")
    @Test
    public void getCountSpendsThatGreaterTest(){
        int result = statService.getCountSpendsThatGreater(BigDecimal.valueOf(1120));
        Assertions.assertEquals(2, result);
        result = statService.getCountSpendsThatGreater(BigDecimal.valueOf(1500));
        Assertions.assertEquals(1, result);
        result = statService.getCountSpendsThatGreater(BigDecimal.valueOf(15000));
        Assertions.assertEquals(0, result);
        result = statService.getCountSpendsThatGreater(BigDecimal.valueOf(10));
        Assertions.assertEquals(3, result);
    }

    @DisplayName("COUNT_INCOMES_THAT_GREATER_test")
    @Test
    public void getCountIncomesThatGreaterTest(){
        int result = statService.getCountIncomesThatGreater(BigDecimal.valueOf(320));
        Assertions.assertEquals(2, result);
        result = statService.getCountIncomesThatGreater(BigDecimal.valueOf(2500));
        Assertions.assertEquals(1, result);
        result = statService.getCountIncomesThatGreater(BigDecimal.valueOf(10000));
        Assertions.assertEquals(0, result);
    }
}
