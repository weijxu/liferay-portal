/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {useState} from 'react';

import {AppFlowList} from '../../components/NewAppFlowList/AppFlowList';
import {NewAppToolBar} from '../../components/NewAppToolBar/NewAppToolBar';
import {ChoosePricingModelPage} from '../ChoosePricingModelPage/ChoosePricingModelPage';
import {CreateNewAppPage} from '../CreateNewAppPage/CreateNewAppPage';
import {InformLicensingTermsPage} from '../InformLicensingTermsPage/InformLicensingTermsPage';
import {InformLicensingTermsPricePage} from '../InformLicensingTermsPage/InformLicensingTermsPricePage';
import {ProvideAppBuildPage} from '../ProvideAppBuildPage/ProvideAppBuildPage';
import {ProvideAppSupportAndHelpPage} from '../ProvideAppSupportAndHelpPage/ProvideAppSupportAndHelpPage';
import {ProvideVersionDetailsPage} from '../ProvideVersionDetailsPage/ProvideVersionDetailsPage';
import {ReviewAndSubmitAppPage} from '../ReviewAndSubmitAppPage/ReviewAndSubmitAppPage';
import {CustomizeAppStorefrontPage} from '../StorefrontPage/CustomizeAppStorefrontPage';
import {initialFLowListItems} from './AppCreationFlowUtil';

import './AppCreationFlow.scss';
import {Liferay} from '../../liferay/liferay';
import {useAppContext} from '../../manage-app-state/AppManageState';
import {DefineAppProfilePage} from '../DefineAppProfilePage/DefineAppProfilePage';

type SetAppFlowListStateProps = {
	checkedItems?: string[];
	selectedItem: string;
};

export function AppCreationFlow() {
	const [{appERC, appProductId, priceModel}] = useAppContext();
	const [appFlowListItems, setAppFlowListItems] = useState(
		initialFLowListItems
	);
	const [currentFlow, setCurrentFlow] = useState('create');

	const setAppFlowListState = ({
		checkedItems,
		selectedItem,
	}: SetAppFlowListStateProps) => {
		const newAppFlowListItems = appFlowListItems.map((appItem) => {
			if (checkedItems?.includes(appItem.name)) {
				return {
					...appItem,
					checked: true,
					selected: false,
				};
			}

			if (appItem.name === selectedItem) {
				return {
					...appItem,
					checked: false,
					selected: true,
				};
			}

			return {
				...appItem,
				checked: false,
				selected: false,
			};
		});

		setAppFlowListItems(newAppFlowListItems);
	};

	return (
		<div className="app-creation-flow-container">
			<NewAppToolBar
				accountName="Acme Co."
				enableDropdown={currentFlow === 'submit'}
			/>

			<div className="app-creation-flow-body">
				<AppFlowList appFlowListItems={appFlowListItems} />

				{currentFlow === 'create' && (
					<CreateNewAppPage
						onClickContinue={() => {
							setAppFlowListState({
								checkedItems: ['create'],
								selectedItem: 'profile',
							});

							setCurrentFlow('profile');
						}}
					/>
				)}

				{currentFlow === 'profile' && (
					<DefineAppProfilePage
						onClickBack={() => {
							setAppFlowListState({
								selectedItem: 'create',
							});
							setCurrentFlow('create');
						}}
						onClickContinue={() => {
							setAppFlowListState({
								checkedItems: ['create', 'profile'],
								selectedItem: 'build',
							});

							setCurrentFlow('build');
						}}
					/>
				)}

				{currentFlow === 'build' && (
					<ProvideAppBuildPage
						onClickBack={() => {
							setAppFlowListState({
								checkedItems: ['create'],
								selectedItem: 'profile',
							});

							setCurrentFlow('profile');
						}}
						onClickContinue={() => {
							setAppFlowListState({
								checkedItems: ['create', 'profile', 'build'],
								selectedItem: 'storefront',
							});

							setCurrentFlow('storefront');
						}}
					/>
				)}

				{currentFlow === 'storefront' && (
					<CustomizeAppStorefrontPage
						onClickBack={() => {
							setAppFlowListState({
								checkedItems: ['create', 'profile'],
								selectedItem: 'build',
							});

							setCurrentFlow('build');
						}}
						onClickContinue={() => {
							setAppFlowListState({
								checkedItems: [
									'create',
									'profile',
									'build',
									'storefront',
								],
								selectedItem: 'version',
							});

							setCurrentFlow('version');
						}}
					/>
				)}

				{currentFlow === 'version' && (
					<ProvideVersionDetailsPage
						onClickBack={() => {
							setAppFlowListState({
								checkedItems: ['create', 'profile', 'build'],
								selectedItem: 'storefront',
							});

							setCurrentFlow('storefront');
						}}
						onClickContinue={() => {
							setAppFlowListState({
								checkedItems: [
									'create',
									'profile',
									'build',
									'storefront',
									'version',
								],
								selectedItem: 'pricing',
							});

							setCurrentFlow('pricing');
						}}
					/>
				)}

				{currentFlow === 'pricing' && (
					<ChoosePricingModelPage
						onClickBack={() => {
							setAppFlowListState({
								checkedItems: [
									'create',
									'profile',
									'build',
									'storefront',
								],
								selectedItem: 'version',
							});

							setCurrentFlow('version');
						}}
						onClickContinue={() => {
							setAppFlowListState({
								checkedItems: [
									'create',
									'profile',
									'build',
									'storefront',
									'version',
									'pricing',
								],
								selectedItem: 'licensing',
							});

							setCurrentFlow('licensing');
						}}
					/>
				)}

				{currentFlow === 'licensing' && (
					<InformLicensingTermsPage
						onClickBack={() => {
							setAppFlowListState({
								checkedItems: [
									'create',
									'profile',
									'build',
									'storefront',
									'version',
								],
								selectedItem: 'pricing',
							});

							setCurrentFlow('pricing');
						}}
						onClickContinue={() => {
							if (priceModel.value !== 'Free') {
								setAppFlowListState({
									checkedItems: [
										'create',
										'profile',
										'build',
										'storefront',
										'version',
										'pricing',
									],
									selectedItem: 'licensing',
								});

								setCurrentFlow('licensingPrice');
							}
							else {
								setAppFlowListState({
									checkedItems: [
										'create',
										'profile',
										'build',
										'storefront',
										'version',
										'pricing',
										'licensing',
									],
									selectedItem: 'support',
								});

								setCurrentFlow('support');
							}
						}}
					/>
				)}

				{currentFlow === 'licensingPrice' && (
					<InformLicensingTermsPricePage
						onClickBack={() => {
							setAppFlowListState({
								checkedItems: [
									'create',
									'profile',
									'build',
									'storefront',
									'version',
									'pricing',
								],
								selectedItem: 'licensing',
							});

							setCurrentFlow('licensing');
						}}
						onClickContinue={() => {
							setAppFlowListState({
								checkedItems: [
									'create',
									'profile',
									'build',
									'storefront',
									'version',
									'pricing',
									'licensing',
								],
								selectedItem: 'support',
							});

							setCurrentFlow('support');
						}}
					/>
				)}

				{currentFlow === 'support' && (
					<ProvideAppSupportAndHelpPage
						onClickBack={() => {
							if (priceModel.value !== 'Free') {
								setAppFlowListState({
									checkedItems: [
										'create',
										'profile',
										'build',
										'storefront',
										'version',
										'pricing',
									],
									selectedItem: 'licensing',
								});

								setCurrentFlow('licensingPrice');
							}
							else {
								setAppFlowListState({
									checkedItems: [
										'create',
										'profile',
										'build',
										'storefront',
										'version',
										'pricing',
									],
									selectedItem: 'licensing',
								});

								setCurrentFlow('licensing');
							}
						}}
						onClickContinue={() => {
							setAppFlowListState({
								checkedItems: [
									'create',
									'profile',
									'build',
									'storefront',
									'version',
									'pricing',
									'licensing',
									'support',
								],
								selectedItem: 'submit',
							});

							setCurrentFlow('submit');
						}}
					/>
				)}

				{currentFlow === 'submit' && (
					<ReviewAndSubmitAppPage
						onClickBack={() => {
							setAppFlowListState({
								checkedItems: [
									'create',
									'profile',
									'build',
									'storefront',
									'version',
									'pricing',
									'licensing',
									'support',
								],
								selectedItem: 'support',
							});

							setCurrentFlow('support');
						}}
						onClickContinue={() => {
							setAppFlowListState({
								checkedItems: [
									'create',
									'profile',
									'build',
									'storefront',
									'version',
									'pricing',
									'licensing',
									'support',
									'submit',
								],
								selectedItem: '',
							});

							location.href = `${Liferay.ThemeDisplay.getCanonicalURL().replace(
								'/create-new-app',
								'/publisher-dashboard'
							)}`;
						}}
						productERC={appERC}
						productId={appProductId}
					/>
				)}
			</div>
		</div>
	);
}
