package by.epam.web.unit2.dao.util;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.bean.Point;
import by.epam.web.unit2.exception.DataValidatorException;
import by.epam.web.unit2.service.util.FigureParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Parser {

    static final Logger logger = LogManager.getLogger(Parser.class);
    private List<Point> pointsList = new ArrayList<>();


    //из строки делает точки, тк в строке записано несколько точек
    public List<Point> parseStringToPoints(String lineToParse) throws DataValidatorException {

        String[] points; //почему нельзя для локальныз переменных прописать private
        String[] koord;

        points = lineToParse.split(";"); //разбили на точки

        if (points.length == 4) {

            for (int i = 0; i < points.length; i++) {

                koord = points[i].split(" "); //разбили на координаты

                if (koord.length == 3) {

                    double x = Double.parseDouble(koord[0]);
                    double y = Double.parseDouble(koord[1]);
                    double z = Double.parseDouble(koord[2]);

                    pointsList.add(new Point(x, y, z));
                    logger.info("Point added!");

                } else {
                    logger.error("Invalid data to create the point!");
                    throw new DataValidatorException(); //надо ли catch
                }

            }
        } else {
            logger.error("Line can not convert to points");
            throw new DataValidatorException();
        }
        return pointsList;
    }

    public String parsePointToString(Point point) {
        String result;

        result = point.getX() + " " + point.getY() + " " + point.getZ() + ";";
        return result;
    }

    public String parseCubeToString(Cube cube) {
        FigureParameters parameters = new FigureParameters(cube);
        String result;
        result = cube.getId() + ". " + cube.getPointA() + "; " + cube.getPointB() + "; " + cube.getPointC() + "; " + cube.getPointD() +
                "; side = " + cube.getSide() + "; square = " + parameters.getSquare() + "; volume = " + parameters.getVolume() + ";" +
                " isBaseOnPlot = " + parameters.isBaseOnPlot();
        return result;

    }

    public Cube parseStringToCube(String lineToParse) {
        //написать парсер
        //сначала посмотреть, как будет выглядеть строка куба
        Cube cube = new Cube();
        return cube;
    }


}



