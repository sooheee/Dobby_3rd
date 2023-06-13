package com.dobby.project.order.service;

import com.dobby.project.cart.dto.CartDto;
import com.dobby.project.cart.dto.CartProdDto;
import com.dobby.project.order.dto.OrdProdDto;
import com.dobby.project.order.dto.PointDto;
import com.dobby.project.order.dao.OrderDao;
import com.dobby.project.order.dto.DlvDto;
import com.dobby.project.order.dto.DlvpnLogDto;
import com.dobby.project.order.dto.MbrDto;
import com.dobby.project.order.dto.OrdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public List<CartDto> selectCartOrder(List<Integer> cartIdList) {
           return orderDao.selectCartOrder(cartIdList);
    }

    @Override
    public MbrDto getMbrInfoById(String mbrId) {
        return orderDao.selectMbrIdInfo(mbrId);
    }

    @Override
    public List<DlvDto> getAddressByMbrId(String mbrId) {
        return orderDao.selectAddressByMbrId(mbrId);
    }

    @Override
    public DlvDto getAddressDlvId(Integer dlvNmId) {
        return orderDao.selectAddressByDlvId(dlvNmId);
    }
    @Override
    public int insertOrdInfo(OrdDto ordDto) {
        return orderDao.insertOrdInfo(ordDto);
    }


    @Override
    public int insertOrderProd(OrdProdDto ordProdDto) {
        return orderDao.insertOrderProd(ordProdDto);
    }

    @Override
    public int insertDlvLog(DlvpnLogDto dPDto) {
        return orderDao.insertDlvLog(dPDto);
    }

    @Override
    public int updateDlvDefault(String mbrId, Integer dlvpnId) {
        return orderDao.updateDlvDefault(mbrId,dlvpnId);

    }

    @Override
    public void deleteCart(List<Integer> delCartIds) {
            orderDao.deleteCart(delCartIds);

    }

    @Override
    public int insertPoint(PointDto pd) {
        return orderDao.insertPoint(pd);
    }

    @Override
    public List<CartProdDto> getProdInfo(int productId) {
        return orderDao.selectProdInfo(productId);
    }


}
