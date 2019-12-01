package by.epam.web.unit2.observer;

import java.util.List;

public interface Observer<T> {
	 void handleEvent(T item);
}
