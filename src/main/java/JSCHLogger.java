import java.util.logging.Logger;

public class JSCHLogger implements com.jcraft.jsch.Logger {
  private final Logger logger = Logger.getLogger("JSCHLogger");
  private final String logTitle = "JSCH Logs";

  public JSCHLogger() {
    logger.info("JSCHLogger initialized");
  }

  @Override
  public boolean isEnabled(int pLevel) {
    return true;
  }

  @Override
  public void log(int pLevel, String pMessage) {
    String fatalLogTitle = logTitle + " fatal";
    switch (pLevel) {
      case DEBUG:
        logger.info(logTitle + " message =" + pMessage);
        break;
      case INFO:
        logger.info(logTitle + " message =" + pMessage);
        break;
      case ERROR:
        logger.info(logTitle + " message =" + pMessage);
        break;
      case WARN:
        logger.info(logTitle + " message =" + pMessage);
        break;
      case FATAL:
        logger.info(logTitle + " message =" + pMessage);
        break;
      default:
        logger.info(logTitle + " message =" + pMessage);
    }
  }
}