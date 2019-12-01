package by.epam.web.unit2.main;

import by.epam.web.unit2.exception.DAOException;
import by.epam.web.unit2.dao.util.Reader;
import by.epam.web.unit2.dao.util.Parser;

import java.util.List;

public class Main {
    public static void main(String[] args) throws DAOException {
        Reader helper = new Reader();
        Parser parser = new Parser();
        List<String> dataList = helper.readLines(); //получили строки
        for (String s: dataList){

        }
    }
}
