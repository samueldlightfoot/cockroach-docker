package dev.lightfoot.kerberospostgresclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SomeController {

    @GetMapping("/getBool")
    public Mono<Boolean> getBool() {
        return Mono.just(true);
    }

}
