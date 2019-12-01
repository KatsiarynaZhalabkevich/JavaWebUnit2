package by.epam.web.unit2.repository.impl;

import by.epam.web.unit2.bean.Point;
import by.epam.web.unit2.repository.Repository;


import java.util.ArrayList;
import java.util.List;

public class PointRepositoryImpl implements Repository<Point> {

   private List<Point> pointList = new ArrayList<>();

    @Override
    public void add(Point point) {
        pointList.add(point);
    }



    @Override
    public void remove(Point point) {
        pointList.remove(point);
    }



    @Override
    public List<Point> readAll() {
        return pointList;
    }
}
