package cucumberTests;
 
import org.junit.runner.RunWith; 
import cucumber.junit.Cucumber; 

@RunWith(Cucumber.class) 
@Cucumber.Options(
	format = {"pretty", "html:target/cucumber"}
    //features = {"classpah", "cucumberJava.feature"}
) 
public class runTest { }