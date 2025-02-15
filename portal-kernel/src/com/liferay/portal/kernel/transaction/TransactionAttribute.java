/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.transaction;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Shuyang Zhou
 */
@ProviderType
public interface TransactionAttribute {

	public Isolation getIsolation();

	public Propagation getPropagation();

	public boolean isReadOnly();

	public boolean isStrictReadOnly();

	public static class Builder {

		public TransactionAttribute build() {
			return new DefaultTransactionAttribute(this);
		}

		public Builder setIsolation(Isolation isolation) {
			_isolation = isolation;

			return this;
		}

		public Builder setPropagation(Propagation propagation) {
			_propagation = propagation;

			return this;
		}

		public Builder setReadOnly(boolean readOnly) {
			_readOnly = readOnly;

			return this;
		}

		public Builder setStrictReadOnly(boolean strictReadOnly) {
			if (strictReadOnly) {
				_readOnly = true;
			}

			_strictReadOnly = strictReadOnly;

			return this;
		}

		private Isolation _isolation = Isolation.DEFAULT;
		private Propagation _propagation = Propagation.REQUIRED;
		private boolean _readOnly;
		private boolean _strictReadOnly;

	}

	public static class DefaultTransactionAttribute
		implements TransactionAttribute {

		@Override
		public Isolation getIsolation() {
			return _isolation;
		}

		@Override
		public Propagation getPropagation() {
			return _propagation;
		}

		@Override
		public boolean isReadOnly() {
			return _readOnly;
		}

		@Override
		public boolean isStrictReadOnly() {
			return _strictReadOnly;
		}

		private DefaultTransactionAttribute(Builder builder) {
			_isolation = builder._isolation;
			_propagation = builder._propagation;
			_readOnly = builder._readOnly;
			_strictReadOnly = builder._strictReadOnly;
		}

		private final Isolation _isolation;
		private final Propagation _propagation;
		private final boolean _readOnly;
		private final boolean _strictReadOnly;

	}

}