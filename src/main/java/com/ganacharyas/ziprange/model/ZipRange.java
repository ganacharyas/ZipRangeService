package com.ganacharyas.ziprange.model;

/**
 * Model object representing single Range
 * @author Santosh Ganacharya
 *
 */
public class ZipRange {

	private int lower;
	private int upper;

	public ZipRange(int lower, int upper) {
		if (lower < upper) {
			this.lower = lower;
			this.upper = upper;
		} else {
			this.lower = upper;
			this.upper = lower;
		}
	}

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}

	public String toString() {
		return String.format("[%d,%d]", this.lower, this.upper);
	}

}
