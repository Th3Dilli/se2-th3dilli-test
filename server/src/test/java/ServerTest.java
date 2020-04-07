import org.junit.Assert;
import org.junit.Test;

public class ServerTest {
    @Test
    public void test(){
        Server s = new Server();
        Assert.assertEquals(2, s.sum(1,1));
    }
}
