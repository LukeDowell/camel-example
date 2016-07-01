# Camel Dynamic Load Balancing Example

This application is a proof of concept for dynamic load balancing between services using Apache Camel.

## Structure

In the com.example.config.CamelConfiguration class you will find an ExampleApi bean and a WeightedLoadBalancer bean. The ExampleApi
bean sets up a Proxy with camel so that whenever ExampleApi.action is called, it will hit the "direct:someName" endpoint. This
is then routed to either SomeLoggingService or AnotherLoggingService based on ratios provided by RatioService.


## Usage

Users can make a GET and a POST request to localhost:8080/. The GET request simply activates whatever logging service is
'on deck', while the POST accepts two query parameters (index and ratio) which changes the ratios in RatioService. This
 will change the way the WeightedLoadBalancer distributes load between the two logging services at runtime.
