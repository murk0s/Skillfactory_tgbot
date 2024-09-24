package ru.skillfactorydemo.tgbot.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactorydemo.tgbot.DTO.ValuteCursOnDate;
import ru.skillfactorydemo.tgbot.service.CentralRussianBankService;
import ru.skillfactorydemo.tgbot.service.StatService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
//@Controller
//@EnableAutoConfiguration
public class CurrencyController {
    private final CentralRussianBankService centralRussianBankService;

    private final StatService statService;

    @GetMapping("/getCurrencies")
    //@ResponseBody
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
//        System.out.println("В переменной centralRussianBankService в контроллере вот такой маршаллер");
//        System.out.println(centralRussianBankService.getMarshaller());
//        System.out.println("хэш код сервиса");
//        System.out.println(centralRussianBankService.hashCode());
        return centralRussianBankService.getCurrenciesFromCbr();
    }

//    @GetMapping("/getCurrencies2")
//    @ResponseBody
//    public String getValuteCursOnDate2() throws Exception {
//        return "Hello";
//    }

    @GetMapping("/getStats")
    @ApiOperation("Количество пополнений, которые превышают определнную сумму")
    public int getStatsAboutIncomesThatGreater(@RequestParam (value = "amount") BigDecimal amount) throws Exception {
        return statService.getCountIncomesThatGreater(amount);
    }
    @GetMapping("/getStatsSpend")
    @ApiOperation("Количество трат, которые превышают определнную сумму")
    public int getStatsAboutSpendsThatGreater(@RequestParam (value = "amount") BigDecimal amount) throws Exception {
        return statService.getCountSpendsThatGreater(amount);
    }

//    @GetMapping("/getTestList")
//    @ResponseBody
//    public List <ValuteCursOnDate> getTestList() throws Exception {
//        List <ValuteCursOnDate> strList = new ArrayList<ValuteCursOnDate>();
//        strList.add(new ValuteCursOnDate("RUB", 0.56));
//        strList.add(new ValuteCursOnDate("EUR", 7.93));
//        strList.add(new ValuteCursOnDate("USD", 31.5));
//        strList.add(new ValuteCursOnDate("TUR", 10.6));
//        return strList;
//    }
}
