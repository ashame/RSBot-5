package com.sk.windows;

import org.nathantehbeast.api.framework.context.Context;

public interface Window {
	public static final Window NIL = new Window() {
		@Override
		public boolean open(Context ctx) {
			return false;
		}
		@Override
		public boolean isOpen(Context ctx) {
			return false;
		}
	};
	public boolean open(final Context ctx);
	public boolean isOpen(final Context ctx);
}
