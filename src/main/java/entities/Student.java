package entities;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int code;
    private String name;
    private String lastName;
    private String email;
    private List <NormalActivity> assignedActivities = new ArrayList<>();

    private List<Course> approved = new ArrayList<>();

    public Duration getActivitiesDuration() throws SabanaResearchException{
        Duration d= Duration.ZERO;
        for (Activity a :this.assignedActivities){
            d = d.plusDays(a.getDuration().toDays());
        }
        return d;
    }

    public List<NormalActivity> getAssignedActivities() {
        return assignedActivities;
    }
}