package by.epam.web.unit2.repository;

import by.epam.web.unit2.specification.Specification;

import java.util.List;

public interface Repository<T> {
    void add(T item);

    void remove(T item);

    List<T> readAll();


}
