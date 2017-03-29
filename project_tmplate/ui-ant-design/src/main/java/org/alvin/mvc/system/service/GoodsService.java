package org.alvin.mvc.system.service;

import org.alvin.mvc.system.domain.Goods;
import org.alvin.mvc.system.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tangzhichao on 2016/12/8.
 */
@Service
@Transactional(readOnly = true)
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;


    public Page<Goods> findAll(Pageable pageable) {
        return this.goodsRepository.findAll(pageable);
    }
}
