package com.example.service;

import com.example.SomePayload;
import org.apache.camel.Body;
import org.apache.camel.Header;

/**
 * Created by ldowell on 7/1/16.
 */
public interface ExampleApi {

    SomePayload action(@Body SomePayload somePayload, @Header("message") String farewell);
}
