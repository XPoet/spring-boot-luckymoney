package cn.itpoet.springbootluckymoney;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

// @Controller + @ResponseBody = @RestController
@RestController
public class HelloController {

    /* 载入配置文件里面的数据方法1：适用于较少配置项 */
    /*
    @Value("${minMoney}")
    private BigDecimal minMoney;

    // 载入配置文件里面的数据
    @Value("${description}")
    private String desc;
    */

    /* 载入配置文件里面的数据方法2：当需要载入多个配置文件数据时，采用此方法，简便很多 */
    @Autowired
    private LimitConfig limitConfig;

    /* @GetMapping GET请求 */
    // 旧版写法 @RequestMapping(value = "/hello", method = RequestMethod.GET)
    // 等同于新版写法 @GetMapping("/hello")
    @GetMapping("/say")
    public String say() {
        return "描述：" + limitConfig.getDescription();
    }
}
