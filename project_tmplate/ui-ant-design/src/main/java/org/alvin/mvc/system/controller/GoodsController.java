package org.alvin.mvc.system.controller;

import org.alvin.mvc.system.domain.Goods;
import org.alvin.mvc.system.security.ScopeUser;
import org.alvin.mvc.system.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by tangzhichao on 2016/12/8.
 */
@RestController
@RequestMapping("/gooods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasPermission(null, 'MngProject',null)")
    public Page<Goods> list(@PageableDefault(size = 20, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return goodsService.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasPermission(null, 'MngProject',null)")
    public void add(@CookieValue("id") int id, Goods goods, Principal principal) {
        ScopeUser user = (ScopeUser) ((AbstractAuthenticationToken) principal).getPrincipal();
        System.out.println(user);
    }
}
