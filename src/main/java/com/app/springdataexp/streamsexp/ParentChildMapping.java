package com.app.springdataexp.streamsexp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParentChildMapping {
    private int id;
    private int parentId;
    private int childId;
}
