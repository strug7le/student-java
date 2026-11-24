package edu.course.lab03;

/**
 * Выбирает более приоритетную задачу с помощью переданной политики.
 */
public class TaskPrioritizer {

    private final PriorityPolicy priorityPolicy;

    /**
     * @param priorityPolicy политика вычисления приоритета
     * @throws IllegalArgumentException если политика равна {@code null}
     */
    public TaskPrioritizer(PriorityPolicy priorityPolicy) {
        if (priorityPolicy == null) {
            throw new IllegalArgumentException("priority policy must not be null");
        }
        this.priorityPolicy = priorityPolicy;
    }

    /**
     * Выбирает более приоритетную задачу. При равном приоритете возвращает первую.
     *
     * @param first первая задача
     * @param second вторая задача
     * @return задача с большим приоритетом
     */
    public ProjectTask selectMoreImportant(ProjectTask first, ProjectTask second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("tasks must not be null");
        }
        int firstPriority = priorityPolicy.calculatePriority(first);
        int secondPriority = priorityPolicy.calculatePriority(second);
        return firstPriority >= secondPriority ? first : second;
    }
}
