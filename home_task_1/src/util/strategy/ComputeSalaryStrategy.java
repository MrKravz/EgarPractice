package util.strategy;

import models.Rate;

public interface ComputeSalaryStrategy {

    float computeSalary(Rate rate, int hours);

}
