package utilitlies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;


public class LoggerUtil {
    private static Logger logger=LoggerFactory.getLogger(LoggerUtil.class);
    public static void info(String message) {

        FormattingTuple ft = MessageFormatter.format("{} {}",new java.util.Date(), message);
        logger.info(ft.getMessage());
    }

}
