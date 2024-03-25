package calculator.controller;

import calculator.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//Тестовый запрос для проверки  http://localhost:8081/calculate?averageSalaryYear=1200000&vacationDays=28
//Тестовый запрос для проверки  http://localhost:8081/calculate?averageSalaryYear=1200000&vacationDays=0

@RestController
@RequestMapping("/calculate")
@Slf4j
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String getVacationPay(@RequestParam("averageSalaryYear") double averageSalaryYear,
                                 @RequestParam("vacationDays") int vacationDays) {
        log.info("Отправлен запрос GET:/calculate с параметрами: средняя зп за год - {}; число дней отпуска - {}.", averageSalaryYear, vacationDays);
        return calculatorService.getVacationPay(averageSalaryYear, vacationDays);
    }


}

