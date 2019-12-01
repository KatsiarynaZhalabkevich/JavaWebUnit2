package by.epam.web.unit2.observer.impl;

import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.bean.Point;
import by.epam.web.unit2.observer.Observable;
import by.epam.web.unit2.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CubeObservableImpl implements Observable<Cube> {

    private Cube cube;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer<Cube> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Cube> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(cube);
        }
    }
}
