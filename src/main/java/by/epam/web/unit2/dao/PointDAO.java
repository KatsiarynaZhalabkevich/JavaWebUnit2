package by.epam.web.unit2.dao;

import by.epam.web.unit2.bean.Point;
import by.epam.web.unit2.exception.DAOException;
import by.epam.web.unit2.specification.Specification;

import java.util.List;

public interface PointDAO {

    boolean addPoint(Point point) throws DAOException;

    void add(List<Point> points) throws DAOException;

    Point takePoint() throws DAOException;

    List<Point> takeFourPoints() throws DAOException;

    List<Point> takeAllPoints() throws DAOException;

    void remove(Point point) throws DAOException;

    void remove(Specification specification) throws DAOException;

    Point find(Specification specification) throws DAOException;
}
