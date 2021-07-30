package club.csiqu.learn.basis.feature.stream.trader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Siqu Chen 2021/7/30
 * @since 1.0
 */
public class TraderApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraderApplication.class);

    public static final String CAMBRIDGE = "Cambridge";

    public static final String MILAN = "Milan";

    public static void main(String[] args) {
        // init data
        Trader raoul = new Trader("Raoul", CAMBRIDGE);
        Trader mario = new Trader("Mario", MILAN);
        Trader alan = new Trader("Alan", CAMBRIDGE);
        Trader brian = new Trader("Brian", CAMBRIDGE);
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1、找出2011年发生的所有交易，并按交易额排序（从低到高）
        List<Transaction> transactionsFor2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        LOGGER.info("2011 transaction: {}", transactionsFor2011);
        // 2、交易员都在那些不同的城市工作过
        Set<String> city = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        LOGGER.info("Trader city: {}", city);
        // 3、查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> CAMBRIDGE.equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getCity))
                .collect(Collectors.toList());
        LOGGER.info("Trader for Cambridge: {}", traders);
        // 4、返回所有交易员的姓名字符串，按字母顺序排序
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        LOGGER.info("Trader name: {}", names);
        // 5、有没有交易员是在米兰工作的
        boolean traderInMario = transactions.stream()
                .anyMatch(transaction -> MILAN.equals(transaction.getTrader().getCity()));
        LOGGER.info("Trader in Milan：{}", traderInMario);
        // 6、打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(transaction -> CAMBRIDGE.equals(transaction.getTrader().getCity()))
                .forEach(transaction -> LOGGER.info("Transaction value：{}", transaction.getValue()));
        // 7、所有交易中，最高的交易额是多少
        Optional<Transaction> max = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));
        max.ifPresent(transaction -> LOGGER.info("Max :{}", transaction.getValue()));
        // 8、找到交易额最小的交易
        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        min.ifPresent(transaction -> LOGGER.info("Min :{}", transaction.getValue()));
    }
}
