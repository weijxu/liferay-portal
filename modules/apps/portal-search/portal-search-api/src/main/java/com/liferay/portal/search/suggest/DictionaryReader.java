/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.search.suggest;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.util.Iterator;

/**
 * @author Michael C. Han
 */
public class DictionaryReader {

	public DictionaryReader(InputStream inputStream)
		throws UnsupportedEncodingException {

		this(inputStream, StringPool.UTF8);
	}

	public DictionaryReader(InputStream inputStream, String encoding)
		throws UnsupportedEncodingException {

		_utf8 = StringPool.UTF8.equals(encoding);

		_bufferedReader = new BufferedReader(
			new InputStreamReader(inputStream, encoding));
	}

	public void accept(DictionaryVisitor dictionaryVisitor) {
		Iterator<DictionaryEntry> iterator = new DictionaryIterator();

		iterator.forEachRemaining(
			dictionaryEntry -> {
				if (!Validator.isBlank(dictionaryEntry.getWord())) {
					dictionaryVisitor.visitDictionaryEntry(dictionaryEntry);
				}
			});
	}

	public Iterator<DictionaryEntry> getDictionaryEntriesIterator() {
		return new DictionaryIterator();
	}

	private static final int _UNICODE_BYTE_ORDER_MARK = 65279;

	private final BufferedReader _bufferedReader;
	private final boolean _utf8;

	private class DictionaryIterator implements Iterator<DictionaryEntry> {

		@Override
		public boolean hasNext() {
			if (!_calledHasNext) {
				try {
					_line = _bufferedReader.readLine();

					_calledHasNext = true;
				}
				catch (IOException ioException) {
					throw new IllegalStateException(ioException);
				}
			}

			if (_line != null) {
				return true;
			}

			return false;
		}

		@Override
		public DictionaryEntry next() {
			if (!_calledHasNext) {
				hasNext();
			}

			_calledHasNext = false;

			if (_utf8 && !_line.isEmpty() &&
				(_line.charAt(0) == _UNICODE_BYTE_ORDER_MARK)) {

				_line = _line.substring(1);
			}

			return new DictionaryEntry(_line);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		private boolean _calledHasNext;
		private String _line;

	}

}