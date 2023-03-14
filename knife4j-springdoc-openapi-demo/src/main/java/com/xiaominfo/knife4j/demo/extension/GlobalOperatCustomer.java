package com.xiaominfo.knife4j.demo.extension;

import io.swagger.v3.oas.models.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.GlobalOperationCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/3/14 22:37
 * @since:knife4j-springdoc-openapi-demo
 */
@Slf4j
@Component
public class GlobalOperatCustomer implements GlobalOperationCustomizer {

    private final static String CUSTOM_ANNOTATION_NAME="com.xiaominfo.knife4j.demo.config.TestBody";


    private static Class<?> annotationClazz;

    static {
        try {
           annotationClazz = Class.forName("com.xiaominfo.knife4j.demo.config.TestBody");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        log.info("operation.");
        Map<String,Object> extensions=new HashMap<>();
        List<String> params=new ArrayList<>();
        Parameter[] parameters = handlerMethod.getMethod().getParameters();
        if (parameters!=null&&parameters.length>0){
            for (Parameter parameter:parameters){
                Annotation[] annotations = parameter.getAnnotations();
                if (annotations!=null&&annotations.length>0){
                    long count=Arrays.asList(annotations).stream().filter(annotation -> annotation.annotationType().getName().equalsIgnoreCase(CUSTOM_ANNOTATION_NAME)).count();
                    if (count>0){
                        log.info("paramName:{}",parameter.getName());
                        params.add(parameter.getName());
                    }
                }
            }
        }
        if (!params.isEmpty()){
            extensions.put(handlerMethod.getMethod().getName()+"Req",params);
            operation.addExtension("x-orangeforms",extensions);
        }
        return operation;
    }
}
