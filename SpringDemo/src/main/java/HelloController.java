import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zaloni on 4/19/2015.
 */

@Controller
@RequestMapping("/api/v1")
public class HelloController {
    @RequestMapping(value = {"/example2/{name}"},method = {},
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getValueDynamic(@PathVariable("name") String name){
        return  "Hello "+name;
    }
}
