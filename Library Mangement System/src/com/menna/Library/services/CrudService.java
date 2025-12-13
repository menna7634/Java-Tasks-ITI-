package com.menna.Library.services;

public interface CrudService<T> {
    void create(T t);
    T read(int id) throws Exception;
    void update(int id, T t) throws Exception;
    void delete(int id) throws Exception;
}
