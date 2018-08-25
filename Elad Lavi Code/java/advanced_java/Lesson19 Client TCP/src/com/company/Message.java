package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Message {
	private String content;
	private String sender;

	public Message(String content, String sender) {
		this.content = content;
		this.sender = sender;
	}

	public static Message createFromStream(InputStream inputStream) throws IOException{
		int senderLength = inputStream.read();
		if(senderLength == -1)
			return null;
		byte[] senderBytes = new byte[senderLength];
		int actuallyRead;
		actuallyRead = inputStream.read(senderBytes);
		if(actuallyRead != senderLength)
			throw new IOException("sender length error");
		int messageLength = inputStream.read();
		if(messageLength == -1)
			throw new IOException("message length error");
		byte[] messageBytes = new byte[messageLength];
		actuallyRead = inputStream.read(messageBytes);
		if(actuallyRead != messageLength)
			throw new IOException("message length is not actuallyRead");
		return new Message(new String(messageBytes),new String(senderBytes));
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

	@Override
	public String toString() {
		return sender + ": " + content;
	}
}
