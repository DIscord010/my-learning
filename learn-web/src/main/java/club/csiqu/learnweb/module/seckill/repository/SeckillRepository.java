package club.csiqu.learnweb.module.seckill.repository;


import club.csiqu.learnweb.module.seckill.model.entity.Seckill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/30 15:23
 */
public interface SeckillRepository extends JpaRepository<Seckill, Long> {

    /**
     * 根据秒杀信息 ID查询秒杀的库存数量
     *
     * @param seckillId ID
     * @return 剩余库存
     */
    @Query(value = "select number from seckill where seckill_Id = ?1", nativeQuery = true)
    Integer getNumberById(long seckillId);
}