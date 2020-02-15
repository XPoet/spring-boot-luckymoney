package cn.itpoet.springbootluckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

// @Service ，Service注解
@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository luckymoneyRepository;


    /**
     * 事务，指的是数据库事务
     * 要么都成功，要么都失败
     * 实际开发案例：扣库存&&创建订单
     */
    @Transactional
    public void createTwoLuckymoney() {
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProducer("孙悟空");
        luckymoney1.setMoney(new BigDecimal("520"));

        // 写入数据库的操作
        luckymoneyRepository.save(luckymoney1);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("孙悟空");
        luckymoney2.setMoney(new BigDecimal("1314"));

        // 写入数据库的操作
        luckymoneyRepository.save(luckymoney2);

    }
}
