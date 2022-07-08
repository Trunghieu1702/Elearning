package edu.mta.Elearning.entity;

public class Types {
	public enum typeContents {
		BUTTON(-1),
		FOLDER(0),
		FILE(1);
		
		private int value;
		 
        private typeContents(int value) {
            this.value = value;
        }
	}
}
