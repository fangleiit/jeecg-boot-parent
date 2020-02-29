package org.jeecg.fangyou.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试新的module
 * @author fanglei
 *
 */

@RestController
@RequestMapping("/test/jeecgDemo")
@Slf4j
public class HelloController {
    /**
     * hello World!
     * @return
     */
    @GetMapping(value="/hello")
    public Result<String> hello(){
        Result<String> result = new Result<String>();
        result.setResult("hello word!这是我的第一个测试项目前后端分离！");
        result.setSuccess(true);
        return result;
    }
}
