package ru.skillfactorydemo.tgbot.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.Income;

import java.util.List;

@DataJpaTest
public class IncomeRepositoryTest {
    @Autowired
    private IncomeRepository incomeRepository;

    @Test
    public void TestRepo() {
//        //for (int i=0; i<10; i++, incomeRepository.save(new Income()));
        final List<Income> found = incomeRepository.findAll();
        Assert.assertEquals(1, found.size());

    }
}
