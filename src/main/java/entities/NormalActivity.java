package entities;

import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends Activity {

    private List<Step> steps;

    public NormalActivity(String name, String state, Iteration iteration) {
        super(name, state, iteration);
        this.steps = new ArrayList<>();
    }

    public void addStep(Step step) {
        this.steps.add(step);
    }

    @Override
    public boolean getDuration() {
        return true;
    }
    public boolean getDuration throws SabanaResearchException(){
        if (NormalActivity !steps.contains(steps)){
        }
    }
}
