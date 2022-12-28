package me.boris.mysql;

import java.util.List;

public interface CrudGeneric<T, ID> {

    boolean create(T t);

    boolean update(T t);

    boolean delete(ID id);

    T read(ID id);

    List<T> read();


}

