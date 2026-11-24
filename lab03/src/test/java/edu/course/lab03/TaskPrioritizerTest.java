package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskPrioritizerTest {

    @Test
    void selectsTaskWithMoreEffort() {
        ProjectTask longTask = new ProjectTask("TASK-1", "Long task", 8);
        ProjectTask shortTask = new ProjectTask("TASK-2", "Short task", 3);
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());

        assertSame(longTask, prioritizer.selectMoreImportant(longTask, shortTask));
    }

    @Test
    void selectsInProgressTaskOverNewTask() {
        ProjectTask newTask = new ProjectTask("TASK-1", "New task", 8);
        ProjectTask inProgressTask = new ProjectTask("TASK-2", "In progress", 3);
        inProgressTask.changeStatus(TaskStatus.IN_PROGRESS);
        TaskPrioritizer prioritizer = new TaskPrioritizer(new StatusPriorityPolicy());

        assertSame(inProgressTask, prioritizer.selectMoreImportant(newTask, inProgressTask));
    }

    @Test
    void replacesPolicyWithoutChangingPrioritizerCode() {
        ProjectTask longNewTask = new ProjectTask("TASK-1", "Long new task", 8);
        ProjectTask shortInProgressTask = new ProjectTask("TASK-2", "Short in progress", 3);
        shortInProgressTask.changeStatus(TaskStatus.IN_PROGRESS);

        TaskPrioritizer effortPrioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        TaskPrioritizer statusPrioritizer = new TaskPrioritizer(new StatusPriorityPolicy());

        assertSame(longNewTask, effortPrioritizer.selectMoreImportant(longNewTask, shortInProgressTask));
        assertSame(shortInProgressTask, statusPrioritizer.selectMoreImportant(longNewTask, shortInProgressTask));
    }

    @Test
    void returnsFirstTaskWhenPrioritiesAreEqual() {
        ProjectTask first = new ProjectTask("TASK-1", "First", 5);
        ProjectTask second = new ProjectTask("TASK-2", "Second", 5);
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());

        assertSame(first, prioritizer.selectMoreImportant(first, second));
    }

    @Test
    void doesNotModifyInputTasks() {
        ProjectTask first = new ProjectTask("TASK-1", "First", 8);
        ProjectTask second = new ProjectTask("TASK-2", "Second", 3);
        second.changeStatus(TaskStatus.IN_PROGRESS);
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());

        prioritizer.selectMoreImportant(first, second);

        assertEquals(TaskStatus.NEW, first.getStatus());
        assertEquals(8, first.getEstimatedHours());
        assertEquals(TaskStatus.IN_PROGRESS, second.getStatus());
        assertEquals(3, second.getEstimatedHours());
    }

    @Test
    void rejectsNullPolicy() {
        assertThrows(IllegalArgumentException.class, () -> new TaskPrioritizer(null));
    }

    @Test
    void rejectsNullTask() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        ProjectTask task = new ProjectTask("TASK-1", "Task", 8);

        assertThrows(IllegalArgumentException.class,
                () -> prioritizer.selectMoreImportant(null, task));
        assertThrows(IllegalArgumentException.class,
                () -> prioritizer.selectMoreImportant(task, null));
    }
}
