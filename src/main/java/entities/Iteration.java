package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class    Iteration {

    private String goal;
    private Project project;
    private List<Activity> activities;

    public Iteration(String goal, Project project) {
        this.goal = goal;
        this.project = project;
        this.activities = new ArrayList<>();

        project.addIteration(this);
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }
    /*public int countOpenActivities(){
        return (int) this.activities.stream()
                .map(activity -> activity.isActive())
                .filter (b -> !b)
                .count ();
    }*/

    public Duration getDuration() throws SabanaResearchException {
        if (this.activities.isEmpty()){
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_ITERATION);
        }
        Duration d= Duration.ZERO;
        for (Activity a : this.activities){
            d = d.plus(a.getDuration());
        }
        return d;
    }
}
