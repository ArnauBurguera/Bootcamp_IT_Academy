package cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t01.n02.S04T01N02BurgueraCallesArnau.controllers;

import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld")
    public String saluda(@RequestParam(defaultValue = "UNKNOWN") String nom){
        return "Hola, " + nom + ". Estàs executant un projecte Gradle.";
    }
    @GetMapping("/HelloWorld2")
    public String saluda2(@PathVariable(required = false) String nom){
        return "Hola, " + nom + ". Estàs executant un projecte Gradle.";
    }
}

/*RECURSOS:
https://www.baeldung.com/spring-request-param
https://www.baeldung.com/spring-optional-path-variables
https://www.baeldung.com/spring-requestparam-vs-pathvariable
 */
