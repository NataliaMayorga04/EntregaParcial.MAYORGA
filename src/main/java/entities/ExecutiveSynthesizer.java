package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExecutiveSynthesizer implements ISynthesizer {
    List<Iteration> iterations = new ArrayList<>();

    @Override
    public Duration synthesize(List<Student> students,List<Iteration> iterations) throws SabanaResearchException {
        Duration d= Duration.ZERO;
        for (Iteration i: this.iterations){
            d = d.plusDays(i.getActivitiesDuration().toDays());
        }
        return d;
    }
}
