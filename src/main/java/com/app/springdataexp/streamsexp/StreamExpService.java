package com.app.springdataexp.streamsexp;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StreamExpService {

    List<ParentData> parents;
    List<ChildData> children;
    List<ParentChildMapping> mappings;

    @PostConstruct
    public void prepareData() {
        parents = Arrays.asList(
                new ParentData(1, "p1"),
                new ParentData(2, "p2"),
                new ParentData(3, "p3"),
                new ParentData(4, "p4"),
                new ParentData(5, "p5"),
                new ParentData(6, "p6")
        );

        children = Arrays.asList(
                new ChildData(1, "c1"),
                new ChildData(2, "c2"),
                new ChildData(3, "c3"),
                new ChildData(4, "c4"),
                new ChildData(5, "c5"),
                new ChildData(6, "c6"),
                new ChildData(7, "c7"),
                new ChildData(8, "c8"),
                new ChildData(9, "c9"),
                new ChildData(10, "c10"),
                new ChildData(11, "c11"),
                new ChildData(12, "c12")
        );

        mappings = Arrays.asList(
                new ParentChildMapping(1, 1, 1),
                new ParentChildMapping(2, 1, 2),
                new ParentChildMapping(3, 1, 3),
                new ParentChildMapping(4, 2, 4),
                new ParentChildMapping(5, 3, 5),
                new ParentChildMapping(6, 4, 6),
                new ParentChildMapping(6, 4, 7),
                new ParentChildMapping(6, 4, 8),
                new ParentChildMapping(6, 5, 9),
                new ParentChildMapping(6, 5, 10),
                new ParentChildMapping(6, 6, 11),
                new ParentChildMapping(6, 6, 12)
        );
    }

    public void mapTest1() {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);
    }

    //get child by parentId
    //get list of childId from mapping using parentId
    //get list of child detail from children using list of childId
    public void getChildByParentId(int parentId) {
        List<Integer> childIdList = mappings.stream()
                .filter(map -> parentId == map.getParentId())
                .map(mappings -> mappings.getChildId())
                .collect(Collectors.toList());

        List<ChildData> childrenList = children.stream()
                .filter(c -> childIdList.contains(c.getId()))
                .collect(Collectors.toList());


        System.out.println("Parent: " + parentId + " Children: " + childrenList);
    }


}
