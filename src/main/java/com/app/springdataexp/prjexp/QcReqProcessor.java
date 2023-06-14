package com.app.springdataexp.prjexp;

import org.springframework.stereotype.Service;

@Service
public class QcReqProcessor {
    public void process(BaseReqDto baseReqDto, QcReqHandler qcReqHandler) {
        qcReqHandler.doBasicValidation(baseReqDto);
        qcReqHandler.ownValidation(baseReqDto);
        qcReqHandler.persistData(baseReqDto);
    }
}
