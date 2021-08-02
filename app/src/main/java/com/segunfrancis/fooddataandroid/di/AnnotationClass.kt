package com.segunfrancis.fooddataandroid.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IO

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class Main

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class Default