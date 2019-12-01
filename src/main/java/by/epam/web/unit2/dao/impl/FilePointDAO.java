package by.epam.web.unit2.dao.impl;

import by.epam.web.unit2.bean.Point;
import by.epam.web.unit2.dao.PointDAO;
import by.epam.web.unit2.dao.util.Parser;
import by.epam.web.unit2.dao.util.Reader;
import by.epam.web.unit2.dao.util.Writer;
import by.epam.web.unit2.exception.DAOException;
import by.epam.web.unit2.exception.DataValidatorException;
import by.epam.web.unit2.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilePointDAO implements PointDAO {

    private static final Logger logger = LogManager.getLogger();
    private Writer writer = Writer.getInstance();
    private Reader reader = new Reader();
    private Parser parser = new Parser();
    private static final String POINT_SOURCE = "by\\epam\\web\\unit2\\resources\\data.txt";

    //добавляет точку в файл
    @Override
    public boolean addPoint(Point point) throws DAOException {

        boolean result = false;
        String pointStr;

        if (point != null) {
            pointStr = parser.parsePointToString(point);
            try {
                writer.writeItem(pointStr, POINT_SOURCE);
            } catch (IOException e) {

                throw new DAOException();
            }
            result = true;
        }
        return result;
    }

    @Override
    public void add(List<Point> points) throws DAOException {

        for (Point point : points) {
            addPoint(point);
        }
    }

    @Override
    public Point takePoint() throws DAOException {
        //читать по символьно и записывать? а вдруг там дальше ошибка будет?
        //точку возьмем из листа точек рандомно
        List<Point> points = new ArrayList<>(takeAllPoints());
        Random random = new Random(points.size());

        return points.get(random.nextInt());
    }

    //4 точки нужны для создания куба; чтобы это не было точками 1-4 можно ввести дополнительный параметр номер строки
    @Override
    public List<Point> takeFourPoints() throws DAOException {
        List<Point> points = new ArrayList<>(takeAllPoints());
        List<Point> fourPoints = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            fourPoints.add(points.get(i));
        }

        return fourPoints;
    }

    @Override
    public List<Point> takeAllPoints() throws DAOException {


        List<String> stringPoints;
        List<Point> points = new ArrayList<>();


        stringPoints = reader.readLines();

        for (String str : stringPoints) {
            try {
                points.addAll(parser.parseStringToPoints(str));
            } catch (DataValidatorException e) {
                logger.error("Invalid data from file");
                throw new DAOException();
            }

        }


        return points;
    }

    @Override
    public void remove(Point point) throws DAOException {
        //сделать строку
        //найти в файле строку с такой подстрокой и удалить подстроку(заменить ее на пустые символы)
        //записать все обратно в файл
        String pointToRemove;
        List<String> pointsLst;
        List<String> newPointsLst = new ArrayList<>();

        pointToRemove = parser.parsePointToString(point);
        pointsLst = reader.readLines();

        for (String str : pointsLst) {
            if (!str.contains(pointToRemove)) {
                newPointsLst.add(str);
            } else {
                str.replace(pointToRemove, "");
                newPointsLst.add(str);

            }
        }
        for (String str : newPointsLst) {
            try {
                writer.writeItem(str, POINT_SOURCE);  //проверить, записывает или дозаписывает
            } catch (IOException e) {
              throw new DAOException();
            }
        }

    }

    @Override
    public void remove(Specification specification) throws DAOException {

    }

    @Override
    public Point find(Specification specification) throws DAOException {
        return null;

        //может возвращаться не точка, а список!!!
    }


}
