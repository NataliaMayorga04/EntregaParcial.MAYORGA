package entities;

import java.time.Duration;
import java.util.List;

public interface ISynthesizer {
    public abstract Duration synthesize(List<Student> students) throws SabanaResearchException;
}
