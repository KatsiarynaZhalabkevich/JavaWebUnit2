package by.epam.web.unit2.dao.util;

import by.epam.web.unit2.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private List<String> linesList = new ArrayList<>();
    private String line;
    private static final String POINT_SOURCE = "src\\resourses\\data.txt";
    static final Logger logger = LogManager.getLogger(Reader.class);

//читаем файл по строчкам и возвращаем лист строк. строка = данные для куба
    public List<String> readLines() throws DAOException {

        try (BufferedReader br = new BufferedReader(new FileReader(new File(POINT_SOURCE)))) {

            while (br.ready()) {
                linesList.add(br.readLine());
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found");
            throw new DAOException();
        } catch (IOException e) {
            logger.error("IO exception");
            throw new DAOException();
        }
        return linesList; //прочитали файл по строчкам
    }

    public String readLine() throws DAOException{

        try (BufferedReader br = new BufferedReader(new FileReader(new File(POINT_SOURCE)))) {

            while (br.ready()) {
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found");
            throw new DAOException();
        } catch (IOException e) {
            logger.error("IO exception");
            throw new DAOException();
        }
        return line;
    }


}
