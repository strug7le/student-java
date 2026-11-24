package edu.course.lab03;

/**
 * Приоритет по статусу задачи.
 */
public class StatusPriorityPolicy implements PriorityPolicy {

    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("task must not be null");
        }
        switch (task.getStatus()) {
            case IN_PROGRESS:
                return 2;
            case NEW:
                return 1;
            case DONE:
                return 0;
            default:
                throw new IllegalArgumentException("unknown task status");
        }
    }
}
