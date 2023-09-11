package com.example.reactive.reactive_project_1.exception.custom;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.HashMap;
import java.util.Map;

public class CustomAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Throwable throwable = super.getError(request);
        return buildErrorAttributes(throwable);
    }

    private Map<String, Object> buildErrorAttributes(Throwable throwable) {
        Map<String, Object> errorAttributes = new HashMap<>();

        if (throwable instanceof CustomException customException) {
            errorAttributes.put("status", String.valueOf(customException.getStatus().value()));
            errorAttributes.put("message", customException.getMessage());
        }

        return errorAttributes;
    }
}
