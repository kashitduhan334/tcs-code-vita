package v3.round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Manoj Khanna
 */

public class CommonSchedule {

	private static HashMap<Integer, Leader> leaderMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine());

		String line;
		while (!(line = bufferedReader.readLine()).equals("-1")) {
			String[] strings = line.split(" ");

			int id = Integer.parseInt(strings[0]);
			Leader leader = leaderMap.get(id);
			if (leader == null) {
				leader = new Leader(id);
				leaderMap.put(id, leader);
			}

			leader.addBusyTimeSlot(strings[1], strings[2]);
		}

		for (Leader leader : leaderMap.values()) {
			for (TimeSlot timeSlot : leader.busyTimeSlotList) {
				System.out.println(timeSlot.fromTime.hr + ":" + timeSlot.fromTime.min + " - " +
						timeSlot.toTime.hr + ":" + timeSlot.toTime.min);
			}
			System.out.println("");
		}
	}

	private static class Leader {

		private int id;
		private ArrayList<TimeSlot> busyTimeSlotList = new ArrayList<>();

		private Leader(int id) {
			this.id = id;
		}

		private void addBusyTimeSlot(String fromTimeString, String toTimeString) {
			TimeSlot timeSlot = new TimeSlot(fromTimeString, toTimeString);
			for (TimeSlot busyTimeSlot : busyTimeSlotList) {
				if (busyTimeSlot.merge(timeSlot)) {
					return;
				}
			}

			busyTimeSlotList.add(timeSlot);
		}

	}

	private static class TimeSlot {

		private Time fromTime, toTime;

		private TimeSlot(String fromTimeString, String toTimeString) {
			fromTime = new Time(fromTimeString);
			toTime = new Time(toTimeString);
		}

		private boolean merge(TimeSlot timeSlot) {
			if (fromTime.isBefore(timeSlot.toTime) && fromTime.isAfter(timeSlot.fromTime)) {
				fromTime = timeSlot.fromTime;
				return true;
			} else if (toTime.isAfter(timeSlot.fromTime) && toTime.isBefore(timeSlot.toTime)) {
				toTime = timeSlot.toTime;
				return true;
			}

			return false;
		}

	}

	private static class Time {

		private int hr, min;

		private Time(String timeString) {
			String[] strings = timeString.split(":");
			hr = Integer.parseInt(strings[0]);
			min = Integer.parseInt(strings[1]);
		}

		private boolean isBefore(Time time) {
			return hr < time.hr || (hr == time.hr && min <= time.min);
		}

		private boolean isAfter(Time time) {
			return hr > time.hr || (hr == time.hr && min >= time.min);
		}

	}

}
