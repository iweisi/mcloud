package org.blackc.blog.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.blackc.blog.user.entity.User;
import org.blackc.data.entity.TemporalEntity;

/**
 * @author heyx
 */
@Getter
@Setter
@Entity
@Table(name = "blog_category")
public class Category extends TemporalEntity {

    private String name;
    @Column(nullable = false)
    private Integer sort;
    @ManyToOne
    private User user;

}
