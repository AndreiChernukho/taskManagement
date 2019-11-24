package common;

import java.util.List;

public interface GeneralRepository<T> {

    void save(T object);

    List<T> getList();

    T get(String id);

    void delete(String id);
}


