package by.epam.web.unit2.service.util;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.observer.Observable;
import by.epam.web.unit2.service.CubeService;

public class FigureParameters   {

    private double volume;
    private double square;
    private boolean isBaseOnPlot;
    private CubeService cubeService;


    public FigureParameters(Cube cube) {
        volume = cubeService.cubeVolume(cube);
        square = cubeService.cubeSquare(cube);
        isBaseOnPlot = cubeService.isBaseOnPlot(cube);

    }

    public double getVolume() {
        return volume;
    }
    public double getSquare() {
        return square;
    }
    public boolean isBaseOnPlot() {
        return isBaseOnPlot;
    }


}
