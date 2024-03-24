package calculator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import calculator.service.CalculatorService;



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
        log.info("Отправлен запрос GET:/calculate");
        return  calculatorService.getVacationPay(averageSalaryYear,vacationDays);
    }


}

