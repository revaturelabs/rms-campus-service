package com.rms.aspect;

import com.rms.campus.Log4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectClass {

    @After("execution(* findById(..))")
    public void adviceMethodAfterFindById(JoinPoint jp) {
        Log4j.log.info("findById method in the Dao ran");
    }

    @After("execution(* findAll(..))")
    public void adviceMethodAfterFindAll(JoinPoint jp) {
        Log4j.log.info("findAll method in the Dao has been ran");
    }

    @After("execution(* insert(..))")
    public void adviceMethodAfterInsert(JoinPoint jp) {
        Log4j.log.info("insert method in the Dao has been ran");
    }

    @After("execution(* delete(..))")
    public void adviceMethodAfterDelete(JoinPoint jp) {
        Log4j.log.info("delete method in the Dao has been ran");
    }

    @After("execution(* update(..))")
    public void adviceMethodAfterUpdate(JoinPoint jp) {
        Log4j.log.info("update method in the Dao has been ran");
    }

    @After("execution(* findByName(..))")
    public void adviceMethodAfterFindByName(JoinPoint jp) {
        Log4j.log.info("findByName method in the Dao has been ran");
    }

    

}