package common;

import java.util.List;

/**
 * Репозиторий для работы с БД.
 *
 * @param <T> тип сущности.
 */
public interface GeneralRepository<T> {

    /**
     * Сохранение.
     *
     * @param object сохраняемый обьект.
     */
    void save(T object);

    /**
     * Возвращает список обьектов.
     *
     * @return список обьектов.
     */
    List<T> getList();

    /**
     * Возвращает обьект по идентификатору.
     *
     * @param id идетификатор.
     * @return обьект.
     */
    T get(String id);

    /**
     * Удаляет обьект по идентификатору.
     *
     * @param id идентификатор
     */
    void delete(String id);
}
