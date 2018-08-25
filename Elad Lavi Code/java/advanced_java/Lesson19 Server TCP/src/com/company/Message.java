package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Message {
	private String content;
	private String sender;
	private long timeStamp;

	public Message(String content, String sender) {
		this.content = content;
		this.sender = sender;
		timeStamp = System.currentTimeMillis();
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void write(OutputStream outputStream) throws IOException {
		byte[] senderBytes = sender.getBytes();
		outputStream.write(senderBytes.length);
		outputStream.write(senderBytes);
		byte[] messageBytes = content.getBytes();
		outputStream.write(messageBytes.length);
		outputStream.write(messageBytes);


	}
}
