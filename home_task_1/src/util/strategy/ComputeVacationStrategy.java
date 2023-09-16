package util.strategy;

import models.Rate;

public class ComputeVacationStrategy implements ComputeSalaryStrategy {

    @Override
    public float computeSalary(Rate rate, int hours) {
        return hours * rate.getVacationRate();
    }

}
