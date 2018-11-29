package com.zhaowb.sellorderserver.repository;

import com.zhaowb.sellorderserver.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/29 17:38
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
