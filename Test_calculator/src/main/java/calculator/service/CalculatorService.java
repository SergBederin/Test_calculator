package calculator.service;

import calculator.exception.ValidationException;
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

        validation(averageSalaryYear, vacationDays);

        double daySalary = (averageSalaryYear / MONTHS_IN_YEAR) / AVERAGE_WORKDAYS_IN_MONTH;
        log.info("Количество отпускных, за один день : {}", daySalary);
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        String vacationPay = twoDForm.format((daySalary * vacationDays));
        log.info("Cумма отпускных, которые придут сотруднику : {}", vacationPay);

        return vacationPay;
    }

    void validation(double averageSalaryYear, int vacationDays) {
        if (averageSalaryYear == 0 || vacationDays == 0) {
            log.info("Не указаны средняя зп за год или дни отпуска, в запросе.");
            throw new ValidationException("Необходимо указать среднюю зарплату за 12 месяцев и количество дней отпуска");
        }
        if (vacationDays < 1) {
            log.info("Некорректно указаны дни отпуска в запросе, не может быть меньше одного дня.");
            throw new ValidationException("Число дней отпуска не может быть меньше одного дня.");
        }
    }


}

