package br.com.fiap.minfin.eip.CamelDemo.routes;

import org.apache.camel.builder.RouteBuilder;

public class OrderProcessingFlow extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        /* == Message Channel Principal == */

        from("seda:newOrdersFlow")
                .routeId("OrderProcessingFlow")
            .log("[new Order Received] ${body}")

                /* == Publish - Subscribe Channel == */
                .multicast()
                .parallelProcessing()
                .to("direct:validatingPipe", "direct:monitoringTap");

        from("direct:validationPipe")
            .log("Format OK?: ${body}")
            .to("direct:checkFormat")
            .to("direct:checkAmount");

        /* Filter 1: Valid Format */

        from("direct:checkFormat")
            .filter(simple("${body} contains 'Order-'"))
                .log("Format OK: ${body}")
            .to("seda:validOrders")
            .end();

        /* Filter 2: Value of the Order */
        from("direct:checkAmount")
            .filter(simple("${body} regex '.*amount=[5-9][0-9][0-9].*'"))
                .log("High Value Order: ${body}")
            .to("seda:highValueOrders")
            .end();

        from("seda:validOrders")
            .filter(body().contains("amount="))
                    .log("Forwarding to Valid Order: ${body}")
            .to("seda:routerInput");
        
    }
}
