package com.book.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.book.bookshop.entity.Address;
import com.book.bookshop.entity.CartVo;
import com.book.bookshop.entity.Order;
import com.book.bookshop.entity.User;
import com.book.bookshop.service.AddressService;
import com.book.bookshop.service.CartService;
import com.book.bookshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 @author：ZhouYao
 @create：2022-01-25 18:50
 订单控制器
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CartService cartService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderService orderService;

    /**
     * 确认订单
     */
    @RequestMapping("/confirm")
    public String confirm(String ids, HttpSession session, Model model) {
        // 查询记录
        List<CartVo> cartVos = cartService.findCartByIds(ids);
        model.addAttribute("list", cartVos);

        // 获取当前用户的收货地址
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        User user = (User) session.getAttribute("user");
        addressQueryWrapper.eq("user_id", user.getId());
        List<Address> addressList = addressService.list(addressQueryWrapper);
        model.addAttribute("addressList", addressList);

        // 将购买的商品信息添加到session中
        session.setAttribute("cartVos", cartVos);

        return "confirm_order";
    }

    /**
     * 提交订单
     */
    @RequestMapping("/commitOrder")
    public String commitOrder(Integer addrId, HttpSession session) {
        List<CartVo> cartVos = (List<CartVo>) session.getAttribute("cartVos");
        // 首先要生成订单表，然后要删除购物车中的记录
        String flag = orderService.buy(cartVos, addrId, session);
        if (flag.equals("success")) {
            //跳转至订单列表页
            return "redirect:/order/list";
        } else {
            return "redirect:/book/index";
        }
    }

    /**
     * 显示用户订单列表
     */
    @RequestMapping("/list")
    public String list(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderService.findUserOrder(user.getId());
        model.addAttribute("orders", orders);

        return "order_list";
    }


}




