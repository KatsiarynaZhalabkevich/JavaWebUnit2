package by.epam.web.unit2.observer;

import by.epam.web.unit2.bean.Point;

public interface Observable<T> {
	
	 void addObserver(Observer<T> observer);

	 void removeObserver(Observer<T> observer);

	void notifyObservers();
}
