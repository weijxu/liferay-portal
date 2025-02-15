/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.cal;

import com.liferay.portal.kernel.util.TimeZoneUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author Samuel Kong
 * @author Angelo Jefferson
 */
public class TZSRecurrence extends Recurrence {

	public TZSRecurrence() {
	}

	public TZSRecurrence(Calendar startCalendar, Duration duration) {
		super(startCalendar, duration);
	}

	public TZSRecurrence(
		Calendar startCalendar, Duration duration, int frequency) {

		super(startCalendar, duration, frequency);
	}

	public TimeZone getTimeZone() {
		return _timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		if (timeZone == null) {
			_timeZone = null;
		}
		else {
			_timeZone = TimeZoneUtil.getTimeZone(timeZone.getID());
		}
	}

	protected Calendar getAdjustedCalendar(Calendar candidateCalendar) {
		if (_timeZone == null) {
			return candidateCalendar;
		}

		Calendar adjustedCalendar = new GregorianCalendar(_timeZone);

		Date candidateDate = candidateCalendar.getTime();

		long dailightSavingsTimeDelta =
			_timeZone.getOffset(candidateCalendar.getTimeInMillis()) -
				_timeZone.getOffset(dtStart.getTimeInMillis());

		adjustedCalendar.setTimeInMillis(
			candidateDate.getTime() - dailightSavingsTimeDelta);

		return adjustedCalendar;
	}

	@Override
	protected boolean matchesByField(
		int[] array, int field, Calendar candidateCalendar,
		boolean allowNegative) {

		Calendar adjustedCandidate = getAdjustedCalendar(candidateCalendar);

		return super.matchesByField(
			array, field, adjustedCandidate, allowNegative);
	}

	@Override
	protected boolean matchesByMonth(Calendar candidateCalendar) {
		return matchesByField(
			byMonth, Calendar.MONTH, candidateCalendar, false);
	}

	@Override
	protected boolean matchesByMonthDay(Calendar candidateCalendar) {
		return matchesByField(
			byMonthDay, Calendar.DATE, candidateCalendar, true);
	}

	@Override
	protected boolean matchesByWeekNo(Calendar candidateCalendar) {
		return matchesByField(
			byWeekNo, Calendar.WEEK_OF_YEAR, candidateCalendar, true);
	}

	@Override
	protected boolean matchesByYearDay(Calendar candidateCalendar) {
		return matchesByField(
			byYearDay, Calendar.DAY_OF_YEAR, candidateCalendar, true);
	}

	@Override
	protected boolean matchesIndividualByDay(
		Calendar candidateCalendar, DayAndPosition dayAndPosition) {

		Calendar adjustedCandidate = getAdjustedCalendar(candidateCalendar);

		return super.matchesIndividualByDay(adjustedCandidate, dayAndPosition);
	}

	private TimeZone _timeZone;

}