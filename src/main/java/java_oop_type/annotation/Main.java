package java_oop_type.annotation;



import java.lang.reflect.*;
import java.util.Arrays;



/**
 * Description of class.
 */
public class Main {

  public static void main(String[] args)  {	 
	  SecretClass reflectedClass = new SecretClass();

      	try {
			Arrays.asList(Class.forName("java_oop_type.annotation.SecretClass").getDeclaredMethods())
			.stream()
			.filter(method ->  method.isAnnotationPresent(PublicCall.class) 
			          && Modifier.isPrivate(method.getModifiers()))
			.forEach(method -> {
				method.setAccessible(true);
				int countOfExecute = method.getAnnotation(PublicCall.class).value();
				for(int i = 0; i < countOfExecute; ++i) {
					try {
						method.invoke(reflectedClass);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
  }
}
