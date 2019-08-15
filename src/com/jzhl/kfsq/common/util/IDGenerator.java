package com.jzhl.kfsq.common.util;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 提现申请ID生成规则
 * 
 * @author Shaw
 *
 */
public class IDGenerator {

	/**
	 * The FieldPosition.
	 */
	private static final FieldPosition HELPER_POSITION = new FieldPosition(0);

	/**
	 * This Format for format the data to special format.
	 */
	private final static Format dateFormat = new SimpleDateFormat(
			"yyyyMMddHHmmssS");

	/**
	 * This Format for format the number to special format.
	 */
	private final static NumberFormat numberFormat = new DecimalFormat("000");

	/**
	 * This int is the sequence number ,the default value is 1.
	 */
	private static volatile int sequence = 1;

	/**
	 * This int is the sequence number ,the MAX value is 9999.
	 */
	private static final int MAX = 999;

	/**
	 * generate ID.
	 * 
	 * @return ID
	 */
	public static synchronized String generateID() {

		StringBuffer result = new StringBuffer("O");

		Calendar nowTime = Calendar.getInstance();
		dateFormat.format(nowTime.getTime(), result, HELPER_POSITION);
		numberFormat.format(sequence, result, HELPER_POSITION);

		if (sequence == MAX) {
			sequence = 1;
		} else {
			sequence++;
		}

		return result.toString();

	}

}
