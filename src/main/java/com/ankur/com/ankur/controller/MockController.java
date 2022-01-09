package com.ankur.com.ankur.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
@RequestMapping("/mock")
@Slf4j
public class MockController {

    private static final Resource studentRequest = new ClassPathResource("RequestStudent.json");
    private static final Resource studentResponse = new ClassPathResource("ResponseStudent.json");

    @Autowired
    ObjectMapper mapper;

    @GetMapping(path = {"/v1/student"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getStudentData( @RequestParam(name = "pageSize", required = false, defaultValue = "0") int pageSize,
                                  @RequestParam(name = "pageNumber", required = false, defaultValue = "1") int pageNumber) throws InterruptedException, IOException {
        log.info("calling get Student");
        if(pageNumber >=2 ){
            return null;
        }
        Thread.sleep(400);
        return getJsonResponse("getStudent");
    }

    @PostMapping(path = {"/v1/student/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object postStudentData(@PathVariable("id") String id) throws InterruptedException, IOException {
        log.info("calling post Student");
        Thread.sleep(400);
        return getJsonResponse("postStudent");
    }


    private Object getJsonResponse(String api) throws IOException {

        Resource resource = null;

        if (api.equalsIgnoreCase("getStudent")) {
            resource = studentRequest;
        } else if (api.equalsIgnoreCase("postStudent")) {
            resource = studentResponse;
        }

        return mapper.readValue(resource.getInputStream(), Object.class);
    }
}
