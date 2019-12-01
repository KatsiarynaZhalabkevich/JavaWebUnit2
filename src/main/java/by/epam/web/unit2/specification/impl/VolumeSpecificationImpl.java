package by.epam.web.unit2.specification.impl;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.service.CubeService;
import by.epam.web.unit2.service.impl.CubeServiceImpl;
import by.epam.web.unit2.specification.Specification;

public class VolumeSpecificationImpl implements Specification {
    private double min;
    private double max;


    public VolumeSpecificationImpl(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(Cube cube) {

        CubeService cubeService = new CubeServiceImpl();
        double square = cubeService.cubeSquare(cube);

        return min <= square && square <= max;
    }
}
