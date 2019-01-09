#include <jni.h>
#include <string>

extern "C"{



jstring stringFromJNI(JNIEnv *env, jobject thiz){
    std::string hello = "Hello from C++231";
    return env->NewStringUTF(hello.c_str());
}

static const JNINativeMethod gMethods[] = {
        {"stringFromJNI", "()Ljava/lang/String;", (jstring*)stringFromJNI}
};

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved){

    JNIEnv* env = NULL;
    if(vm->GetEnv((void**)&env, JNI_VERSION_1_4) != JNI_OK) //从JavaVM获取JNIEnv，一般使用1.4的版本
        return -1;
    jclass clazz = env->FindClass("com/example/oceanlong/sotestlib/SoTestLoader");
    if (!clazz){
        return -1;
    }
    if(env->RegisterNatives(clazz, gMethods, sizeof(gMethods)/sizeof(gMethods[0])))
    {
        return -1;
    }
    return JNI_VERSION_1_4;
}



}

