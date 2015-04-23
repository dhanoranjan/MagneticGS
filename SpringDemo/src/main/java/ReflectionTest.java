import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by zaloni on 4/19/2015.
 */
public class ReflectionTest {
    public static void main(String[] args){
        Class<?> myClass = HelloController.class;

        Annotation[] annotations = myClass.getDeclaredAnnotations();
        for(Annotation annotation: annotations){
            if(annotation instanceof RequestMapping){
                RequestMapping requestMapping = (RequestMapping) annotation;
                String[] path = requestMapping.value();
                System.out.println(path[0]);
            }
        }

        Method[] methods = myClass.getDeclaredMethods();
        for(Method method:methods){
            System.out.println("Method Name: "+method.getName());
            System.out.println("\t Return Type: "+method.getReturnType());
            Annotation[] annotations1 = method.getDeclaredAnnotations();
            for(Annotation annotation:annotations1){
                if(annotation instanceof RequestMapping) {
                    RequestMapping requestMapping = (RequestMapping) annotation;
                    for(RequestMethod requestMethod:requestMapping.method()){
                        System.out.println(requestMethod.name());
                    }
                    String[] path = requestMapping.value();
                    System.out.println(path[0]);
                }
            }

        }


    }
}
