package com.app.springdataexp.enumexp;

import org.springframework.stereotype.Service;

@Service
public class EnumExpService {
    public void EnumExpMethod(ExpModel expModel) {
        if (StudentType.REGULAR.equals(expModel.getStudentType())) {
            System.out.println("StudentType.REGULAR");
        }

        if (StudentType.REGULAR == expModel.getStudentType()) {
            System.out.println("StudentType.REGULAR");
        }

        if (CategoryType.CATEGORY_ONE.equals(expModel.getCategoryType())) {
            System.out.println("CategoryType.CATEGORY_ONE");
        }

        if (CategoryType.CATEGORY_ONE == expModel.getCategoryType()) {
            System.out.println("CategoryType.CATEGORY_ONE");
        }
    }
}
