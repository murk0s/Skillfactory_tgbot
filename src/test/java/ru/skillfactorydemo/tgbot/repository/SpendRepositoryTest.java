package ru.skillfactorydemo.tgbot.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.Income;
import ru.skillfactorydemo.tgbot.entity.Spend;

import java.util.List;

@DataJpaTest
public class SpendRepositoryTest {
    @Autowired
    private SpendRepository spendRepository;

    @Test
    public void TestRepo() {
        final List<Spend> found = spendRepository.findAll();
        Assert.assertEquals(3, found.size());
    }
}
