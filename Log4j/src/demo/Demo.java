package demo;
import org.apache.logging.log4j.*;

public class Demo {
	
	public static Logger logger = LogManager.getLogger(Demo.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logger.debug("Debug message");
		logger.error("error message");
		logger.info("info message");
		logger.trace("trace");
		logger.fatal("fatal message");

	}

}
