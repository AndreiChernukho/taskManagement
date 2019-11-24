package task;

import common.GeneralRepository;

import java.util.List;

public interface TaskRepository extends GeneralRepository<Task> {

    List<Task> getTasks(String projectId);

}
