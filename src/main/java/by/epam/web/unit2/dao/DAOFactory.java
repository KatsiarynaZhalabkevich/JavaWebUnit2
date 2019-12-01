package by.epam.web.unit2.dao;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.dao.impl.FileCubeDAO;
import by.epam.web.unit2.dao.impl.FilePointDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    private PointDAO pointDao = new FilePointDAO();
    private CubeDAO cubeDao = new FileCubeDAO();

    public PointDAO getPointDao() {
        return pointDao;
    }

    public CubeDAO getCubeDao() {
        return cubeDao;
    }
}
