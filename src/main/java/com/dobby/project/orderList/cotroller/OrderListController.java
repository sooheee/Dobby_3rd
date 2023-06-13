package com.dobby.project.orderList.cotroller;

import com.dobby.project.order.dto.OrdDto;
import com.dobby.project.order.dto.OrdProdDto;
import com.dobby.project.orderList.dto.OrdProdInfoDto;
import com.dobby.project.orderList.service.OrderListService;
import com.dobby.project.orderList.dto.ProdCntDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class OrderListController {

    @Autowired
    private OrderListService orderListService;

 @GetMapping("/order/list")
 public String orderList(HttpServletRequest req, Model m) {
     
     //주문테이블에서 주문일자, 주문번호, 주문상태 가져오기
     HttpSession session = req.getSession();

     String mbrId = (String) session.getAttribute("MBR_ID");
//     System.out.println("mbrId = " + mbrId);
     List<OrdDto> ordDto = orderListService.getOrdInfo(mbrId);

//     System.out.println("ordDto = " + ordDto);

     m.addAttribute("ordDto",ordDto);

//
     //첫번째 상품명 + 상품목록 개수 불러오기
//     for (OrdDto dto : ordDto) {
//         String ordId = dto.getORD_ID();
//         System.out.println("주문번호"+ordId );
//         List<OrdProdDto> ordProdDto = orderListService.getProdNm(ordId);
//         List<ProdCntDto> pcDto = (List<ProdCntDto>) orderListService.getProdCnt(mbrId,ordId);
//         System.out.println("주문상품: " + ordProdDto);
//         System.out.println("상품cnT: " + pcDto);
//        m.addAttribute("ordProdDto",ordProdDto);
//        m.addAttribute("pcDto",pcDto);
//     }



     List<OrdProdDto> ordProdDtoList = new ArrayList<>();
     List<ProdCntDto> prodCntDtoList = new ArrayList<>();

     for (OrdDto ord : ordDto) {
         String ordId = ord.getORD_ID();

         // 주문상품명 가져오기
         List<OrdProdDto> ordProdDto = orderListService.getProdNm(ordId);
         ordProdDtoList.addAll(ordProdDto);

         // 상품 Cnt 가져오기
         List<ProdCntDto> prodCntDto = orderListService.getProdCnt(mbrId, ordId);

         // 주문번호 같으면 추가 못하게
         boolean id = false;
         for (ProdCntDto pcDto : prodCntDtoList) {
             if (pcDto.getORD_ID().equals(ordId)) {
                 id = true;
                 break;
             }
         }
         if (!id) {
             prodCntDtoList.addAll(prodCntDto);
         }


     }

     m.addAttribute("ordProdDto", ordProdDtoList);
     m.addAttribute("pcDto", prodCntDtoList);
//     System.out.println("ordProdDto = " + ordProdDtoList);
//     System.out.println("pcDto = " + prodCntDtoList);


     return "/orderList/orderList";
 }

@GetMapping("/orderDetail")
 public String OrderDetail(@RequestParam("orderId") String orderId, Model m){
//    System.out.println("주문상세 진입");

    //주문아이디에 해당하는 상세정보 불러오기
    OrdDto ordDto = orderListService.getOrdDetailList(orderId);

//    System.out.println("주문내역 = " + ordDto);
    m.addAttribute("ordDto",ordDto);

    //주문 상품목록 불러오기
    List<OrdProdInfoDto> opiDto = orderListService.getOrdProdInfo(orderId);

//    System.out.println("opiDto = " + opiDto);
    m.addAttribute("opiDto",opiDto);

    return "/orderList/orderDetailList";
 }






}
