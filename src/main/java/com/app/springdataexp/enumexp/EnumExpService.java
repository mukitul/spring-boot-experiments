package com.app.springdataexp.enumexp;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnumExpService {
    private final EnumExpRepository enumExpRepository;
    private final ModelMapper modelMapper;

    public void enumExpMethod(ExpModelRequest expModel) {
        if (StudentType.REGULAR.equals(expModel.getStudentType())) {
            System.out.println("StudentType.REGULAR");
        }

        if (StudentType.REGULAR == expModel.getStudentType()) {
            System.out.println("StudentType.REGULAR");
        }

        if (CategoryType.CATEGORY_ONE.equals(expModel.getCategoryType())) {
            System.out.println("CategoryType.CATEGORY_ONE");
        }

        if (CategoryType.CATEGORY_TWO == expModel.getCategoryType()) {
            System.out.println("CategoryType.CATEGORY_TWO");
        }
        EnumData enumData = new EnumData();
        modelMapper.map(expModel, enumData);
        enumExpRepository.save(enumData);
    }

    public List<EnumData> getAll() {
        return enumExpRepository.findAll();
    }
}
