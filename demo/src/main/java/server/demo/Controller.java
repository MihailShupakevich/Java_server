package server.demo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping
    public String index(@RequestParam("name") String name) {
        return "Hello World"+name;
    }
    @GetMapping("/full")
    public String full(@RequestParam("name") String name,
                       @RequestParam("surname") String surname) {
        return "Hello "+name+" "+surname;
    }
    @GetMapping("/{name}")
    public String name(@PathVariable String name) {
        return "Hello "+name;
    }

}
