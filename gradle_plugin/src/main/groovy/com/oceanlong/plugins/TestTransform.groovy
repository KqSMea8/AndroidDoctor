package com.oceanlong.plugins

import com.android.build.api.transform.Context
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformException
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformOutputProvider


class TestTransform extends Transform{

    @Override
    String getName() {
        return TestTransform.simpleName
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    @Override
    Set<QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }



    @Override
    void transform(Context context, Collection<TransformInput> collection, Collection<TransformInput> collection1, TransformOutputProvider transformOutputProvider, boolean b) throws IOException, TransformException, InterruptedException {
        System.out.println("==================")
        System.out.println("=======================================doPathTransform{ context=${context}, inputs=${inputs}, referencedInputs=${referencedInputs}, outputProvider=${outputProvider}, isIncremental=${isIncremental}")

    }
}