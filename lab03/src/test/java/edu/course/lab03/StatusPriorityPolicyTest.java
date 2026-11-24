package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StatusPriorityPolicyTest {

    private final StatusPriorityPolicy policy = new StatusPriorityPolicy();

    @Test
    void inProgressTaskHasHighestPriority() {
        ProjectTask task = taskWithStatus(TaskStatus.IN_PROGRESS);

        assertEquals(2, policy.calculatePriority(task));
    }

    @Test
    void newTaskHasHigherPriorityThanDoneTask() {
        ProjectTask newTask = taskWithStatus(TaskStatus.NEW);
        ProjectTask doneTask = taskWithStatus(TaskStatus.DONE);

        assertTrue(policy.calculatePriority(newTask) > policy.calculatePriority(doneTask));
    }

    @Test
    void doneTaskHasLowestPriority() {
        ProjectTask task = taskWithStatus(TaskStatus.DONE);

        assertEquals(0, policy.calculatePriority(task));
    }

    @Test
    void rejectsNullTask() {
        assertThrows(IllegalArgumentException.class, () -> policy.calculatePriority(null));
    }

    private static ProjectTask taskWithStatus(TaskStatus status) {
        ProjectTask task = new ProjectTask("TASK-1", "Task", 8);
        task.changeStatus(status);
        return task;
    }
}
