package com.dh.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author Administrator
 */
@Configuration
public class SchedulerConfig {
    @Bean("startQuartz")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger [] jobTrigger){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setOverwriteExistingJobs(true);
        bean.setStartupDelay(10);
        bean.setTriggers(jobTrigger);
        return bean;
    }

    @Bean(name ="zodiacJob")
    public ZodiacJob getZodiacJob(){
        return new ZodiacJob();
    }

    @Bean(name ="zodiacJobDetail")
    public MethodInvokingJobDetailFactoryBean invokingJobDetailFactoryBean(@Qualifier("zodiacJob") ZodiacJob task){
        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean=new MethodInvokingJobDetailFactoryBean();
        jobDetailFactoryBean.setTargetObject(task);
        jobDetailFactoryBean.setTargetMethod("work");
        return jobDetailFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(@Qualifier("zodiacJobDetail") MethodInvokingJobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
        triggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        triggerFactoryBean.setName("zodiacTrigger");
        triggerFactoryBean.setCronExpression("*/5 * * * * ?");
        return triggerFactoryBean;
    }
}
