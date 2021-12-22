package com.app.springdataexp.redisexp;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@RedisHash(value = "EMPLOYEE")
public class Employee implements Serializable {

    @Id
    private String id;
    private String empName;
    private Double empSalary;
}
