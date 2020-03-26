import org.junit.Assert;
import org.junit.Test;



public class transactionsTest {


    @Test
    public void shouldReadFiles(){

        static ArrayList<String> tickets = new ArrayList<String>();
        String event = "billy idol         admin           100 001.00";
        String eventName = "billh idol";
        tickets.add(event);
        Assert.assertTrue(Backend.getEventNames().equals(eventName));

    }
}
