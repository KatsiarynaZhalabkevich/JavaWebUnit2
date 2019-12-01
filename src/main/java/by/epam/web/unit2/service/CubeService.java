package by.epam.web.unit2.service;

import java.util.List;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.bean.Point;

public interface CubeService {

	List<Cube> createCubes(List<Point> pointLst);


	double cubeSquare(Cube cube);

	double cubeVolume(Cube cube);

	boolean isBaseOnPlot(Cube cube);

	double volumeRatio(Cube cube);

}
