package by.epam.web.unit2.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam.web.unit2.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.bean.Point;
import by.epam.web.unit2.service.CubeService;
import by.epam.web.unit2.service.util.CubeUtil;

public class CubeServiceImpl implements CubeService {

    static final Logger logger = LogManager.getLogger();
    private DataValidator dv = new DataValidator();
    private static final String CUBE_SOURCE = "by\\epam\\web\\unit2\\resources\\cube.txt";

    @Override
    public double cubeSquare(Cube cube) {

        double square = -1;

        if (dv.isCube(cube)) {

            cube.setSide(CubeUtil.solveSide(cube.getPointA(), cube.getPointB()));
            square = 6 * Math.pow(cube.getSide(), 2);
        }
        return square;
    }

    @Override
    public double cubeVolume(Cube cube) {

        double volume = -1;
        if (dv.isCube(cube)) {

            cube.setSide(CubeUtil.solveSide(cube.getPointA(), cube.getPointB()));
            volume = Math.pow(cube.getSide(), 3);
        }
        return volume;
    }

    @Override
    public boolean isBaseOnPlot(Cube cube) {
        // тк по условию куб ориентирован параллельно осям, то достаточно 1 точки с
        // координатой 0
        // достаточно ли ответа да/нет

        // тк изначально точки не закинули в лист, то закинем сейчас

        List<Point> list = new ArrayList<Point>();
        list.add(cube.getPointA());
        list.add(cube.getPointB());
        list.add(cube.getPointC());
        list.add(cube.getPointD());

        // проверка ZOY x=0

        for (Point point : list) {
            if (point.getX() == 0) {
                logger.info(" Base of the cube belongs to the plane ZOY");
                return true;
            }
        }

        for (Point point : list) {
            if (point.getY() == 0) {
                logger.info(" Base of the cube belongs to the plane ZOX");
                return true;
            }
        }

        for (Point point : list) {
            if (point.getZ() == 0) {
                logger.info(" Base of the cube belongs to the plane XOY");
                return true;
            }
        }

        logger.info("No bases of the cube belongs to the plane!");
        return false;
    }

    @Override
    public double volumeRatio(Cube cube) {
//1. найти какая плоскость разделяет куб (1 из 3) вариант 3 из 3 не рассматривается
        Point a = cube.getPointA();
        Point b = cube.getPointB();
        Point c = cube.getPointC();
        Point d = cube.getPointD();

        double ratio;

        //если XOY z +/-

        if (a.getZ() > 0) {
            if (b.getZ() < 0 && a.getX() == b.getX() && a.getY() == b.getY()) {
                logger.info("XOY cross cube");
                ratio = (a.getZ() + Math.abs(b.getZ())) / a.getZ();
                return ratio;
            }
        }
        if (a.getZ() > 0) {
            if (c.getZ() < 0 && a.getX() == c.getX() && a.getY() == c.getY()) {
                logger.info("XOY cross cube");
                ratio = (a.getZ() + Math.abs(c.getZ())) / a.getZ();
                return ratio;
            }
        }
        if (a.getZ() > 0) {
            if (d.getZ() < 0 && a.getX() == d.getX() && a.getY() == d.getY()) {
                logger.info("XOY cross cube");
                ratio = (a.getZ() + Math.abs(d.getZ())) / a.getZ();
                return ratio;
            }
        }
        if (a.getZ() < 0) {
            if (b.getZ() > 0 && a.getX() == b.getX() && a.getY() == b.getY()) {
                logger.info("XOY cross cube");
                ratio = (a.getZ() + Math.abs(b.getZ())) / a.getZ();
                return ratio;
            }
        }
        if (a.getZ() < 0) {
            if (c.getZ() > 0 && a.getX() == c.getX() && a.getY() == c.getY()) {
                logger.info("XOY cross cube");
                ratio = (a.getZ() + Math.abs(c.getZ())) / a.getZ();
                return ratio;
            }
        }
        if (a.getZ() < 0) {
            if (d.getZ() > 0 && a.getX() == d.getX() && a.getY() == d.getY()) {
                logger.info("XOY cross cube");
                ratio = (a.getZ() + Math.abs(d.getZ())) / a.getZ();
                return ratio;
            }
        }


        return 0;
    }

    @Override
    public List<Cube> createCubes(List<Point> pointLst) {
        List<Cube> cubeLst = new ArrayList<>();
        for (int i = 0; i < pointLst.size() - 4; i += 4) {
            Cube cube = new Cube(pointLst.get(i), pointLst.get(i + 1), pointLst.get(i + 2), pointLst.get(i + 3));
            cubeLst.add(cube);
        }

        return cubeLst;
    }

}
