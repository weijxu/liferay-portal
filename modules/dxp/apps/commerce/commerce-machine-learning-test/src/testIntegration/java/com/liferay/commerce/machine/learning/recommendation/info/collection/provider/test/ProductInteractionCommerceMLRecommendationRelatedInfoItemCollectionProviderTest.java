/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.machine.learning.recommendation.info.collection.provider.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.commerce.machine.learning.recommendation.ProductInteractionCommerceMLRecommendation;
import com.liferay.commerce.machine.learning.recommendation.ProductInteractionCommerceMLRecommendationManager;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CommerceCatalog;
import com.liferay.commerce.product.test.util.CPTestUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Riccardo Ferrari
 */
@RunWith(Arquillian.class)
public class
	ProductInteractionCommerceMLRecommendationRelatedInfoItemCollectionProviderTest
		extends BaseItemCollectionProviderTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_commerceCatalog = addCommerceCatalog();

		_productInteractionCommerceMLRecommendations =
			_addProductInteractionCommerceMLRecommendations();
	}

	@Override
	protected String getInfoItemCollectionProviderName() {
		return StringBundler.concat(
			"com.liferay.commerce.machine.learning.internal.recommendation.",
			"info.collection.provider.",
			"ProductInteractionCommerceMLRecommendation",
			"RelatedInfoItemCollectionProvider");
	}

	@Override
	protected CPDefinition getRandomRelatedItemObject() throws Exception {
		ProductInteractionCommerceMLRecommendation
			productInteractionCommerceMLRecommendation =
				_productInteractionCommerceMLRecommendations.get(
					RandomTestUtil.randomInt(
						0,
						_productInteractionCommerceMLRecommendations.size() -
							1));

		return cpDefinitionLocalService.fetchCPDefinition(
			productInteractionCommerceMLRecommendation.getEntryClassPK());
	}

	private List<ProductInteractionCommerceMLRecommendation>
			_addProductInteractionCommerceMLRecommendations()
		throws Exception {

		List<ProductInteractionCommerceMLRecommendation>
			productInteractionCommerceMLRecommendations = new ArrayList<>();

		for (int i = 0; i < PRODUCT_COUNT; i++) {
			CPDefinition cpDefinition = CPTestUtil.addCPDefinition(
				_commerceCatalog.getGroupId());

			for (int j = 0; j < RECOMMENDATION_COUNT; j++) {
				CPDefinition recommendedCPDefinition =
					CPTestUtil.addCPDefinition(_commerceCatalog.getGroupId());

				ProductInteractionCommerceMLRecommendation
					productInteractionCommerceMLRecommendation =
						_productInteractionCommerceMLRecommendationManager.
							create();

				productInteractionCommerceMLRecommendation.setCompanyId(
					TestPropsValues.getCompanyId());
				productInteractionCommerceMLRecommendation.setCreateDate(
					new Date());
				productInteractionCommerceMLRecommendation.setEntryClassPK(
					cpDefinition.getCPDefinitionId());
				productInteractionCommerceMLRecommendation.setScore(
					1.0F - (j / 10.0F));
				productInteractionCommerceMLRecommendation.setRank(j);
				productInteractionCommerceMLRecommendation.
					setRecommendedEntryClassPK(
						recommendedCPDefinition.getCPDefinitionId());

				productInteractionCommerceMLRecommendations.add(
					_productInteractionCommerceMLRecommendationManager.
						addProductInteractionCommerceMLRecommendation(
							productInteractionCommerceMLRecommendation));
			}
		}

		return productInteractionCommerceMLRecommendations;
	}

	private CommerceCatalog _commerceCatalog;

	@Inject
	private ProductInteractionCommerceMLRecommendationManager
		_productInteractionCommerceMLRecommendationManager;

	private List<ProductInteractionCommerceMLRecommendation>
		_productInteractionCommerceMLRecommendations;

}