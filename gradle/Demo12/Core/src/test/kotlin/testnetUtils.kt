import org.junit.Assert
import org.junit.Test

class testnetUtils {
    @Test
    fun testSendRequest(){
        var utils=netUtils()
        var msg=utils.sendRequest()
        Assert.assertEquals("hello",msg)
    }
}