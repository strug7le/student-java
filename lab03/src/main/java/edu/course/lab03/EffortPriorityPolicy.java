package edu.course.lab03;

/**
 * Приоритет по оценке трудоемкости: больше часов — выше приоритет.
 */
public class EffortPriorityPolicy implements PriorityPolicy {

    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("task must not be null");
        }
        return task.getEstimatedHours();
    }
}
