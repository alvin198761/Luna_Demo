package org.alvin.mvc.system.repository;

import org.alvin.mvc.system.domain.Goods;
import org.springframework.stereotype.Repository;

/**
 * Created by tangzhichao on 2016/12/8.
 */
@Repository
public interface GoodsRepository extends SpecificationRepository<Goods, Long> {
}
