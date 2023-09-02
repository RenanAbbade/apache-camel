package com.in28minutes.microservices.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Router extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //queue (timer)
        //transformation
        //database (log)

        from("timer:first-timer") // antes do : é o nome da queue, após, o apelido
                .transform().constant("My Constant Message")
                .bean("getCurrentTimeBean")
                .to("log:first-timer");

    }
}


@Component
class GetCurrentTimeBean {
    public String getCurrentTime(){
        return "Time now is " + LocalDateTime.now();
    }
}