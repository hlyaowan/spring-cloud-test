package com.demo.common.secondary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by apple on 2018/1/12.
 * 实体对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stest", schema = "test2")
@DynamicUpdate
@DynamicInsert
public class Stest implements Serializable {
    /**
     * 主键，自增
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 内容
     */
    @Column(name = "content")
    private String content;
}
