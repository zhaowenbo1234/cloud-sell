package com.zhaowb.sellorderserver.service.repository;

import com.zhaowb.sellorderserver.service.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/29 17:37
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
