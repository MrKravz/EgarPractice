package services.impl;

import models.*;
import services.*;

class ComputeSalaryServiceImpl implements ComputeSalaryService {

    private final DefineComputeStrategyService defineComputeStrategyService;

    public ComputeSalaryServiceImpl(DefineComputeStrategyService defineComputeStrategyService) {
        this.defineComputeStrategyService = defineComputeStrategyService;
    }

    @Override
    public Float computeHoursSalary(Rate rate, int hours, TimeStatus timeStatus) {
        var strategy = defineComputeStrategyService.defineComputeStrategy(timeStatus);
        return strategy.computeSalary(rate, hours);
    }

}
