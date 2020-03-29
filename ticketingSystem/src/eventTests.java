import org.junit.jupiter.api.Test;

public class eventTests extends Backend{


    @Test
    public void shouldGetEventName(){
        String name = "billy idol         admin           100 001.00";
        tickets.add(name);
        Backend.getEventNames();
        System.out.println(Backend.eventNames);
    }


}
