package club.csiqu.learnweb.module.seckill.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/30 14:56
 */
@Entity
@Table(name = "seckill")
@Data
@ToString
public class Seckill implements Serializable {

    private static final long serialVersionUID = -8624315407296696523L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seckill_id", nullable = false)
    private Long seckillId;

    private String name;

    private Integer number;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Integer version;

}