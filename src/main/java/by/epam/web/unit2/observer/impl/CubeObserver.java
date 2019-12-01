package by.epam.web.unit2.observer.impl;

import by.epam.web.unit2.bean.Cube;

import by.epam.web.unit2.observer.Observer;
import by.epam.web.unit2.service.CubeService;
import by.epam.web.unit2.service.impl.CubeServiceImpl;



public class CubeObserver implements Observer<Cube> {
    private double square;
    private double volume;



    @Override
    public void handleEvent(Cube cube) {
        CubeService cubeService = new CubeServiceImpl();
        square = cubeService.cubeSquare(cube);
        volume = cubeService.cubeVolume(cube);

    }

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }
}
