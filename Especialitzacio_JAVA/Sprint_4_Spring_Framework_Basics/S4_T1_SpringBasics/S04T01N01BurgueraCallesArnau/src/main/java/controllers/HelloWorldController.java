package cat.itacademy.barcelonactiva.burgueracalles.arnau.s04.t01.n01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld")//li diu que ha de ser una Get request
    public String saluda(@RequestParam(defaultValue = "UNKNOWN") String nom){//diu que el valor per defecte és "UNKNOWN"
        return "Hola, " + nom + ". Estàs executant un projecte Maven.";
    }
    @GetMapping("/HelloWorld2")
    public String saluda2(@PathVariable(required = false) String nom){
        return "Hola, " + nom + ". Estàs executant un projecte Maven.";
    }
}

/*RECURSOS:
https://www.baeldung.com/spring-request-param
https://www.baeldung.com/spring-optional-path-variables
https://www.baeldung.com/spring-requestparam-vs-pathvariable
 */