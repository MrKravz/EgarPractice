package services;

import models.Rate;
import models.TimeStatus;

public interface ComputeSalaryService {

    Float computeHoursSalary(Rate rate, int hours, TimeStatus timeStatus);

}
