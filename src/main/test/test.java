import com.chenchen.service.MapService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/1/5.
 */
public class test {

    @Autowired
    private MapService mapService;

    @Test
    public void test(){
        mapService.test();
    }

}
