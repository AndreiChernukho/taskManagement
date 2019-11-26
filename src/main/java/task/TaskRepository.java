package task;

import common.GeneralRepository;
import java.util.List;

/**
 * Репозиторий для работы с задачами.
 */
public interface TaskRepository extends GeneralRepository<Task> {

    /**
     * Получение списка задач.
     *
     * @param projectId идентефикатор проекта.
     * @return список задач.
     */
    List<Task> getTasks(String projectId);
}
