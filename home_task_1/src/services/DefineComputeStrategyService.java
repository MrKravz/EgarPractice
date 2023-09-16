package services;

import models.TimeStatus;
import util.strategy.ComputeSalaryStrategy;

public interface DefineComputeStrategyService {

    ComputeSalaryStrategy defineComputeStrategy(TimeStatus timeStatus);

}
