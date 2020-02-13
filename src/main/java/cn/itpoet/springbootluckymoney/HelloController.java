package cn.itpoet.springbootluckymoney;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /* @GetMapping GET请求 */
    // 旧版写法 @RequestMapping(value = "/hello", method = RequestMethod.GET)
    // 等同于新版写法 @GetMapping("/hello")
    @GetMapping("/hello")
    public String say() {
        return "O(∩_∩)O哈哈~";
    }


}
