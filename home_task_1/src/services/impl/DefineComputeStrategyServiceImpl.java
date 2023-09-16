package services.impl;

import models.TimeStatus;
import services.DefineComputeStrategyService;
import util.strategy.*;

class DefineComputeStrategyServiceImpl implements DefineComputeStrategyService {

    @Override
    public ComputeSalaryStrategy defineComputeStrategy(TimeStatus timeStatus) {
        if (timeStatus.equals(TimeStatus.Turnout)) {
            return new ComputeTurnoutStrategy();
        }
        if (timeStatus.equals(TimeStatus.OverTime)) {
            return new ComputeOverTimeStrategy();
        }
        if (timeStatus.equals(TimeStatus.BusinessTrip)) {
            return new ComputeBusinessTripStrategy();
        }
        if (timeStatus.equals(TimeStatus.Vacation)) {
            return new ComputeVacationStrategy();
        }
        if (timeStatus.equals(TimeStatus.SickDays)) {
            return new ComputeSickDaysStrategy();
        }
        return new ComputeAbsenceStrategy();
    }

}
