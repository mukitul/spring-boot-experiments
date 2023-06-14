package com.app.springdataexp.prjexp;

import org.apache.commons.lang3.StringUtils;

public interface QcReqValidator {
    default void doBasicValidation(BaseReqDto baseReqDto) {
        if (StringUtils.isEmpty(baseReqDto.getReqId())) {
            throw new RuntimeException("req id not found");
        }
        if (StringUtils.isEmpty(baseReqDto.getProcessName())) {
            throw new RuntimeException("process name not found");
        }
    }

    void ownValidation(BaseReqDto baseReqDto);
}
