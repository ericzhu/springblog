package com.webvue.ecom.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.webvue.ecom.domain.support.BaseEntity;

public class Order extends BaseEntity<Long> {

   private static final long serialVersionUID      = 1L;

   private Address           shippingAddress;
   private Address           billingAddress;

   private Account           account;
   private Boolean           billingSameAsShipping = Boolean.TRUE;

   private Date              orderDate;
   private Date              deliveryDate;

   private BigDecimal        totalOrderPrice;

   private List<OrderDetail> orderDetails          = new ArrayList<>();

   public Order() {
      super();
   }

   public Order(Account account) {
      super();
      this.account = account;
      this.shippingAddress = new Address(account.getAddress());
   }

}
