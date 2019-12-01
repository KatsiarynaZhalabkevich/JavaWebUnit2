package by.epam.web.unit2;


import java.util.List;

import by.epam.web.unit2.bean.Cube;
import org.junit.Assert;
import org.junit.Test;


import by.epam.web.unit2.bean.Point;
import by.epam.web.unit2.validator.DataValidator;

public class DataValidatorTest {
    Cube cube = new Cube(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));

    @Test
    public void isCubeTest() {
        DataValidator dataValid = new DataValidator();
        Assert.assertTrue(dataValid.isCube(cube));
    }


}
