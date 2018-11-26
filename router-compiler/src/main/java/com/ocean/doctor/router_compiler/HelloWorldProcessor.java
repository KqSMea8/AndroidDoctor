package com.ocean.doctor.router_compiler;

import com.google.auto.service.AutoService;
import com.ocean.doctor.router_annotation.DoctorInterface;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;



//@AutoService(Processor.class)  //自动注册
//@SupportedSourceVersion(SourceVersion.RELEASE_7) //指定java版本
//public class HelloWorldProcessor extends AbstractProcessor {
//
//
//    private Filer filer;
//    @Override
//    public synchronized void init(ProcessingEnvironment processingEnvironment) {
//        super.init(processingEnvironment);
//        filer = processingEnv.getFiler();
//    }
//
//    @Override
//    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
//
//        MethodSpec main = MethodSpec.methodBuilder("main")
//                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                .returns(void.class)
//                .addParameter(String[].class, "args")
//                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
//                .build();
//        // HelloWorld class
//        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
//                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                .addMethod(main)
//                .build();
//        try {
//            // build com.example.HelloWorld.java
//            JavaFile javaFile = JavaFile.builder("com.example", helloWorld)
//                    .addFileComment(" This codes are generated automatically. Do not modify!")
//                    .build();
//            // write to file
//            javaFile.writeTo(filer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        return Collections.singleton(DoctorInterface.class.getCanonicalName());
//    }
//
//    @Override
//    public SourceVersion getSupportedSourceVersion() {
//        return SourceVersion.latestSupported();
//    }
//}
