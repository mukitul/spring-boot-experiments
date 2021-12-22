package com.app.springdataexp.redisexp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisRepository redisRepository;

    public void saveInfo() {
        Employee emp = new Employee();
        emp.setId("1");
        emp.setEmpName("EMP-1");
        emp.setEmpSalary(100000.0);

        redisRepository.save(emp);
    }
}
