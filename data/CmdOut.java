package myhw2.data;

import myhw2.command.Command;

/**
 * Implementation of command to check out a video.
 * @see Data
 */
final class CmdOut implements Command {
	private InventorySet inventory;
	private Video video;
	CmdOut(InventorySet inventory, Video video) {
		this.inventory = inventory;
		this.video = video;
	}
	public boolean run() {
		// TODO
		return false;
	}
}
