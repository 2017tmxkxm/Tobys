package tobyspring.helloboot;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        if(name == null || name.trim().isEmpty()) throw new IllegalStateException();
        return helloService.sayHello(name);
    }

    @GetMapping("/count")
    public String count(@RequestParam("name") String name) {
        return name + " : " + helloService.countOf(name);
    }
}
