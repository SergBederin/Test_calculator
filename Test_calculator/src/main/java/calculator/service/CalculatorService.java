package calculator.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
//import ru.yandex.practicum.filmorate.exception.ValidationException;


@Service
@Slf4j
public class CalculatorService {

    final int MONTHS_IN_YEAR = 12;
    final double AVERAGE_WORKDAYS_IN_MONTH = 29.3;


    public String getVacationPay(double averageSalaryYear, int vacationDays) {

        double daySalary =  (averageSalaryYear/MONTHS_IN_YEAR)/AVERAGE_WORKDAYS_IN_MONTH;
        log.info("Количество отпускных, за один день : {}", daySalary);
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        String vacationPay = twoDForm.format((daySalary * vacationDays));
        //vacationPay = daySalary * vacationDays;
        log.info("Cумма отпускных, которые придут сотруднику : {}", vacationPay);

        return vacationPay;
    }

}

