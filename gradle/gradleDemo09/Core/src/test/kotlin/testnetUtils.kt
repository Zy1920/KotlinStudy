import org.junit.Assert
import org.junit.Test
class testnetUtils{
    @Test
    fun testnetUtils(){
        var net=netUtils()
        var msg=net.sendRequest()
        Assert.assertEquals("hello",msg)
    }
}