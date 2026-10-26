package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectTaskTest {

    @Test
    void constructorCreatesTaskWithNewStatus() {
        ProjectTask task = new ProjectTask("TASK-1", "Implement domain model", 8);

        assertEquals("TASK-1", task.getId());
        assertEquals("Implement domain model", task.getTitle());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertEquals(8, task.getEstimatedHours());
        assertFalse(task.isCompleted());
    }

    @Test
    void constructorRejectsNullId() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(null, "Title", 8));
    }

    @Test
    void constructorRejectsEmptyId() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("", "Title", 8));
    }

    @Test
    void constructorRejectsBlankId() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("   ", "Title", 8));
    }

    @Test
    void constructorRejectsNullTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", null, 8));
    }

    @Test
    void constructorRejectsEmptyTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", "", 8));
    }

    @Test
    void constructorRejectsBlankTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", "   ", 8));
    }

    @Test
    void constructorRejectsZeroEstimatedHours() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", "Title", 0));
    }

    @Test
    void constructorRejectsNegativeEstimatedHours() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", "Title", -1));
    }

    @Test
    void changeStatusUpdatesStatus() {
        ProjectTask task = new ProjectTask("TASK-1", "Title", 8);

        task.changeStatus(TaskStatus.IN_PROGRESS);

        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        assertFalse(task.isCompleted());
    }

    @Test
    void changeStatusRejectsNull() {
        ProjectTask task = new ProjectTask("TASK-1", "Title", 8);

        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
        assertEquals(TaskStatus.NEW, task.getStatus());
    }

    @Test
    void isCompletedReturnsTrueForDoneTask() {
        ProjectTask task = new ProjectTask("TASK-1", "Title", 8);

        task.changeStatus(TaskStatus.DONE);

        assertTrue(task.isCompleted());
    }

    @Test
    void isCompletedReturnsFalseForTaskInProgress() {
        ProjectTask task = new ProjectTask("TASK-1", "Title", 8);

        task.changeStatus(TaskStatus.IN_PROGRESS);

        assertFalse(task.isCompleted());
    }

    @Test
    void increaseEstimatedHoursAddsHours() {
        ProjectTask task = new ProjectTask("TASK-1", "Title", 8);

        task.increaseEstimatedHours(4);

        assertEquals(12, task.getEstimatedHours());
    }

    @Test
    void increaseEstimatedHoursRejectsZero() {
        ProjectTask task = new ProjectTask("TASK-1", "Title", 8);

        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimatedHours(0));
        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void increaseEstimatedHoursRejectsNegativeValue() {
        ProjectTask task = new ProjectTask("TASK-1", "Title", 8);

        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimatedHours(-1));
        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void increaseEstimatedHoursRejectsOverflow() {
        ProjectTask task = new ProjectTask("TASK-1", "Title", Integer.MAX_VALUE);

        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimatedHours(1));
        assertEquals(Integer.MAX_VALUE, task.getEstimatedHours());
    }
}
