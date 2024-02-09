package fruitfly.util;

import com.intellij.openapi.diagnostic.Logger;

public class Log {
  private static final Logger LOG = Logger.getInstance(Log.class);

  public static void log(String msg) {

    /* info() messages are visible in the idea.log, but that's a pain in the
      butt during dev.  But warn() are visible on the console when running the
      `runIde` task so they can be seen in the output window of your
      development IDE.
      So uncomment the warn() when working that way, but don't commit it.
      */
    LOG.info(msg);
    LOG.warn(msg);
  }


}
