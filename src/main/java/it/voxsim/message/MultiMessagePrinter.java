package it.voxsim.message;

import java.util.Calendar;
import java.util.List;

public class MultiMessagePrinter {
	private String emptyMessage;
	private String formatMessage;

	public MultiMessagePrinter(String emptyMessage, String formatMessage) {
		this.emptyMessage = emptyMessage;
		this.formatMessage = formatMessage;
	}
	
	public String print(String username, List<Message> messages, Calendar timeOfExecution) {
		if (messages.isEmpty())
			return emptyMessage.replace("%{username}", username);

		StringBuilder output = new StringBuilder();
		String separator = "";
		for (Message message : messages) {
			output.append(separator).append(message.description(formatMessage, timeOfExecution));
			separator = "\n";
		}
		return output.toString();
	}
}
