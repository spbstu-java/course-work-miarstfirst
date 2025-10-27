package Lab2;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;


public class Main2 {
    public void run(Object object, TextSetter setText ){
        Method[] methods = object.getClass().getDeclaredMethods();

        for (Method method: methods) {
            if (
                method.isAnnotationPresent(TestAnnotation.class) &&
                !Modifier.isPublic(method.getModifiers())
            ) {
                TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
                int value = annotation.value();

                method.setAccessible(true);

                Class<?>[] paramTypes = method.getParameterTypes();
                Object[] params = new Object[paramTypes.length];

                for (int i = 0; i < paramTypes.length; i++) {
                    if (paramTypes[i] == String.class) {
                        params[i] = "Test str" + (i + 1);
                    };
                    if (paramTypes[i] == double.class) {
                        params[i] = 0.1 + i + 1;

                    };
                    if (paramTypes[i] == int.class) {
                        params[i] = i + 1;
                    };
                }

                try {
                    for (int i = 0; i < value; i++) {
                        setText.set((String) method.invoke(object, params));
                    }
                } catch (IllegalAccessException | InvocationTargetException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
