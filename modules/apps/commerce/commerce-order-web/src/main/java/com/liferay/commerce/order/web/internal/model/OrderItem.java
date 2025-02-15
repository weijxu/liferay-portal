/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.order.web.internal.model;

import com.liferay.commerce.frontend.model.ImageField;

import java.util.List;

/**
 * @author Alessio Antonio Rendina
 */
public class OrderItem {

	public OrderItem(
		String deliveryGroup, String discount, String formattedQuantity,
		ImageField image, String name, String options, long orderId,
		long orderItemId, List<OrderItem> orderItems, long parentOrderItemId,
		String price, String requestedDeliveryDate, String sku,
		String subscriptionDuration, String subscriptionPeriod, String total) {

		_deliveryGroup = deliveryGroup;
		_discount = discount;
		_formattedQuantity = formattedQuantity;
		_image = image;
		_name = name;
		_options = options;
		_orderId = orderId;
		_orderItemId = orderItemId;
		_orderItems = orderItems;
		_parentOrderItemId = parentOrderItemId;
		_price = price;
		_requestedDeliveryDate = requestedDeliveryDate;
		_sku = sku;
		_subscriptionDuration = subscriptionDuration;
		_subscriptionPeriod = subscriptionPeriod;
		_total = total;
	}

	public String getDeliveryGroup() {
		return _deliveryGroup;
	}

	public String getDiscount() {
		return _discount;
	}

	public String getFormattedQuantity() {
		return _formattedQuantity;
	}

	public ImageField getImage() {
		return _image;
	}

	public String getName() {
		return _name;
	}

	public String getOptions() {
		return _options;
	}

	public long getOrderId() {
		return _orderId;
	}

	public long getOrderItemId() {
		return _orderItemId;
	}

	public List<OrderItem> getOrderItems() {
		return _orderItems;
	}

	public long getParentOrderItemId() {
		return _parentOrderItemId;
	}

	public String getPrice() {
		return _price;
	}

	public String getRequestedDeliveryDate() {
		return _requestedDeliveryDate;
	}

	public String getSku() {
		return _sku;
	}

	public String getSubscriptionDuration() {
		return _subscriptionDuration;
	}

	public String getSubscriptionPeriod() {
		return _subscriptionPeriod;
	}

	public String getTotal() {
		return _total;
	}

	private final String _deliveryGroup;
	private final String _discount;
	private final String _formattedQuantity;
	private final ImageField _image;
	private final String _name;
	private final String _options;
	private final long _orderId;
	private final long _orderItemId;
	private final List<OrderItem> _orderItems;
	private final long _parentOrderItemId;
	private final String _price;
	private final String _requestedDeliveryDate;
	private final String _sku;
	private final String _subscriptionDuration;
	private final String _subscriptionPeriod;
	private final String _total;

}