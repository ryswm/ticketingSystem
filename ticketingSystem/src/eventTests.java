import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;


public class eventTests extends Backend{


    @Test
    public void shouldGetEventName(){
        String name = "billy idol         admin           100 001.00";
        String nameTrue = "billy idol";
        tickets.add(name);
        Backend.getEventNames();
        assertTrue(Backend.eventNames.contains(nameTrue));
    }


}
