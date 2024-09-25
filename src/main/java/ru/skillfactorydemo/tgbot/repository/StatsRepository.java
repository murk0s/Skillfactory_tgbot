package ru.skillfactorydemo.tgbot.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StatsRepository {
//    private final JdbcTemplate jdbcTemplate;
//
//    public int getCountIncomesThatGreaterThan(BigDecimal sum){
//        return jdbcTemplate.queryForObject("SELECT count(*) FROM incomes WHERE income > ?", Integer.class, sum);
//    }

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public int getCountIncomesThatGreaterThan(BigDecimal amount){

        Map<String, Object> parametrs = new HashMap<>();
        parametrs.put("amount", amount);
        return namedParameterJdbcTemplate.queryForObject("SELECT COUNT(*) AS COUNT FROM INCOMES WHERE INCOMES.income > :amount", parametrs, new StatsRowMapper());
    }

    private static final class StatsRowMapper implements RowMapper <Integer> {

        @Override
        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt("COUNT");
        }
    }

    public int getCountSpendsThatGreaterThan(BigDecimal amount){
        Map<String, Object> parametrs = new HashMap<>();
        parametrs.put("amount", amount);
        return namedParameterJdbcTemplate.queryForObject("SELECT COUNT(*) AS COUNT FROM SPEND WHERE SPEND.spend > :amount", parametrs, new StatsRowMapper());
    }

}
