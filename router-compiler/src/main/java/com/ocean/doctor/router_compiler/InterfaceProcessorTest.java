package com.ocean.doctor.router_compiler;

import com.google.auto.service.AutoService;
import com.ocean.doctor.router_annotation.DoctorInterface;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;



@AutoService(Processor.class)  //自动注册
@SupportedSourceVersion(SourceVersion.RELEASE_7) //指定java版本
public class InterfaceProcessorTest extends AbstractProcessor {
    private Filer filer;
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filer = processingEnv.getFiler();
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {



            // todo @oceanlong for test

            for (TypeElement annotation : annotations) {
                // annotation simpleName
                String simpleName = annotation.getSimpleName().toString();
               if (simpleName.equals("DoctorInterface")){
                   Set<? extends Element> classSet = roundEnvironment.getElementsAnnotatedWith(annotation);
                   for (Element element : classSet){
                       if (element.getKind() == ElementKind.CLASS){
                           StringBuilder extraComment = new StringBuilder();
                           String clzName = element.getSimpleName().toString();
                           extraComment.append(" clz name : ").append(clzName).append("\n");

                           createClass("com.example.oceanlong.androiddoctorcore.plugins", (TypeElement) element, extraComment.toString());
                       }

                   }
               }


            }

            // --------- test end ----------


        return true;
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(DoctorInterface.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }


    /**
     * @param packageName
     * @param clazz
     * @param extraComment
     */
    private void createClass(String packageName , TypeElement clazz , String extraComment){
        // create init & destroy
        MethodSpec initMethod = MethodSpec.methodBuilder("init")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .build();

        MethodSpec destroyMethod = MethodSpec.methodBuilder("destroy")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .build();


        // create interface type
        ClassName interfaceName = ClassName.get(packageName, "IPlugin");
        TypeSpec cls = TypeSpec.classBuilder(clazz.getSimpleName().toString() + "Impl")
                .addModifiers(Modifier.PUBLIC , Modifier.FINAL)
                .addMethod(initMethod)
                .addMethod(destroyMethod)
                .addSuperinterface(interfaceName)
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, cls)
                .addFileComment(extraComment)
                .addFileComment(" This codes are generated automatically. Do not modify!")
                .build();
        // write to file
        try {
            javaFile.writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
