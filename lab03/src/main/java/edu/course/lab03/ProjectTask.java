package edu.course.lab03;

/**
 * Сокращенная модель задачи проекта для лабораторной работы по полиморфизму.
 */
public class ProjectTask {

    private final String id;
    private final String title;
    private TaskStatus status;
    private final int estimatedHours;

    /**
     * Создает задачу в статусе {@link TaskStatus#NEW}.
     *
     * @param id идентификатор задачи
     * @param title название задачи
     * @param estimatedHours оценка трудоемкости в часах
     * @throws IllegalArgumentException если идентификатор или название пусты,
     *                                  либо оценка трудоемкости неположительна
     */
    public ProjectTask(String id, String title, int estimatedHours) {
        this.id = requireText(id, "id");
        this.title = requireText(title, "title");
        if (estimatedHours <= 0) {
            throw new IllegalArgumentException("estimated hours must be positive");
        }
        this.estimatedHours = estimatedHours;
        this.status = TaskStatus.NEW;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    /**
     * Меняет статус задачи.
     *
     * @param newStatus новый статус
     * @throws IllegalArgumentException если статус равен {@code null}
     */
    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("status must not be null");
        }
        this.status = newStatus;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be null or blank");
        }
        return value;
    }
}
