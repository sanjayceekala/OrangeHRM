package Log4jDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tests.sanity.Sanity_001_Add_Admin_User;

public class LoggingConsole {
	
	private static final Logger log = LogManager.getLogger(Sanity_001_Add_Admin_User.class.getName());
	
	public static void main(String[] args) {
		log.debug("Debug Message");
		log.error("Error Message");
		log.fatal("fatal Message");
	}

}
