package dev.patika.fourthhomework.service;

import java.util.List;

public interface BaseService<T> {

    List<T> findAll();
    T findById(int id);
    T save(T object);
    void delete(T object);
    void deleteById(int id);
    T update(T object);
    void updateById(T object, int id);
}
