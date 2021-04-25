package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StudentSynthesizer implements ISynthesizer{

    @Override
    public Duration synthesize(List<Student> students) throws SabanaResearchException{
        Duration d= Duration.ZERO;
        for (Student s : students){
            d = d.plusDays(s.getActivitiesDuration().toDays());
        }
        return d;
    }

}
