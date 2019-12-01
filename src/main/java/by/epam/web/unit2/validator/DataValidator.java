package by.epam.web.unit2.validator;


import by.epam.web.unit2.bean.Cube;
import by.epam.web.unit2.service.util.CubeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class DataValidator {

	static final Logger logger = LogManager.getLogger();


	public boolean isCube(Cube cube) {

		double sideAB = 0;
		double sideAC = 0; // почему нельзя прописать private
		double sideAD = 0;
		double sideBC = 0;
		double sideBD = 0;
		double sideCD = 0;

		sideAB = CubeUtil.solveSide(cube.getPointA(), cube.getPointB());
		sideAC = CubeUtil.solveSide(cube.getPointA(), cube.getPointC());
		sideAD = CubeUtil.solveSide(cube.getPointA(), cube.getPointD());

		if (sideAB == sideAC && sideAC == sideAD) {
			logger.info("The cube exists");
			return true;
		} else {
			sideBC = CubeUtil.solveSide(cube.getPointB(), cube.getPointC());
			sideBD = CubeUtil.solveSide(cube.getPointB(), cube.getPointD());
			if (sideBC == sideBD && sideBD == sideAB) {
				logger.info("The cube exists");
				return true;
			} else {
				sideCD = CubeUtil.solveSide(cube.getPointC(), cube.getPointD());
				if (sideCD == sideBC && sideBC == sideAC) {
					logger.info("The cube exists");
					return true;
				} else {
					if (sideCD == sideAD && sideAD == sideBD) {
						logger.info("The cube exists");
						return true;
					} else {
						logger.info("The cube doesn't exist");
						return false;
					}
				}
			}
		}

	}


		




}
