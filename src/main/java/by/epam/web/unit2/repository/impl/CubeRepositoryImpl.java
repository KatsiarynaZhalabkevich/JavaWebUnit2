package by.epam.web.unit2.repository.impl;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.repository.Repository;
import java.util.ArrayList;
import java.util.List;


public class CubeRepositoryImpl implements Repository<Cube> {


    private List<Cube> cubeList = new ArrayList<>();


    @Override
    public void add(Cube cube) {
        cubeList.add(cube);
    }


    @Override
    public void remove(Cube cube) {
        cubeList.remove(cube);
    }


    @Override
    public List<Cube> readAll() {

        return cubeList;
    }
}
