package Player;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class PlayerController {
    @GetMapping(value = "/player")
    @ResponseBody
    public String getMessage() {
        return "Hello there";
    }

    @GetMapping("/test")
    public String test() {
        return "Test success!";
    }

}