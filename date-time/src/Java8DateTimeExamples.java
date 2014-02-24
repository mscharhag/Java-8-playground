import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

import static java.time.temporal.TemporalAdjusters.*;

public class Java8DateTimeExamples {

	// This class shows the usage of the Java 8 date/time API
	// For more information have a look at this blog post:
	// http://www.mscharhag.com/2014/02/java-8-datetime-api.html

	private static void dateTimes() {
		// dates, e.g. 2014-02-18

		// the current date
		LocalDate currentDate = LocalDate.now();

		// 2014-02-10
		LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);

		// months values start at 1 (2014-08-01)
		LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);

		// the 65th day of 2010 (2010-03-06)
		LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);


		// times, e.g. 19:12:30.733

		LocalTime currentTime = LocalTime.now(); // current time
		LocalTime midday = LocalTime.of(12, 0); // 12:00
		LocalTime afterMidday = LocalTime.of(13, 30, 15); // 13:30:15

		// 12345th second of day (03:25:45)
		LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);

		// dates with times, e.g. 2014-02-18T19:08:37.950
		LocalDateTime currentDateTime = LocalDateTime.now();

		// 2014-10-02 12:30
		LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);

		// 2014-12-24 12:00
		LocalDateTime christmas2014 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);


		// By default LocalDate and LocalTime will use the system clock in the default time zone
		// We can change this by providing a timezone or an alternative clock implementation

		// current (local) time in Los Angeles
		LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));

		// current time in UTC time zone
		LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());


		System.out.println("date/time creation: currentDate: " + currentDate);
		System.out.println("date/time creation: tenthFeb2014: " + tenthFeb2014);
		System.out.println("date/time creation: firstAug2014: " + firstAug2014);
		System.out.println("date/time creation: sixtyFifthDayOf2010: " + sixtyFifthDayOf2010);
		System.out.println("date/time creation: currentTime: " + currentTime);
		System.out.println("date/time creation: midday: " + midday);
		System.out.println("date/time creation: afterMidday: " + afterMidday);
		System.out.println("date/time creation: fromSecondsOfDay: " + fromSecondsOfDay);
		System.out.println("date/time creation: currentTimeInLosAngeles: " + currentTimeInLosAngeles);
		System.out.println("date/time creation: currentDateTime: " + currentDateTime);
		System.out.println("date/time creation: secondAug2014: " + secondAug2014);
		System.out.println("date/time creation: christmas2014: " + christmas2014);
	}



	private static void dateTimeInformation() {
		LocalDate date = LocalDate.of(2014, 2, 15); // 2014-06-15

		boolean isBefore = LocalDate.now().isBefore(date); // false

		// information about the month
		Month february = date.getMonth(); // FEBRUARY
		int februaryIntValue = february.getValue(); // 2
		int minLength = february.minLength(); // 28
		int maxLength = february.maxLength(); // 29
		Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY

		// information about the year
		int year = date.getYear(); // 2014
		int dayOfYear = date.getDayOfYear(); // 46
		int lengthOfYear = date.lengthOfYear(); // 365
		boolean isLeapYear = date.isLeapYear(); // false

		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int dayOfWeekIntValue = dayOfWeek.getValue(); // 6
		String dayOfWeekName = dayOfWeek.name(); // SATURDAY

		int dayOfMonth = date.getDayOfMonth(); // 15
		LocalDateTime startOfDay = date.atStartOfDay(); // 2014-02-15T00:00

		// time information
		LocalTime time = LocalTime.of(15, 30); // 15:30:00
		int hour = time.getHour(); // 15
		int second = time.getSecond(); // 0
		int minute = time.getMinute(); // 30
		int secondOfDay = time.toSecondOfDay(); // 55800

		System.out.println("dateTimeInformation: february: " + february);
		System.out.println("dateTimeInformation: februaryIntValue: " + februaryIntValue);
		System.out.println("dateTimeInformation: firstMonthOfQuarter: " + firstMonthOfQuarter);
		System.out.println("dateTimeInformation: minLength: " + minLength);
		System.out.println("dateTimeInformation: maxLength: " + maxLength);
		System.out.println("dateTimeInformation: year: " + year);
		System.out.println("dateTimeInformation: dayOfYear: " + dayOfYear);
		System.out.println("dateTimeInformation: lengthOfYear: " + lengthOfYear);
		System.out.println("dateTimeInformation: isLeapYear: " + isLeapYear);
		System.out.println("dateTimeInformation: dayOfWeekName: " + dayOfWeekName);
		System.out.println("dateTimeInformation: dayOfWeekIntValue: " + dayOfWeekIntValue);
		System.out.println("dateTimeInformation: dayOfMonth: " + dayOfMonth);
		System.out.println("dateTimeInformation: startOfDay: " + startOfDay);
		System.out.println("dateTimeInformation: hour: " + hour);
		System.out.println("dateTimeInformation: second: " + second);
		System.out.println("dateTimeInformation: minute: " + minute);
		System.out.println("dateTimeInformation: secondOfDay: " + secondOfDay);
		System.out.println("dateTimeInformation: isBefore: " + isBefore);
	}


	private static void year() {
		Year currentYear = Year.now();
		Year twoThousand = Year.of(2000);
		boolean isLeap = currentYear.isLeap(); // false
		int length = currentYear.length(); // 365

		// sixtyFourth day of 2014 (2014-03-05)
		LocalDate date = Year.of(2014).atDay(64);

		System.out.println("year: currentYear: " + currentYear);
		System.out.println("year: twoThousand: " + twoThousand);
		System.out.println("year: isLeap: " + isLeap);
		System.out.println("year: length: " + length);
		System.out.println("year: date: " + date);
	}


	private static void periodsAndDurations() {

		// periods

		LocalDate firstDate = LocalDate.of(2010, 5, 17); // 2010-05-17
		LocalDate secondDate = LocalDate.of(2015, 3, 7); // 2015-03-07
		Period period = Period.between(firstDate, secondDate);

		int days = period.getDays(); // 18
		int months = period.getMonths(); // 9
		int years = period.getYears(); // 4
		boolean isNegative = period.isNegative(); // false

		Period twoMonthsAndFiveDays = Period.ofMonths(2).plusDays(5);
		LocalDate sixthOfJanuary = LocalDate.of(2014, 1, 6);

		// add two months and five days to 2014-01-06, result is 2014-03-11
		LocalDate eleventhOfMarch = sixthOfJanuary.plus(twoMonthsAndFiveDays);


		// durations

		Instant firstInstant= Instant.ofEpochSecond( 1294881180 ); // 2011-01-13 01:13
		Instant secondInstant = Instant.ofEpochSecond(1294708260); // 2011-01-11 01:11

		Duration between = Duration.between(firstInstant, secondInstant);

		// negative because firstInstant is after secondInstant (-172920)
		long seconds = between.getSeconds();

		// get absolute result in minutes (2882)
		long absoluteResult = between.abs().toMinutes();

		// two hours in seconds (7200)
		long twoHoursInSeconds = Duration.ofHours(2).getSeconds();

		System.out.println("periodsAndDurations: days: " + days);
		System.out.println("periodsAndDurations: months: " + months);
		System.out.println("periodsAndDurations: years: " + years);
		System.out.println("periodsAndDurations: isNegative: " + isNegative);
		System.out.println("periodsAndDurations: eleventhOfMarch: " + eleventhOfMarch);
		System.out.println("periodsAndDurations: seconds: " + seconds);
		System.out.println("periodsAndDurations: absoluteResult: " + absoluteResult);
		System.out.println("periodsAndDurations: twoHoursInSeconds: " + twoHoursInSeconds);
	}


	private static void additionSubtraction() {
		LocalDate tomorrow = LocalDate.now().plusDays(1);

		// before 5 houres and 30 minutes
		LocalDateTime dateTime = LocalDateTime.now().minusHours(5).minusMinutes(30);

		System.out.println("additionSubtraction: tomorrow: " + tomorrow);
		System.out.println("additionSubtraction: dateTime: " + dateTime);
	}


	private static void parsingFormatting() {
		// 2014-04-01 10:45
		LocalDateTime dateTime = LocalDateTime.of(2014, Month.APRIL, 1, 10, 45);

		// format as basic ISO date format (20140220)
		String asBasicIsoDate = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);

		// format as ISO week date (2014-W08-4)
		String asIsoWeekDate = dateTime.format(DateTimeFormatter.ISO_WEEK_DATE);

		// format ISO date time (2014-02-20T20:04:05.867)
		String asIsoDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);

		// using a custom pattern (01/04/2014)
		String asCustomPattern = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		// french date formatting (1. avril 2014)
		String frenchDate = dateTime.format(DateTimeFormatter.ofPattern("d. MMMM yyyy", new Locale("fr")));

		// using short german date/time formatting (01.04.14 10:45)
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("de"));
		String germanDateTime = dateTime.format(formatter);

		// parsing date strings
		LocalDate fromIsoDate = LocalDate.parse("2014-01-20");
		LocalDate fromIsoWeekDate = LocalDate.parse("2014-W14-2", DateTimeFormatter.ISO_WEEK_DATE);
		LocalDate fromCustomPattern = LocalDate.parse("20.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));

		System.out.println("parsingFormatting: asBasicIsoDate: " + asBasicIsoDate);
		System.out.println("parsingFormatting: asIsoWeekDate: " + asIsoWeekDate);
		System.out.println("parsingFormatting: asIsoDateTime: " + asIsoDateTime);
		System.out.println("parsingFormatting: asCustomPattern: " + asCustomPattern);
		System.out.println("parsingFormatting: fromIsoDate: " + fromIsoDate);
		System.out.println("parsingFormatting: fromIsoWeekDate: " + fromIsoWeekDate);
		System.out.println("parsingFormatting: fromCustomPattern: " + fromCustomPattern);
		System.out.println("parsingFormatting: frenchDate: " + frenchDate);
		System.out.println("parsingFormatting: germanDateTime: " + germanDateTime);
	}


	private static void temporalAdjuster() {
		LocalDate date = LocalDate.of(2014, Month.FEBRUARY, 25); // 2014-02-25

		// first day of february 2014 (2014-02-01)
		LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());

		// last day of february 2014 (2014-02-28)
		LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());

		// more fluent using static imports

		// last day of 2014 (2014-12-31)
		LocalDate lastDayOfYear = date.with(lastDayOfYear());

		// first day of next month (2014-03-01)
		LocalDate firstDayOfNextMonth = date.with(firstDayOfNextMonth());

		// next sunday (2014-03-02)
		LocalDate nextSunday = date.with(next(DayOfWeek.SUNDAY));

		System.out.println("temporalAdjuster: firstDayOfMonth: " + firstDayOfMonth);
		System.out.println("temporalAdjuster: lastDayOfMonth: " + lastDayOfMonth);
		System.out.println("temporalAdjuster: lastDayOfYear: " + lastDayOfYear);
		System.out.println("temporalAdjuster: firstDayOfNextMonth: " + firstDayOfNextMonth);
		System.out.println("temporalAdjuster: nextSunday: " + nextSunday);
	}


	private static void timezones() {
		ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
		ZoneId berlin = ZoneId.of("Europe/Berlin");

		// 2014-02-20 12:00
		LocalDateTime dateTime = LocalDateTime.of(2014, 02, 20, 12, 0);

		// 2014-02-20 12:00, Europe/Berlin (+01:00)
		ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, berlin);

		// 2014-02-20 03:00, America/Los_Angeles (-08:00)
		ZonedDateTime losAngelesDateTime = berlinDateTime.withZoneSameInstant(losAngeles);

		int offsetInSeconds = losAngelesDateTime.getOffset().getTotalSeconds(); // -28800

		// a collection of all available zones
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();

		// using offsets
		LocalDateTime date = LocalDateTime.of(2013, Month.JULY, 20, 3, 30);
		ZoneOffset offset = ZoneOffset.of("+05:00");

		// 2013-07-20 22:30 +05:00
		OffsetDateTime plusFive = OffsetDateTime.of(date, offset);

		// 2013-07-19 20:30 -02:00
		OffsetDateTime minusTwo = plusFive.withOffsetSameInstant(ZoneOffset.ofHours(-2));

		System.out.println("timezones: berlinDateTime: " + berlinDateTime);
		System.out.println("timezones: losAngelesDateTime: " + losAngelesDateTime);
		System.out.println("timezones: offsetInSeconds: " + offsetInSeconds);
		System.out.println("timezones: allZoneIds: " + allZoneIds);
		System.out.println("timezones: offset: " + offset);
		System.out.println("timezones: plusFive: " + plusFive);
		System.out.println("timezones: minusTwo: " + minusTwo);
	}


	private static void conversion() {

		// LocalDate/LocalTime <-> LocalDateTime
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTimeFromDateAndTime = LocalDateTime.of(date, time);
		LocalDate dateFromDateTime = LocalDateTime.now().toLocalDate();
		LocalTime timeFromDateTime = LocalDateTime.now().toLocalTime();

		// Instant <-> LocalDateTime
		Instant instant = Instant.now();
		LocalDateTime dateTimeFromInstant = LocalDateTime.ofInstant(instant, ZoneId.of("America/Los_Angeles"));
		Instant instantFromDateTime = LocalDateTime.now().toInstant(ZoneOffset.ofHours(-2));

		// convert from/to old date/calendar/timezone classes
		Instant instantFromDate = new Date().toInstant();
		Instant instantFromCalendar = Calendar.getInstance().toInstant();
		ZoneId zoneId = TimeZone.getDefault().toZoneId();
		ZonedDateTime zonedDateTimeFromGregorianCalendar = new GregorianCalendar().toZonedDateTime();
		Date dateFromInstant = Date.from(Instant.now());
		TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles"));
		GregorianCalendar gregorianCalendar = GregorianCalendar.from(ZonedDateTime.now());
	}


	private static void timestamps() {
		// current time
		Instant now = Instant.now();

		// from unix timestamp, 2010-01-01 12:00:00
		Instant fromUnixTimestamp = Instant.ofEpochSecond(1262347200);

		// same time in millis
		Instant fromEpochMilli = Instant.ofEpochMilli(1262347200000l);

		// parsing from ISO 8601
		Instant fromIso8601 = Instant.parse("2010-01-01T12:00:00Z");

		// toString() returns ISO 8601 format
		String toIso8601 = now.toString();

		// as unix timestamp
		long toUnixTimestamp = now.getEpochSecond();

		// in millis
		long toEpochMillis = now.toEpochMilli();

		// native plusSeconds() method to add 10 seconds
		Instant nowPlusTenSeconds = now.plusSeconds(10);

		// no native support for units like days.
		Instant nowPlusTwoDays = now.plus(2, ChronoUnit.DAYS);
		Instant nowMinusTwoDays = now.minus(Duration.ofDays(2));

		System.out.println("timestamps now: " + now);
		System.out.println("timestamps fromUnixTimestamp: " + fromUnixTimestamp);
		System.out.println("timestamps fromEpochMilli: " + fromEpochMilli);
		System.out.println("timestamps fromIso8601: " + fromIso8601);
		System.out.println("timestamps toIso8601: " + toIso8601);
		System.out.println("timestamps toUnixTimestamp: " + toUnixTimestamp);
		System.out.println("timestamps toEpochMillis: " + toEpochMillis);
		System.out.println("timestamps nowPlusTenSeconds: " + nowPlusTenSeconds);
		System.out.println("timestamps nowPlusTwoDays: " + nowPlusTwoDays);
		System.out.println("timestamps nowMinusTwoDays: " + nowMinusTwoDays);
	}



	public static void main(String[] args) {
		dateTimes();
		dateTimeInformation();
		year();
		temporalAdjuster();
		additionSubtraction();
		timezones();
		timestamps();
		periodsAndDurations();
		parsingFormatting();
		conversion();
	}
}
