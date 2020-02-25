package cn.itpoet.springbootluckymoney;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

// 注解 @RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/hello") // 在所有接口加上前缀 hello
/*
// spring-boot-starter-thymeleaf 模板渲染使用该注解
@Controller
*/
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
    // @GetMapping("/hello")
    @GetMapping({"/hello", "hi"}) // @GetMapping()注解，可传入数组，不同接口，返回同一内容
    public String say() {
        return "😺O(∩_∩)O哈哈~";
    }

    @GetMapping("/say1")
    public String say1() {
        return "描述：" + limitConfig.getDescription();
        /*
        // spring-boot-starter-thymeleaf 模板渲染，返回HTML文件
        return "index";
        */
    }

    /* @PostMapping POST请求 */
    @PostMapping("/say2")
    public String say2() {
        return limitConfig.getDescription();
    }

    /* @RequestMapping  支持GET、PUT、POST。。。请求 */
    @RequestMapping("/say3")
    public String say3() {
        return limitConfig.getDescription();
    }

    /* @GetMapping GET请求，在URL中传递参数 /say4/1 */
    @GetMapping("/say4/{id}")
    public String say4(@PathVariable("id") Integer id) {
        return "URL传递过来的参数：" + id;
    }

    /* @GetMapping GET请求，在URL中传递参数 /say5?id=1  */
    @GetMapping("/say5")
    public String say5(@RequestParam(value = "id") Integer id) {
        return "使用GET请求，URL传递过来的参数：" + id;
    }

    /* @GetMapping GET请求，在URL中传递参数 /say5?id=1  */
    // 设置id为非必传，默认值为0
    @GetMapping("/say6")
    public String say6(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "使用GET请求，URL传递过来的参数：" + id;
    }

    /* @PostMapping POST请求，在URL中传递参数 */
    // 建议实际开发中使用该种方式，参数放到body里面
    @PostMapping("/say7")
    public String say7(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "使用POST请求，URL传递过来的参数：" + id;
    }

    /**
     * 传入参数
     * http://localhost:8888/luckymoney/hello/say8?name="猪八戒"
     */
    @RequestMapping("/say8")
    public String say8(String name) {
        return "hi " + name;
    }
}
