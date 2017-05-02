package com.dreamidea;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * greeting db
 * @author stillChina
 */
public class GreetingDB {

    public static Cache<String, Greeting> greet = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build();

}
