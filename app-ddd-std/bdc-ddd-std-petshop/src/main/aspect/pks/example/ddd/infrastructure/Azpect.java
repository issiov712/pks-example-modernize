import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;

/**
 * Testing of @AspectJ code style.
 * 
 * @author <a href="mailto:kaare.nilsen@gmail.com">Kaare Nilsen</a>
 */

@Aspect
public class Azpect
{
    @Around ("within(pks.example.ddd.core..*) && execution (* Pet.*(..))")
    public void trace()
    { 
        System.out.println("trace");
    }
    
}
