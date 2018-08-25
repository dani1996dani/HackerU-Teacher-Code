package com.company;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class MenuOption {
	public static final String STOP = "stop";
	private String label;
	private OptionSelectedListener listener;
	private int val;
	public static MenuOption[] menuOptions;
	public static boolean shouldRecurse = true;





	public MenuOption(String label, OptionSelectedListener listener) {
		this(label, listener, 0);
	}
	public MenuOption(String label, OptionSelectedListener listener, int val) {
		this.label = label;
		this.listener = listener;
		this.val = val;
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public OptionSelectedListener getListener() {
		return listener;
	}

	public void setListener(OptionSelectedListener listener) {
		this.listener = listener;
	}

	public interface OptionSelectedListener{
		void optionSelected(int val);
	}

	public static void menu(){
		if(menuOptions == null || menuOptions.length == 0)
			throw new InvalidParameterException("no menu options");
		for (int i = 0; i < menuOptions.length; i++) {
			System.out.println((i+1) + ". " + menuOptions[i].getLabel());
		}
		try{
			int option = getIntFromUser("your choice: ", 1,menuOptions.length);
			menuOptions[option-1].getListener().optionSelected(menuOptions[option-1].val);
			if(shouldRecurse)
				menu();
		}catch (CancelException ex){

		}

	}

	public static int getIntFromUser(String message) throws CancelException{
		return getIntFromUser(message, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static int getIntFromUser(String message, int min, int max) throws CancelException {
		Scanner scanner = new Scanner(System.in);
		System.out.print(message);
		String optionString = scanner.next();
		if(optionString.length() == 0){
			System.out.println("must enter something...");
			return getIntFromUser(message, min, max);
		}
		int option = -1;
		if(optionString.equals(STOP))
			throw new CancelException();
		try {
			option = Integer.valueOf(optionString);

		}catch (Exception ex){
			System.out.println("invalid number.");
			return getIntFromUser(message, min, max);
		}
		if(option < min || option > max){
			System.out.println("not in the menu!");
			return getIntFromUser(message, min, max);
		}
		return option;
	}

	public static class CancelException extends Exception{

	}
}
