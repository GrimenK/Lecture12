import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {


        firstTask();
        fourthTask();
        thirdTask();
    }

    public static void firstTask(){
        LOGGER.info("1st & 2nd TASK \n");
        Class userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        for (Field field:fields
             ) {
            if (field.isAnnotationPresent(CustomFieldAnnotation.class)){
                LOGGER.info(field);
                //task 2
                LOGGER.info(field.getAnnotation(CustomFieldAnnotation.class).description());
            }
        }
    }

    public static void thirdTask(){
        LOGGER.info("3rd TASK \n");
        User user = new User();
        user.setAge(4);

        Class userClass = User.class;
        try {
            Method method = userClass.getDeclaredMethod("methodForInvoke", int.class);
            method.setAccessible(true);
            try {
                LOGGER.info(method.invoke(user,200));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void fourthTask() throws IllegalAccessException, InstantiationException {
        LOGGER.info("4th TASK \n");
        User user = new User();

        Class userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        for (Field field:fields
             ) {
            if(!field.isAccessible()){
                field.setAccessible(true);
            }
        }
        fields[0].set(user,(String) "testName");
        fields[1].set(user,(String) "FF123123");
        fields[2].set(user,25);
        fields[3].set(user,120000);
        fields[4].set(user,(String) "tEST");
        LOGGER.info(user);
    }

}
