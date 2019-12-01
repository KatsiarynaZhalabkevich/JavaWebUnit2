package by.epam.web.unit2.storage;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.observer.Observer;
import by.epam.web.unit2.service.CubeService;
import by.epam.web.unit2.service.impl.CubeServiceImpl;
import by.epam.web.unit2.service.util.FigureParameters;
import by.epam.web.unit2.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.HashMap;
import java.util.Map;

public class CubeStorage implements Observer<Cube> {
    private final static Logger logger = LogManager.getLogger(CubeStorage.class);

    private static Map<Integer, FigureParameters> map = new HashMap<>();
    private static CubeStorage instance;

    private CubeStorage() {

    }

    public static CubeStorage getInstance() {
        if (instance == null) {
            instance = new CubeStorage();
        }
        return instance;
    }


    @Override
    public void update(Cube cube) {
        FigureParameters figureParameters;
        CubeService cubeService = new CubeServiceImpl(new DataValidator());
        double volume = cubeService.cubeVolume(cube);
        double square = cubeService.cubeSquare(cube);

        if (map.get(cube.getId()) == null) {
            figureParameters = new FigureParameters(cube);
            map.put(cube.getId(), figureParameters);
        } else {
            figureParameters = map.get(cube.getId());
            figureParameters.setSquare(square);
            figureParameters.setVolume(volume);
            map.put(cube.getId(),figureParameters); // или это лишнее

        }
    }

    public static Map<Integer, FigureParameters> getMap() {
        return map;
    }
}
