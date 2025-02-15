/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.plugin;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jorge Ferrer
 */
public class Version implements Comparable<Version>, Serializable {

	public static final String SNAPSHOT = "SNAPSHOT";

	public static final String UNKNOWN = "unknown";

	public static Version getInstance(String version) {
		Version versionObj = _versions.get(version);

		if (versionObj == null) {
			versionObj = new Version(version);

			_versions.put(version, versionObj);
		}

		return versionObj;
	}

	public static Version incrementBugFix(Version version) {
		String bugFix = version.getBugFix();

		int bugFixInt = GetterUtil.getInteger(bugFix);

		if (bugFixInt > 0) {
			bugFix = String.valueOf(bugFixInt + 1);
		}

		return getInstance(
			_toString(
				version.getMajor(), version.getMinor(), bugFix,
				version.getBuildNumber(), version.getQualifier()));
	}

	public static Version incrementBuildNumber(Version version) {
		String buildNumber = version.getBuildNumber();

		int buildNumberInt = GetterUtil.getInteger(buildNumber);

		if (buildNumberInt > 0) {
			buildNumber = String.valueOf(buildNumberInt + 1);
		}

		return getInstance(
			_toString(
				version.getMajor(), version.getMinor(), version.getBugFix(),
				buildNumber, version.getQualifier()));
	}

	public static Version incrementMajor(Version version) {
		String major = version.getMajor();

		int majorInt = GetterUtil.getInteger(major);

		if (majorInt > 0) {
			major = String.valueOf(majorInt + 1);
		}

		return getInstance(
			_toString(
				major, version.getMinor(), version.getBugFix(),
				version.getBuildNumber(), version.getQualifier()));
	}

	public static Version incrementMinor(Version version) {
		String minor = version.getMinor();

		int minorInt = GetterUtil.getInteger(minor);

		if (minorInt > 0) {
			minor = String.valueOf(minorInt + 1);
		}

		return getInstance(
			_toString(
				version.getMajor(), minor, version.getBugFix(),
				version.getBuildNumber(), version.getQualifier()));
	}

	@Override
	public int compareTo(Version version) {
		if (version == null) {
			return 1;
		}

		// Unknown is always considered a lower version

		if (UNKNOWN.equals(version.toString())) {
			return 1;
		}

		if (UNKNOWN.equals(toString())) {
			return -1;
		}

		int result = _compareAsIntegers(getMajor(), version.getMajor());

		if (result != 0) {
			return result;
		}

		result = _compareAsIntegers(getMinor(), version.getMinor());

		if (result != 0) {
			return result;
		}

		result = _compareAsIntegers(getBugFix(), version.getBugFix());

		if (result != 0) {
			return result;
		}

		result = _compareAsIntegers(getBuildNumber(), version.getBuildNumber());

		if (result != 0) {
			return result;
		}

		return _compareAsQualifiers(getQualifier(), version.getQualifier());
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Version)) {
			return false;
		}

		String versionString1 = toString();
		String versionString2 = String.valueOf((Version)object);

		if (versionString1.equals(UNKNOWN) || versionString2.equals(UNKNOWN)) {
			return false;
		}

		return versionString1.equals(versionString2);
	}

	public String getBugFix() {
		if (_bugFix == null) {
			return "0";
		}

		return _bugFix;
	}

	public String getBuildNumber() {
		return _buildNumber;
	}

	public String getMajor() {
		if (_major == null) {
			return "0";
		}

		return _major;
	}

	public String getMinor() {
		if (_minor == null) {
			return "0";
		}

		return _minor;
	}

	public String getQualifier() {
		if (_qualifier == null) {
			return StringPool.BLANK;
		}

		return _qualifier;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	public boolean includes(Version version) {
		if (equals(version) || getMajor().equals(StringPool.STAR)) {
			return true;
		}

		if (getMajor().equals(version.getMajor())) {
			if (getMinor().equals(StringPool.STAR)) {
				return true;
			}

			if (getMinor().equals(version.getMinor())) {
				if (getBugFix().equals(StringPool.STAR)) {
					return true;
				}

				if (getBugFix().equals(version.getBugFix())) {
					if (getBuildNumber().equals(StringPool.STAR) ||
						getBuildNumber().equals(version.getBuildNumber())) {

						return true;
					}
					else if (_contains(
								getBuildNumber(), version.getBuildNumber())) {

						return true;
					}
				}
				else if (_contains(getBugFix(), version.getBugFix())) {
					return true;
				}
			}
			else if (_contains(getMinor(), version.getMinor())) {
				return true;
			}
		}
		else if (_contains(getMajor(), version.getMajor())) {
			return true;
		}

		return false;
	}

	public boolean isLaterVersionThan(String version) {
		if (compareTo(getInstance(version)) > 0) {
			return true;
		}

		return false;
	}

	public boolean isPreviousVersionThan(String version) {
		if (compareTo(getInstance(version)) < 0) {
			return true;
		}

		return false;
	}

	public boolean isSameVersionAs(String version) {
		if (compareTo(getInstance(version)) == 0) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return _toString(_major, _minor, _bugFix, _buildNumber, _qualifier);
	}

	protected Version(String version) {
		int index = version.indexOf(CharPool.DASH);

		if (index != -1) {
			_qualifier = version.substring(index + 1);

			version = version.substring(0, index);
		}

		StringTokenizer st = new StringTokenizer(version, _SEPARATOR);

		_major = st.nextToken();

		if (st.hasMoreTokens()) {
			_minor = st.nextToken();
		}

		if (st.hasMoreTokens()) {
			_bugFix = st.nextToken();
		}

		if (st.hasMoreTokens()) {
			_buildNumber = st.nextToken();
		}
		else {
			_buildNumber = null;
		}
	}

	private static String _toString(
		String major, String minor, String bugFix, String buildNumber,
		String qualifier) {

		StringBundler sb = new StringBundler(9);

		sb.append(major);

		if (Validator.isNotNull(minor)) {
			sb.append(_SEPARATOR);
			sb.append(minor);

			if (Validator.isNotNull(bugFix)) {
				sb.append(_SEPARATOR);
				sb.append(bugFix);

				if (Validator.isNotNull(buildNumber)) {
					sb.append(_SEPARATOR);
					sb.append(buildNumber);
				}
			}
		}

		if (Validator.isNotNull(qualifier)) {
			sb.append(CharPool.DASH);
			sb.append(qualifier);
		}

		return sb.toString();
	}

	private int _compareAsIntegers(String first, String second) {
		int firstInteger = GetterUtil.getInteger(first);
		int secondInteger = GetterUtil.getInteger(second);

		if (firstInteger < secondInteger) {
			return -1;
		}
		else if (firstInteger == secondInteger) {
			return 0;
		}

		return 1;
	}

	private int _compareAsQualifiers(String first, String second) {
		String firstString = GetterUtil.getString(first);
		String secondString = GetterUtil.getString(second);

		if (StringUtil.equalsIgnoreCase(firstString, SNAPSHOT) &&
			!StringUtil.equalsIgnoreCase(secondString, SNAPSHOT)) {

			return -1;
		}
		else if (!StringUtil.equalsIgnoreCase(firstString, SNAPSHOT) &&
				 StringUtil.equalsIgnoreCase(secondString, SNAPSHOT)) {

			return 1;
		}

		return 0;
	}

	private boolean _contains(String containerString, String numberString) {
		if (containerString.endsWith(StringPool.PLUS)) {
			String containerNumberString = containerString.substring(
				0, containerString.length() - 1);

			try {
				int containerNumber = GetterUtil.getInteger(
					containerNumberString);
				int number = GetterUtil.getInteger(numberString);

				if (containerNumber <= number) {
					return true;
				}

				return false;
			}
			catch (NumberFormatException numberFormatException) {
				if (_log.isDebugEnabled()) {
					_log.debug(numberFormatException);
				}

				return false;
			}
		}

		return false;
	}

	private static final String _SEPARATOR = StringPool.PERIOD;

	private static final Log _log = LogFactoryUtil.getLog(Version.class);

	private static final Map<String, Version> _versions =
		new ConcurrentHashMap<>();

	private String _bugFix;
	private final String _buildNumber;
	private String _major;
	private String _minor;
	private String _qualifier;

}