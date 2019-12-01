package by.epam.web.unit2.dao.impl;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.dao.CubeDAO;
import by.epam.web.unit2.dao.util.Parser;
import by.epam.web.unit2.dao.util.Reader;
import by.epam.web.unit2.dao.util.Writer;
import by.epam.web.unit2.exception.DAOException;
import by.epam.web.unit2.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FileCubeDAO implements CubeDAO {

    private static final String CUBE_SOURCE = "by\\epam\\web\\unit2\\resources\\cube.txt";
    private static final String POINT_SOURCE = "by\\epam\\web\\unit2\\resources\\data.txt";

    private static final Logger logger = LogManager.getLogger();
    private Writer writer = Writer.getInstance();
    private Reader reader = new Reader();
    private Parser parser = new Parser();



    @Override
    public void add(Cube cube) throws DAOException {
        //по условию данные о кубах изначально не хранятся
        //создадим новый файл, куда запишем данные о кубе (координаты его точек и значение праметров)
        String cubeToString = parser.parseCubeToString(cube);
        writer.writeItem(cubeToString, CUBE_SOURCE);

    }

    @Override
    public void add(List<Cube> cubes) throws DAOException {
        String cubeToString;
        for (Cube cube : cubes) {
            cubeToString = parser.parseCubeToString(cube);
            writer.writeItem(cubeToString, CUBE_SOURCE);  //может быть будет перезаписывать, а не дописывать файл?
        }
    }

    @Override
    public void remove(Cube cube) throws DAOException {
        //сформировать строку
        //прочитать все строки в лист
        //найти в листе строку  (заменять ее не надо, т.к. 1 строка = 1 кубу
        //не записывать строку в новый лист
        //лист записать в файл

        String cubeToString;
        List<String> cubeList;
        List<Cube> cubes;
        List<String> newCubeList = new ArrayList<>();

        cubeToString = parser.parseCubeToString(cube);
        cubeList = reader.readLines();

        for (String str : cubeList) {
            if (!str.equals(cubeToString)) {
                newCubeList.add(str);
            }
        }

        for (String str : newCubeList) {
            writer.writeItem(str, CUBE_SOURCE);
        }
    }

    @Override
    public void remove(Specification specification) throws DAOException {

    }

    @Override
    public List<Cube> readAll() throws DAOException {
        List<String> cubeList;
        List<Cube> cubes = new ArrayList<>();

        cubeList = reader.readLines();
        for (String str : cubeList) {
            cubes.add(parser.parseStringToCube(str));
        }

        return cubes;
    }

    @Override
    public Cube find(Specification specification) throws DAOException {
        return null;
    }
}
