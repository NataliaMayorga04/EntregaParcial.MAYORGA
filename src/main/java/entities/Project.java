package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private LocalDate dateInit;
    private LocalDate dateEnd;
    private Group group;
    private List<Iteration> iterations = new ArrayList<>();
    private StudentSynthesizer studentSynthesizer = new StudentSynthesizer();
    private List<Student> students = new ArrayList<>();
    private ExecutiveSynthesizer executiveSynthesizer = new ExecutiveSynthesizer();

    public Project(String name, LocalDate dateInit, LocalDate dateEnd, Group group) {
        this.name = name;
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.group = group;
        this.iterations = new ArrayList<>();

        group.addProject(this);
    }

    public void addIteration(Iteration iteration) {
        this.iterations.add(iteration);
    }
    public void setDateInit(LocalDate dateInit) {
        this.dateInit = dateInit;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }
    /**
     * Evaluate if a project is active.
     *
     * @return false if the project has not open activities or the dateEnd is before than the system date.
     */
    public boolean isActive() {
        boolean result = true;
        for (Iteration i:this.iterations) {
            if (i.countOpenActivities()==0||this.dateEnd.isBefore(LocalDate.now())){
                result=false;
            }
        }
        return result;
    }

    public int countOpenActivities(){
        return this.iterations
                .stream()
                .map(i -> i.countOpenActivities())
                .reduce (0,(a,b) -> a+b);
    }

    public Duration getDuration() throws SabanaResearchException {
        if (this.iterations.isEmpty()){
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_PROJECT);
        }
        Duration d= Duration.ZERO;
        for (Iteration i : this.iterations){
            d = d.plus(i.getDuration());
        }
        return d;
    }

    public Duration summarize() throws SabanaResearchException {
        Duration d= Duration.ZERO;
        if(this.isStudentSynthesizer()){
            d = studentSynthesizer.synthesize(this.students, this.iterations);
        }
        else {
            d = executiveSynthesizer.synthesize(this.students, this.iterations);
        }
        return studentSynthesizer.synthesize(this.students, null);
    }

    public List<Student> getStudents() {
        return students;
    }
    public boolean isStudentSynthesizer(){
        boolean resolve= true;
        if (this.students.isEmpty()){
            resolve = false;
        }
        return resolve;
    }

    public List<Iteration> getIterations() {
        return iterations;
    }
}
