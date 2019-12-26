package com.bj.annotation
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class Apply(val permission: Array<String>)