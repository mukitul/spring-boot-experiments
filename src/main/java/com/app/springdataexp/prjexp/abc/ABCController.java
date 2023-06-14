package com.app.springdataexp.prjexp.abc;

import com.app.springdataexp.prjexp.QcReqProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abc")
public class ABCController {
    private final QcReqProcessor processor;

    @PostMapping("/api")
    public String anyReq(@RequestBody ABCReqDto abcReqDto) {
        processor.process(abcReqDto, new ABCReqHandlerService());
        return "DONE";
    }
}
