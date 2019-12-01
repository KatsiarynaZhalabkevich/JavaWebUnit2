package by.epam.web.unit2.dao.util;

import by.epam.web.unit2.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    static final Logger logger = LogManager.getLogger(Writer.class);
    private static final String CUBE_SOURCE = "src\\main\\java\\by\\epam\\web\\unit2\\resourses\\data.txt";
    private static final Writer instance = new Writer();

    java.io.Writer wr;


    private Writer() {
    }

    public static Writer getInstance() {
        return instance;
    }

    public void writeItem(String str, String path) throws DAOException, IOException {
        {
            try {
                wr = new FileWriter(new File(path));
                wr.write(str); //записали точку 1 штуку

            } catch (IOException e) {
                logger.error("Exception method WritePoint");
                throw new DAOException(e);


            }finally {
                wr.close();
            }
        }
    }


}
