package com.game.www.wfcc.util;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.ui.CommonDialogFragment;


/**
 * 对话框工具类
 *
 * @author zhangdaweisir
 * @version 1.0
 */
public class ToolAlert {

    private static ProgressDialog mProgressDialog;


    /**
     * 显示ProgressDialog
     *
     * @param context 上下文
     * @param message 消息
     */
    public static void loading(Context context, int message) {

        loading(context, message, true);
    }

    /**
     * 显示ProgressDialog
     *
     * @param context 上下文
     * @param message 消息
     */
    public static void loading(Context context, int message, final ILoadingOnKeyListener listener) {

        loading(context, message, true, listener);
    }

    /**
     * 显示ProgressDialog
     *
     * @param context    上下文
     * @param message    消息
     * @param cancelable 是否可以取消
     */
    public static void loading(Context context, int message, boolean cancelable) {

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context, message);
            mProgressDialog.setCancelable(cancelable);
        }
        if (mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
            mProgressDialog.dismiss();
        }
        mProgressDialog.show();
    }


    /**
     * 显示ProgressDialog
     *
     * @param context 上下文
     * @param message 消息
     */
    public static void loading(Context context, int message, boolean cancelable, final ILoadingOnKeyListener listener) {

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context, message);
            mProgressDialog.setCancelable(cancelable);
        }

        if (mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
            mProgressDialog.dismiss();
        }

        if (null != listener) {
            mProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    listener.onKey(dialog, keyCode, event);
                    return false;
                }
            });
        } else {
            mProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        mProgressDialog.dismiss();
                    }
                    return false;
                }
            });
        }

        mProgressDialog.show();
    }

    /**
     * 判断加载对话框是否正在加载
     *
     * @return 是否
     */
    public static boolean isLoading() {

        if (null != mProgressDialog) {
            return mProgressDialog.isShowing();
        } else {
            return false;
        }
    }

    /**
     * 关闭ProgressDialog
     */
    public static void closeLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    /**
     * 更新ProgressDialog进度消息
     *
     * @param message 消息
     */
    public static void updateProgressText(String message) {
        if (mProgressDialog == null) return;

        if (mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(message);
        }
    }

    /**
     * 弹出对话框
     *
     * @param msg 对话框内容
     */
    public static AlertDialog dialog(Context context, String msg) {
        return dialog(context, "", msg);
    }

    /**
     * 弹出对话框
     *
     * @param title 对话框标题
     * @param msg   对话框内容
     */
    public static AlertDialog dialog(Context context, String title, String msg) {
        return dialog(context, title, msg, null);
    }

    /**
     * 弹出对话框
     *
     * @param title          对话框标题
     * @param msg            对话框内容
     * @param okBtnListenner 确定按钮点击事件
     */
    public static AlertDialog dialog(Context context, String title, String msg, OnClickListener okBtnListenner) {
        return dialog(context, title, msg, okBtnListenner, null);
    }

    /**
     * 弹出对话框
     *
     * @param title              对话框标题
     * @param msg                对话框内容
     * @param okBtnListenner     确定按钮点击事件
     * @param cancelBtnListenner 取消按钮点击事件
     */
    public static AlertDialog dialog(Context context, String title, String msg, OnClickListener okBtnListenner, OnClickListener cancelBtnListenner) {
        return dialog(context, null, title, msg, okBtnListenner, cancelBtnListenner);
    }

    /**
     * 弹出对话框
     *
     * @param title 对话框标题
     * @param msg   对话框内容
     */
    public static AlertDialog dialog(Context context, Drawable icon, String title, String msg) {
        return dialog(context, icon, title, msg, null);
    }

    /**
     * 弹出对话框
     *
     * @param title          对话框标题
     * @param msg            对话框内容
     * @param okBtnListenner 确定按钮点击事件
     */
    public static AlertDialog dialog(Context context, Drawable icon, String title, String msg, OnClickListener okBtnListenner) {
        return dialog(context, icon, title, msg, okBtnListenner, null);
    }

    /**
     * 弹出对话框
     *
     * @param icon               标题图标
     * @param title              对话框标题
     * @param msg                对话框内容
     * @param okBtnListenner     确定按钮点击事件
     * @param cancelBtnListenner 取消按钮点击事件
     */
    public static AlertDialog dialog(Context context, Drawable icon, String title, String msg, final OnClickListener okBtnListenner, final OnClickListener cancelBtnListenner) {
        final AlertDialog alertDialog = new Builder(context).create();
        alertDialog.show();
        Window dialogWindow = alertDialog.getWindow();
//        dialogWindow.setContentView(R.layout.prompt_dialog_layout);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);
        dialogWindow.setAttributes(lp);
        alertDialog.setCanceledOnTouchOutside(false);
        View view = LayoutInflater.from(context).inflate( R.layout.prompt_dialog_layout, null);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }else{
            tvTitle.setVisibility(View.GONE);
        }
        final TextView eTvReason = (TextView) view.findViewById(R.id.eTvReason);
        if (!TextUtils.isEmpty(msg)) {
            eTvReason.setText(msg);
        }
        TextView btnCancel = (TextView) view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancelBtnListenner != null) {
                    cancelBtnListenner.onClick(alertDialog,1);
                }
                alertDialog.dismiss();
            }
        });
        TextView btnOk = (TextView) view.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (okBtnListenner != null) {
                    okBtnListenner.onClick(alertDialog,1);
                }
                alertDialog.dismiss();
            }
        });
        dialogWindow.setContentView(view);

    return alertDialog;



//        Builder dialogBuilder = new Builder(context);
//        if (null != icon) {
//            dialogBuilder.setIcon(icon);
//        }
//        if (!TextUtils.isEmpty(title)) {
//            dialogBuilder.setTitle(title);
//        }
//        dialogBuilder.setMessage(msg);
//        if (null != okBtnListenner) {
//            dialogBuilder.setPositiveButton(android.R.string.ok, okBtnListenner);
//        }
//        if (null != cancelBtnListenner) {
//            dialogBuilder.setNegativeButton(android.R.string.cancel, cancelBtnListenner);
//        }
//        dialogBuilder.create();
//        return dialogBuilder.show();
    }

    /**
     * 弹出一个自定义布局对话框
     *
     * @param context 上下文
     * @param view    自定义布局View
     */
    public static Dialog dialog(Context context, View view) {
        final Dialog builder = new Builder(new ContextThemeWrapper(context, CommonDialogFragment.getDialogTheme())).create();
        builder.show();
        builder.getWindow().setContentView(view);
        return builder;
    }

    /**
     * 弹出一个自定义布局对话框
     *
     * @param context 上下文
     * @param resId   自定义布局View对应的layout id
     */
    public static AlertDialog dialog(Context context, int resId) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resId, null);
        Builder builder = new Builder(context);
        builder.setView(view);
        return builder.show();
    }


    public interface InputListener {
        void click(String inputStr);
    }


    public static Dialog getInput(Context context, String title, String deftStr, String hint, final InputListener cancelListener, final InputListener okListener) {
        try {
            final Dialog dialog = new Dialog(context, R.style.dialog);
            Window dialogWindow = dialog.getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            dialogWindow.setGravity(Gravity.CENTER);
            dialogWindow.setAttributes(lp);
            dialog.setCanceledOnTouchOutside(false);
            View view = LayoutInflater.from(context).inflate(R.layout.reply_dialog_layout, null);
            TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            if (!TextUtils.isEmpty(title)) {
                tvTitle.setText(title);
            }
            final EditText eTvReason = (EditText) view.findViewById(R.id.eTvReason);
            if (!TextUtils.isEmpty(hint)) {
                eTvReason.setHint(hint);
            }
            if (!TextUtils.isEmpty(deftStr)) {
                eTvReason.setText(deftStr);
            }
            TextView btnCancel = (TextView) view.findViewById(R.id.btnCancel);
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cancelListener != null) {
                        String reason = eTvReason.getText().toString();
                        cancelListener.click(reason);
                    }
                    dialog.dismiss();
                }
            });
            TextView btnOk = (TextView) view.findViewById(R.id.btnOk);
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (okListener != null) {
                        String reason = eTvReason.getText().toString();
                        okListener.click(reason);
                        dialog.dismiss();
                    }
                    dialog.dismiss();
                }
            });
            dialog.setContentView(view);
            dialog.show();
            return dialog;
        } catch (RuntimeException e) {
            return null;
        }
    }

    public static Dialog getLoading(Context context, String msg) {
        try {
            Dialog dialog = new Dialog(context, R.style.new_circle_progress);
            Window dialogWindow = dialog.getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            dialogWindow.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            dialogWindow.setGravity(Gravity.CENTER);
            dialogWindow.setAttributes(lp);
            View view = LayoutInflater.from(context).inflate(R.layout.layout_progressbar, null);
            TextView tv = (TextView) view.findViewById(R.id.emptyView);
            if (!TextUtils.isEmpty(msg)) {
                tv.setText(msg);
            }
            ViewGroup.LayoutParams params = new LayoutParams(400, 300);
            dialog.setContentView(view, params);
            dialog.show();
            return dialog;
        } catch (RuntimeException e) {
            return null;
        }
    }

    /**
     * 弹出较短的Toast消息
     *
     * @param msg 消息内容
     */
    public static void toastShort(String msg) {
        Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出较短的Toast消息
     *
     * @param msg 消息内容
     */
    public static void toastShort(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出较长的Toast消息
     *
     * @param msg 消息内容
     */
    public static void toastLong(String msg) {
        Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 弹出较长的Toast消息
     *
     * @param msg 消息内容
     */
    public static void toastLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 弹出自定义时长的Toast消息
     *
     * @param msg 消息内容
     */
    public static void toast(String msg, int duration) {
        Toast.makeText(MyApplication.getInstance(), msg, duration).show();
    }

    /**
     * 弹出自定义时长的Toast消息
     *
     * @param msg 消息内容
     */
    public static void toast(Context context, String msg, int duration) {
        Toast.makeText(context, msg, duration).show();
    }

    /**
     * 弹出Pop窗口
     *
     * @param context 依赖界面上下文
     * @param anchor  触发pop界面的控件
     * @param viewId  pop窗口界面layout
     * @param xoff    窗口X偏移量
     * @param yoff    窗口Y偏移量
     */
    public static PopupWindow popwindow(Context context, View anchor, int viewId, int xoff, int yoff) {
        ViewGroup menuView = (ViewGroup) LayoutInflater.from(context).inflate(viewId, null);
        PopupWindow pw = new PopupWindow(menuView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
        pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pw.setTouchable(true);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.showAsDropDown(anchor, xoff, yoff);
        pw.update();
        return pw;
    }

    /**
     * 弹出Pop窗口
     *
     * @param anchor  触发pop界面的控件
     * @param popView pop窗口界面
     * @param xoff    窗口X偏移量
     * @param yoff    窗口Y偏移量
     */
    public static PopupWindow popwindow(View anchor, View popView, int xoff, int yoff) {
        PopupWindow pw = new PopupWindow(popView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
        pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pw.setOutsideTouchable(true);
        pw.showAsDropDown(anchor, xoff, yoff);
        pw.update();
        return pw;
    }

    /**
     * 弹出Pop窗口（可设置是否点击其他地方关闭窗口）
     *
     * @param context          依赖界面上下文
     * @param anchor           触发pop界面的控件
     * @param viewId           pop窗口界面layout
     * @param xoff             窗口X偏移量
     * @param yoff             窗口Y偏移量
     * @param outSideTouchable 点击其他地方是否关闭窗口
     */
    public static PopupWindow popwindow(Context context, View anchor, int viewId, int xoff, int yoff, boolean outSideTouchable) {
        ViewGroup menuView = (ViewGroup) LayoutInflater.from(context).inflate(viewId, null);
        PopupWindow pw = new PopupWindow(menuView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
        pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pw.setTouchable(outSideTouchable);
        pw.setFocusable(outSideTouchable);
        pw.setOutsideTouchable(outSideTouchable);
        pw.showAsDropDown(anchor, xoff, yoff);
        pw.update();
        return pw;
    }
    /**
     * 弹出Pop全屏窗口（可设置是否点击其他地方关闭窗口）
     *
     * @param context          依赖界面上下文
     * @param anchor           触发pop界面的控件
     * @param viewId           pop窗口界面layout
     * @param xoff             窗口X偏移量
     * @param yoff             窗口Y偏移量
     * @param outSideTouchable 点击其他地方是否关闭窗口
     */

    private static PopupWindow fullScreenPw;
    public static View fullScreenPopwindow(Context context, View anchor, int viewId, int xoff, int yoff, boolean outSideTouchable) {
        View menuView =  LayoutInflater.from(context).inflate(viewId, null);
        fullScreenPw = new PopupWindow(menuView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, true);
        fullScreenPw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fullScreenPw.setTouchable(outSideTouchable);
        fullScreenPw.setFocusable(outSideTouchable);
        fullScreenPw.setOutsideTouchable(outSideTouchable);
        fullScreenPw.showAsDropDown(anchor, xoff, yoff);
        fullScreenPw.update();
        return menuView;
    }

    public static void finishPw(){
        fullScreenPw.dismiss();
    }

    /**
     * 弹出Pop窗口（可设置是否点击其他地方关闭窗口）
     *
     * @param anchor           触发pop界面的控件
     * @param popView          pop窗口界面
     * @param xoff             窗口X偏移量
     * @param yoff             窗口Y偏移量
     * @param outSideTouchable 点击其他地方是否关闭窗口
     */
    public static PopupWindow popwindow(View anchor, View popView, int xoff, int yoff, boolean outSideTouchable) {
        PopupWindow pw = new PopupWindow(popView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
        pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pw.setOutsideTouchable(outSideTouchable);
        pw.showAsDropDown(anchor, xoff, yoff);
        pw.update();

        return pw;
    }

    /**
     * 指定坐标弹出Pop窗口
     *
     * @param pw      pop窗口对象
     * @param anchor  触发pop界面的控件
     * @param popView pop窗口界面
     * @param x       窗口X
     * @param y       窗口Y
     */
    public static PopupWindow popwindowLoction(PopupWindow pw, View anchor, View popView, int x, int y) {
        if (pw == null) {
            pw = new PopupWindow(popView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
            pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            pw.setOutsideTouchable(false);
        }

        if (pw.isShowing()) {
            pw.update(x, y, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        } else {
            pw.showAtLocation(anchor, Gravity.NO_GRAVITY, x, y);
        }

        return pw;
    }

    /**
     * Loading监听对话框
     */
    public interface ILoadingOnKeyListener {
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event);
    }


}
