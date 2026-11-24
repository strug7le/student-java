package edu.course.lab03;

/**
 * Политика вычисления приоритета задачи.
 */
public interface PriorityPolicy {

    /**
     * Вычисляет приоритет задачи.
     *
     * @return приоритет задачи; большее значение означает более высокий приоритет
     */
    int calculatePriority(ProjectTask task);
}
