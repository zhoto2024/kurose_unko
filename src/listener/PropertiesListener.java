package listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class PropertiesListener
 *
 */
@WebListener
public class PropertiesListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public PropertiesListener() {
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

     // ...（中略）...

        String path = context.getRealPath("/META-INF/application.properties");
        try {
            InputStream is = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(is);
            is.close();

            Iterator<String> pit = properties.stringPropertyNames().iterator();
            while (pit.hasNext()) {
                String pname = pit.next();
                context.setAttribute(pname, properties.getProperty(pname));
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }


    }

}