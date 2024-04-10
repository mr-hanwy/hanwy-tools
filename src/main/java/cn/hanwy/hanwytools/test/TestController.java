package cn.hanwy.hanwytools.test;

import cn.hanwy.hanwytools.basic.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author hanwy
 * @date 2024/4/9
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/testLog/{param}")
    @Log(methodDescription = "测试日志切面功能")
    public String testLog(@PathVariable("param") String param) {
        return param;
    }
}