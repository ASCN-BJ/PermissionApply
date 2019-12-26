package com.bj.library_compiler

import com.bj.annotation.Apply
import com.bj.annotation.Denied
import com.bj.annotation.Granted
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

class PermissionProcessor : AbstractProcessor() {

    override fun init(p0: ProcessingEnvironment?) {
        super.init(p0)
        val mProcessingEnvironment = p0 ?: return
        //mProcessingEnvironment.getElementUtils(); 处理Element的工具类，用于获取程序的元素，例如包、类、方法。
        //mProcessingEnvironment.getTypeUtils(); 处理TypeMirror的工具类，用于取类信息
        //mProcessingEnvironment.getFiler(); 文件工具
        //mProcessingEnvironment.getMessager(); 错误处理工具
        //初始化的时候获取到当前扫描的对象
        //processingEnv是父类定义的ProcessingEnvironment对象，其实就是init方法回传过来的
//        mProcessingEnvironment = processingEnv.getElementUtils();
    }


    //指明哪些注解需要呗扫描到
    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        val set = LinkedHashSet<String>()
        set.add(Apply::class.java.canonicalName)
        set.add(Denied::class.java.canonicalName)
        set.add(Granted::class.java.canonicalName)
        return set
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun process(p0: MutableSet<out TypeElement>?, p1: RoundEnvironment?): Boolean {
        applyAnnotation(p0, p1)
        return true
    }

    private fun applyAnnotation(mTypeElements: MutableSet<out TypeElement>?, mRoundEnvironment: RoundEnvironment?) {
        mTypeElements ?: return; mRoundEnvironment ?: return

        val elements = mRoundEnvironment.getElementsAnnotatedWith(Apply::class.java)

        elements.forEach { el ->
            val childElement = el as TypeElement
        }
    }

    private fun deniedAnnotation() {

    }

    private fun grantedAnnotation() {

    }

}