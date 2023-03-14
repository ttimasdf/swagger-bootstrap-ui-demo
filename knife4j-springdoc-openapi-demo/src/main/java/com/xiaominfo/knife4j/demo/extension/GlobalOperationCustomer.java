package com.xiaominfo.knife4j.demo.extension;

import com.xiaominfo.knife4j.demo.config.TestBody;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.parameters.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.GlobalOperationCustomizer;
import org.springdoc.core.customizers.ParameterCustomizer;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/3/14 16:10
 * @since:knife4j-springdoc-openapi-demo
 */
@Slf4j
@Component
public class GlobalOperationCustomer implements ParameterCustomizer {



    @Override
    public Parameter customize(Parameter parameterModel, MethodParameter methodParameter) {
        if (methodParameter.getMethod().getName().equals("fileModule")){
            log.info("method:{},paramName:{}",methodParameter.getMethod().getName(),methodParameter.getParameterName());
            log.info("parameterModel:{}",parameterModel);
            if (parameterModel!=null){
                parameterModel.addExtension("x-body",true);
            }
        }
        TestBody testBody=methodParameter.getParameterAnnotation(TestBody.class);
        if (testBody!=null){
            log.info("method:{},paramName:{}",methodParameter.getMethod().getName(),methodParameter.getParameterName());
            log.info("parameterModel:{}",parameterModel);
            if (parameterModel==null){
                parameterModel=new Parameter();
                parameterModel.setRequired(true);
                parameterModel.set$ref("#/components/schemas/"+methodParameter.getParameterType().getSimpleName());
                parameterModel.setName(methodParameter.getParameterName());
                parameterModel.addExtension("x-body",true);
            }
        }
        return parameterModel;
    }
}
