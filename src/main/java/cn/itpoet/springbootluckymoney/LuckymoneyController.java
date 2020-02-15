package cn.itpoet.springbootluckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    // 表示需要调用 LuckymoneyRepository
    @Autowired
    private LuckymoneyRepository repository;

    // 表示需要调用 LuckymoneyService
    @Autowired
    private LuckymoneyService luckymoneyService;

    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return repository.findAll();
    }

    /**
     * 创建红包（发红包）
     */
    @PostMapping("/create-luckymoney")
    public Luckymoney create(
            @RequestParam("producer") String producer,
            @RequestParam("money") BigDecimal money
    ) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }


    /**
     * 通过id查询红包
     */
    @GetMapping("/query-luckymoney/{id}")
    public Luckymoney findById(
            @PathVariable("id") Integer id
    ) {
        return repository.findById(id).orElse(null);
    }

    /**
     * 更新红包（领红包）
     */
    @PutMapping("/update-luckymoney/{id}")
    public Luckymoney update(
            @PathVariable("id") Integer id,
            @RequestParam("consumer") String consumer
    ) {

        Optional<Luckymoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }

    @PostMapping("/create-two-luckymoney")
    public void createTwoLuckymoney() {
        luckymoneyService.createTwoLuckymoney();
    }


}
