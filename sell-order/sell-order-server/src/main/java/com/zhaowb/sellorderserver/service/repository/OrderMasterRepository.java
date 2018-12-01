package com.zhaowb.sellorderserver.service.repository;

import com.zhaowb.sellorderserver.service.entity.OrderMaster;
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
