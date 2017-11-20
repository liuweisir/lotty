package com.game.www.wfcc.ui;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.game.www.wfcc.R;

public class CommonDialogFragment extends DialogFragment {
	private DialogInterface.OnClickListener onClickListener, onCancelListener;
	private View _view;
	private String _title;

	public static CommonDialogFragment newInstance(View view, String title,
			DialogInterface.OnClickListener onOkClickListener, DialogInterface.OnClickListener onCancelListener) {
		CommonDialogFragment dialogFragment = new CommonDialogFragment();
		dialogFragment._view = view;
		dialogFragment._title = title;
		dialogFragment.onClickListener = onOkClickListener;
		dialogFragment.onCancelListener = onCancelListener;

		return dialogFragment;
	}

	public static int getDialogTheme() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? android.R.style.Theme_Holo_Light_Dialog
				: android.R.style.Theme_Holo_Dialog;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), getDialogTheme()));

		builder.setView(_view).setTitle(_title).setPositiveButton( R.string.button_ok, onClickListener)
				.setNegativeButton( R.string.button_cancel, onCancelListener);

		return builder.create();
	}

}
