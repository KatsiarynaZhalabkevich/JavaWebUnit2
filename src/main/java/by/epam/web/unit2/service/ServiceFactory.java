package by.epam.web.unit2.service;

import by.epam.web.unit2.service.impl.CubeServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
    private CubeService cubeService = new CubeServiceImpl();

    public CubeService getCubeService() {
        return cubeService;
    }
}
