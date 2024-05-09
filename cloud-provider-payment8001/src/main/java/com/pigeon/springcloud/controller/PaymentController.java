package com.pigeon.springcloud.controller;

import com.pigeon.springcloud.entities.CommonResult;
import com.pigeon.springcloud.entities.Payment;
import com.pigeon.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value ="/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("insert msg:" + result);
        if (result > 0) {
            return new CommonResult(200, "success", result);
        } else {
            return new CommonResult(444, "fail", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("get msg：" + payment);
        if (payment != null) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(444, "fail: id: "+id, null);
        }
    }

}
