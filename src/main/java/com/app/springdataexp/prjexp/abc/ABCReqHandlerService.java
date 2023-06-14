package com.app.springdataexp.prjexp.abc;

import com.app.springdataexp.prjexp.BaseReqDto;
import com.app.springdataexp.prjexp.QcReqHandler;
import org.springframework.stereotype.Service;

@Service
public class ABCReqHandlerService implements QcReqHandler {

    @Override
    public void ownValidation(BaseReqDto baseReqDto) {
        ABCReqDto abcReqDto = (ABCReqDto) baseReqDto;

        System.out.println("OWN validation");
        System.out.println("REQ_ID: " + abcReqDto.getReqId());
        System.out.println("ANY_ID" + abcReqDto.getAnyId());
    }

    @Override
    public void persistData(BaseReqDto baseReqDto) {
        ABCReqDto abcReqDto = (ABCReqDto) baseReqDto;

        System.out.println("persist data");
        System.out.println("REQ_ID: " + abcReqDto.getReqId());
        System.out.println("ANY_ID" + abcReqDto.getAnyId());
    }
}
