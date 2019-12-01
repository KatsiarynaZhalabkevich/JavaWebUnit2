package by.epam.web.unit2.dao;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.exception.DAOException;
import by.epam.web.unit2.specification.Specification;

import java.util.List;

public interface CubeDAO {

    void add(Cube cube) throws DAOException;

    void add(List<Cube > cubes) throws DAOException;

    void remove(Cube cube) throws DAOException;

    void remove(Specification specification) throws DAOException;

    List<Cube> readAll() throws DAOException;

    Cube find (Specification specification) throws DAOException;
}
