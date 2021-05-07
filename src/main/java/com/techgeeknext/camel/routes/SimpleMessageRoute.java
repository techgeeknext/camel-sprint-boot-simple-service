package com.techgeeknext.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //generates an event/constant message every 60 seconds
        from("timer:active-mq-timer?period=60000")
                .transform().constant("Hello Message from Apache Camel - TechGeekNext")
                .log("${body}");
                //in next example, will consume this message from ActiveMQ queue
               // .to("activemq:my-activemq-queue");
    }
}